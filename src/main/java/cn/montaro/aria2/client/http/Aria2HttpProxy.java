package cn.montaro.aria2.client.http;

import cn.hutool.http.HttpUtil;
import cn.montaro.aria2.Aria2Config;
import cn.montaro.aria2.annotation.Aria2Method;
import com.google.gson.*;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;
import java.util.UUID;

public class Aria2HttpProxy implements InvocationHandler {

    private final Gson gson;
    private final Aria2Config config;

    public Aria2HttpProxy(Aria2Config config) {
        this.config = config;
        this.gson = new GsonBuilder().create();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Aria2Method aria2Method = method.getDeclaredAnnotation(Aria2Method.class);
        String methodName = aria2Method.value();
        Type resultType = method.getGenericReturnType();
        String body = this.serialize(methodName, args);
        String json = this.request(body);
        Object result = this.deserialize(json, resultType);
        return result;
    }

    private String serialize(String methodName, Object[] args) {
        Aria2HttpRequest request = new Aria2HttpRequest();
        request.setId(UUID.randomUUID().toString());
        request.setMethod(methodName);
        request.setParams(serializeArguments(args));
        return gson.toJson(request);
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


    private String request(String body) {
        String url = config.url();
        String json = HttpUtil.post(url, body);
        return json;
    }

    private Object deserialize(String json, Type resultType) {
        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
        JsonElement result = jsonObject.get("result");
        if (result instanceof JsonObject && resultType.equals(String.class)) {
            return result.toString();
        }
        if (resultType.equals(String.class)) {
            return result.getAsString();
        }
        return gson.fromJson(result, resultType);
    }
}
