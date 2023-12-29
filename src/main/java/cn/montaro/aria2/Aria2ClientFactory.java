package cn.montaro.aria2;

import cn.montaro.aria2.client.http.Aria2ClientHttpProxy;
import cn.montaro.aria2.gson.Aria2Gson;

import java.lang.reflect.Proxy;

/**
 * Description:
 *
 * @author ZhangJiaYu
 * @date 2021/12/22
 */
public class Aria2ClientFactory {

    private Aria2ClientFactory() {
    }

    private static ClassLoader getClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    public static Aria2Client httpClient(Aria2Config config) {
        ClassLoader classLoader = getClassLoader();
        Aria2ClientHttpProxy proxy = new Aria2ClientHttpProxy(Aria2Gson.GSON, config, Aria2Client.class);
        return (Aria2Client) Proxy.newProxyInstance(classLoader, new Class[]{Aria2Client.class}, proxy);
    }
}
