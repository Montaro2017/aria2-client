package cn.montaro.aria2.client.websocket;


import cn.montaro.aria2.api.Aria2Client;
import cn.montaro.aria2.client.websocket.constants.Aria2Method;
import cn.montaro.aria2.client.websocket.exception.Aria2WebSocketClientConnectTimeoutException;
import cn.montaro.aria2.client.websocket.exception.Aria2WebSocketClientException;
import cn.montaro.aria2.client.websocket.exception.Aria2WebSocketClientTimeoutException;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.exceptions.WebsocketNotConnectedException;
import org.java_websocket.handshake.ServerHandshake;

import java.lang.reflect.Type;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;


/**
 * Description:
 *
 * @author ZhangJiaYu
 * @date 2021/12/15
 */
@Slf4j
public class Aria2WebSocketClient extends WebSocketClient implements Aria2Client {

    private Gson gson = null;
    private Aria2WebSocketConfig config = null;
    private final Map<String, Aria2WebSocketResponse> resultValueMap = new ConcurrentHashMap<>();
    private final Map<String, Type> resultTypeMap = new ConcurrentHashMap<>();
    private final Map<String, Aria2WebSocketClientException> resultExceptionMap = new ConcurrentHashMap<>();

    @SneakyThrows
    public Aria2WebSocketClient(Aria2WebSocketConfig config) {
        super(config.getURI());
        this.connectBlocking(config.getTimeout(), TimeUnit.MILLISECONDS);
        this.config = config;
        this.gson = new GsonBuilder().create();
        if (!this.isOpen()) {
            throw new Aria2WebSocketClientConnectTimeoutException(config.getURI(), config.getTimeout());
        }
    }

    private JsonElement getJsonElement(Object... val) {
        ArrayList<Object> params = new ArrayList<>(Arrays.asList(val));
        String secret = "token:";
        if (config.getSecret() != null) {
            secret += config.getSecret();
        }
        params.add(0, secret);
        int size = params.size();
        ListIterator<Object> listIterator = params.listIterator(size);
        while (listIterator.hasPrevious()) {
            Object previous = listIterator.previous();
            if (previous == null) {
                listIterator.remove();
            } else {
                break;
            }
        }
        return gson.toJsonTree(params);
    }

    /**
     * 通过参数构建请求
     *
     * @param method     Aria2调用方法
     * @param resultType 返回结果类型
     * @return 请求
     */
    private Aria2WebSocketRequest buildRequest(String method, Type resultType, Object... params) {
        Aria2WebSocketRequest request = new Aria2WebSocketRequest();
        String id = UUID.randomUUID().toString();
        request.setId(id);
        request.setMethod(method);
        request.setParams(this.getJsonElement(params));
        this.saveMap(id, resultType);
        return request;
    }

    /**
     * 序列化请求为Json格式
     *
     * @param request 请求参数
     * @return 序列化成Json的请求内容
     */
    private String serialize(Aria2WebSocketRequest request) {
        return this.gson.toJson(request);
    }

    /**
     * 保存id关系映射结果
     *
     * @param id         id
     * @param resultType 结果结果类型
     */
    private void saveMap(String id, Type resultType) {
        // this.resultValueMap.put(id, null);
        this.resultTypeMap.put(id, resultType);
        // this.resultExceptionMap.put(id, null);
    }

    /**
     * 发送请求
     *
     * @param request 请求
     */
    private void sendRequest(Aria2WebSocketRequest request) {
        String body = this.serialize(request);
        log.debug("Send Request:{}", body);
        try {
            this.send(body);
        } catch (WebsocketNotConnectedException e) {

        }
    }

    /**
     * 等待结果返回
     *
     * @param id  id
     * @param <T> 返回结果类型
     * @return
     */
    @SneakyThrows
    private <T> T waitResult(String id) {
        Aria2WebSocketResponse<T> result = null;
        Date startTime = new Date();
        while ((result = this.resultValueMap.get(id)) == null) {
            Aria2WebSocketClientException exception = this.resultExceptionMap.get(id);
            if (exception != null) {
                this.clearMap(id);
                throw exception;
            }

            boolean isStop = (new Date().getTime() - startTime.getTime()) >= this.config.getTimeout();
            if (isStop) {
                throw new Aria2WebSocketClientTimeoutException();
            }
        }
        this.clearMap(id);
        return result.getResult();
    }

    /**
     * 清理id映射关系
     *
     * @param id id
     */
    private void clearMap(String id) {
        this.resultValueMap.remove(id);
        this.resultTypeMap.remove(id);
        this.resultExceptionMap.remove(id);
    }

    public String addUri(String[] uris) {
        List<String> uriList = Arrays.asList(uris);
        return this.addUri(uriList, null, null);
    }

    @Override
    public String addUri(List<String> uris, Map<String, String> option, Integer position) {
        Aria2WebSocketRequest request = this.buildRequest(
                Aria2Method.ADD_URI,
                new TypeToken<Aria2WebSocketResponse<String>>() {
                }.getType(),
                uris,
                option,
                position
        );
        String id = request.getId();
        this.sendRequest(request);
        return this.waitResult(id);
    }


    @Override
    public List<String> listMethods() {
        Aria2WebSocketRequest request = this.buildRequest(
                Aria2Method.LIST_METHODS,
                new TypeToken<Aria2WebSocketResponse<List<String>>>() {
                }.getType()
        );
        String id = request.getId();
        this.sendRequest(request);
        return this.waitResult(id);
    }

    @Override
    public String remove(String s) {
        return null;
    }

    @Override
    public String forceRemove(String s) {
        return null;
    }

    @Override
    public String pause(String s) {
        return null;
    }

    @Override
    public String forcePause(String s) {
        return null;
    }

    @Override
    public String pauseAll() {
        return null;
    }

    @Override
    public String forcePauseAll() {
        return null;
    }

    @Override
    public String unpause(String s) {
        return null;
    }

    @Override
    public void tellStatus(String gid) {

    }

    // --------------WebSocket Client--------------

    @Override
    public void tellStopped(Integer offset, Integer num, String[] keys) {

    }

    @Override
    public void changePosition(String gid, Integer pos, String how) {

    }


    @Override
    public void onOpen(ServerHandshake serverHandshake) {

    }

    @Override
    public void onMessage(String message) {
        log.debug("onMessage : {}", message);
        JsonElement jsonElement = JsonParser.parseString(message);
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        String id = jsonObject.get("id").getAsString();
        if (id == null) {
            return;
        }

        try {
            JsonObject error = jsonObject.getAsJsonObject("error");
            if (error != null) {
                System.out.println("put exception");
                String errorMessage = error.get("message").getAsString();
                this.resultExceptionMap.put(id, new Aria2WebSocketClientException(errorMessage));
                return;
            }

            Type resultType = this.resultTypeMap.get(id);
            Aria2WebSocketResponse result = null;
            try {
                result = gson.fromJson(jsonElement, resultType);
            } catch (Exception e) {
                this.resultExceptionMap.put(id, new Aria2WebSocketClientException(e));
            }
            this.resultValueMap.put(id, result);
        } catch (Exception e) {
            this.resultExceptionMap.put(id, new Aria2WebSocketClientException(e));
        }
    }

    @Override
    @SneakyThrows
    public void onClose(int code, String reason, boolean remote) {
        this.reconnectBlocking();
    }

    @Override
    public void onError(Exception ex) {

    }
}
