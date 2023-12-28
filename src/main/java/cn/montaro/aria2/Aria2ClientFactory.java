package cn.montaro.aria2;

import cn.montaro.aria2.client.http.Aria2HttpProxy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Proxy;

/**
 * Description:
 *
 * @author ZhangJiaYu
 * @date 2021/12/22
 */
public class Aria2ClientFactory {

    private static final Gson GSON = new GsonBuilder().create();

    private Aria2ClientFactory() {
    }

    private static ClassLoader getClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

//    public static Aria2Client webSocketClient(Aria2Config config) {
//        ClassLoader classLoader = getClassLoader();
//        Aria2WebSocketProxy proxy = new Aria2WebSocketProxy(config);
//        return (Aria2Client) Proxy.newProxyInstance(classLoader, new Class[]{Aria2Client.class}, proxy);
//    }

    public static Aria2Client httpClient(Aria2Config config) {
        ClassLoader classLoader = getClassLoader();
        Aria2HttpProxy proxy = new Aria2HttpProxy(GSON, config, Aria2Client.class);
        return (Aria2Client) Proxy.newProxyInstance(classLoader, new Class[]{Aria2Client.class}, proxy);
    }
}
