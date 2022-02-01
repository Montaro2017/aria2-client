package cn.montaro.aria2.client.websocket;

import cn.montaro.aria2.annotation.Aria2Method;
import cn.montaro.aria2.client.websocket.exception.Aria2WebSocketClientException;
import com.google.gson.*;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @author ZhangJiaYu
 * @date 2021/12/22
 */
@Slf4j
public class Aria2WebSocketProxy implements InvocationHandler {

    private final Gson gson;
    private final WebSocketImpl webSocket;
    private final Aria2WebSocketConfig config;

    @SneakyThrows
    public Aria2WebSocketProxy(Aria2WebSocketConfig config) {
        this.config = config;
        this.gson = new GsonBuilder().create();
        this.webSocket = new WebSocketImpl(config.getURI());
        this.webSocket.connectBlocking(config.getTimeout(), TimeUnit.MILLISECONDS);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Aria2Method aria2Method = method.getDeclaredAnnotation(Aria2Method.class);
        String methodName = aria2Method.value();
        Aria2WebSocketRequest request = this.buildRequest(methodName, args);
        Object o = this.sendRequest(request, method.getGenericReturnType());
        return o;
    }

    /**
     * 序列化参数
     *
     * @param args
     * @return
     */
    private JsonElement serializeArguments(Object[] args) {
        ArrayList<Object> arguments = new ArrayList<>();
        if (args != null && args.length != 0) {
            arguments = new ArrayList<>(Arrays.asList(args));
        }
        String secret = "token:";
        if (config.getSecret() != null) {
            secret += config.getSecret();
        }
        arguments.add(0, secret);
        int size = arguments.size();
        ListIterator<Object> listIterator = arguments.listIterator(size);
        while (listIterator.hasPrevious()) {
            Object previous = listIterator.previous();
            if (previous == null) {
                listIterator.remove();
            } else {
                break;
            }
        }
        return gson.toJsonTree(arguments);
    }

    private String serializeRequest(Aria2WebSocketRequest request) {
        return this.gson.toJson(request);
    }

    /**
     * 构建请求体
     *
     * @param methodName 调用方法名称 如 aria2.addUri
     * @param args       参数
     * @return
     */
    private Aria2WebSocketRequest buildRequest(String methodName, Object[] args) {
        Aria2WebSocketRequest request = new Aria2WebSocketRequest();
        String id = UUID.randomUUID().toString();
        request.setId(id);
        request.setMethod(methodName);
        request.setParams(serializeArguments(args));
        return request;
    }


    private <T> T sendRequest(Aria2WebSocketRequest request, Type resultType) {
        String id = request.getId();
        String body = serializeRequest(request);
        log.debug("send body:{}", body);
        webSocket.send(body);
        JsonObject returnResult = null;
        while ((returnResult = this.webSocket.getResponse(id)) == null) {
            Aria2WebSocketClientException exception = this.webSocket.getException(id);
            if (exception != null) {
                throw exception;
            }
        }
        JsonElement result = returnResult.get("result");
        if (resultType.equals(String.class)) {
            return (T) result.getAsString();
        }
        return gson.fromJson(result, resultType);
    }

    ////////////////////////// WebSocket Client //////////////////////////

    private class WebSocketImpl extends WebSocketClient {

        private final Map<String, JsonObject> resultValueMap = new HashMap<>();
        private final Map<String, Aria2WebSocketClientException> resultExceptionMap = new HashMap<>();

        public WebSocketImpl(URI serverUri) {
            super(serverUri);
        }

        public JsonObject getResponse(String id) {
            JsonObject result = resultValueMap.get(id);
            if (result != null) {
                resultValueMap.remove(id);
                return result;
            }
            return null;
        }

        public Aria2WebSocketClientException getException(String id) {
            Aria2WebSocketClientException exception = resultExceptionMap.get(id);
            if (exception != null) {
                resultExceptionMap.remove(id);
                return exception;
            }
            return null;
        }

        @Override
        public void onOpen(ServerHandshake handshakedata) {

        }

        @Override
        public void onMessage(String message) {
            log.debug("receive message:{}", message);
            JsonObject jsonObject = JsonParser.parseString(message).getAsJsonObject();
            JsonElement idObj = jsonObject.get("id");
            if (idObj == null) {
                return;
            }
            String id = idObj.getAsString();
            if (id == null) {
                return;
            }
            try {
                JsonObject error = jsonObject.getAsJsonObject("error");
                if (error != null) {
                    String errorMessage = error.get("message").getAsString();
                    this.resultExceptionMap.put(id, new Aria2WebSocketClientException(errorMessage));
                    return;
                }
                this.resultValueMap.put(id, jsonObject);
            } catch (Exception e) {
                this.resultExceptionMap.put(id, new Aria2WebSocketClientException(e));
            }
        }

        @Override
        public void onClose(int code, String reason, boolean remote) {

        }

        @Override
        public void onError(Exception ex) {

        }
    }
}
