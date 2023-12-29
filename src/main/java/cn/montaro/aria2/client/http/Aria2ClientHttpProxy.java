package cn.montaro.aria2.client.http;

import cn.montaro.aria2.Aria2Config;
import cn.montaro.aria2.ProxyHandler;
import cn.montaro.aria2.annotation.Aria2Method;
import cn.montaro.aria2.exception.Aria2Exception;
import cn.montaro.aria2.model.Aria2Request;
import cn.montaro.aria2.model.Aria2Response;
import com.google.gson.*;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import java.io.IOException;
import java.lang.invoke.WrongMethodTypeException;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.*;

@Slf4j
public class Aria2ClientHttpProxy extends ProxyHandler {

    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private static final String TOKEN_PREFIX = "token:";

    private final Gson gson;
    private final Aria2Config config;
    private final OkHttpClient okHttpClient;

    public Aria2ClientHttpProxy(Gson gson, Aria2Config config, Class<?> interfaceClass) {
        this(gson, config, new OkHttpClient(), interfaceClass);
    }

    public Aria2ClientHttpProxy(Gson gson, Aria2Config config, OkHttpClient okHttpClient, Class<?> interfaceClass) {
        super(interfaceClass);
        this.gson = gson;
        this.config = config;
        this.okHttpClient = okHttpClient;
    }

    @Override
    public Object invoke0(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = getAria2MethodName(method);
        Request request = buildRequest(methodName, args);
        String json = sendRequest(request);
        return toReturnType(json, method.getGenericReturnType());
    }

    private String getAria2MethodName(Method method) {
        Aria2Method aria2Method = method.getAnnotation(Aria2Method.class);
        if (aria2Method == null) {
            throw new WrongMethodTypeException();
        }
        return aria2Method.value();
    }

    private Request buildRequest(String methodName, Object[] args) {
        String url = config.url();
        String body = buildRequestBody(methodName, args);
        log.debug(" Request  ==> {}", body);
        return new Request.Builder()
                .url(url)
                .post(RequestBody.create(body, JSON))
                .build();
    }

    private String sendRequest(Request request) throws IOException {
        try (Response response = okHttpClient.newCall(request).execute()) {
            String responseBody = response.body().string();
            log.debug(" Response <== {}", responseBody);
            return responseBody;
        }
    }

    private String buildRequestBody(String methodName, Object[] args) {
        Aria2Request request = new Aria2Request();
        request.setId(UUID.randomUUID().toString());
        request.setMethod(methodName);
        request.setParams(buildRequestParams(args));
        return gson.toJson(request);
    }

    private JsonElement buildRequestParams(Object[] args) {
        List<Object> params = new ArrayList<>();
        if (args != null) {
            params.addAll(Arrays.asList(args));
        }
        // 添加token
        if (config.getSecret() != null && !config.getSecret().isEmpty()) {
            params.add(0, TOKEN_PREFIX + config.getSecret());
        }
        // 删除params末尾连续的null值
        ListIterator<Object> it = params.listIterator(params.size());
        while (it.hasPrevious()) {
            Object previous = it.previous();
            boolean nullValue = previous == null;
            if (previous instanceof Object[]) {
                Object[] arr = (Object[]) previous;
                if (arr.length == 0) {
                    nullValue = true;
                }
            }
            if (nullValue) {
                it.remove();
            } else {
                break;
            }
        }
        return gson.toJsonTree(params);
    }

    private Object toReturnType(String json, Type returnType) {
        Aria2Response response = gson.fromJson(json, Aria2Response.class);
        Aria2Response.Error error = response.getError();
        if (error != null) {
            throw new Aria2Exception("code = " + error.getCode() + ", message = " + error.getMessage());
        }
        JsonElement result = response.getResult();
        if (returnType.equals(String.class)) {
            return result.getAsString();
        }
        if (returnType.equals(Boolean.class)) {
            String boolResult = result.getAsString();
            return "OK".equals(boolResult);
        }
        String resultJson = result.toString();
        return gson.fromJson(resultJson, returnType);
    }
}
