package cn.montaro.aria2;

import cn.montaro.aria2.client.http.Aria2HttpProxy;
import cn.montaro.aria2.client.websocket.Aria2WebSocketProxy;

import java.lang.reflect.Proxy;

/**
 * Description:
 *
 * @author ZhangJiaYu
 * @date 2021/12/22
 */
public class Aria2ClientFactory {

    private static ClassLoader getClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    public static Aria2Client webSocketClient(Aria2Config config) {
        ClassLoader classLoader = getClassLoader();
        Aria2WebSocketProxy proxy = new Aria2WebSocketProxy(config);
        Aria2Client webSocketClient = (Aria2Client) Proxy.newProxyInstance(classLoader, new Class[]{Aria2Client.class}, proxy);
        return webSocketClient;
    }

    public static Aria2Client httpClient(Aria2Config config) {
        ClassLoader classLoader = getClassLoader();
        Aria2HttpProxy proxy = new Aria2HttpProxy(config);
        Aria2Client httpClient = (Aria2Client) Proxy.newProxyInstance(classLoader, new Class[]{Aria2Client.class}, proxy);
        return httpClient;
    }
}
