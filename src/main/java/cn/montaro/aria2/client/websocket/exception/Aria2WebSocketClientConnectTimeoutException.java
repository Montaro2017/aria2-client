package cn.montaro.aria2.client.websocket.exception;

import java.net.URI;

/**
 * Description:
 *
 * @author ZhangJiaYu
 * @date 2021/12/16
 */
public class Aria2WebSocketClientConnectTimeoutException extends Aria2WebSocketClientException {

    private long timeout;

    private URI uri;

    public Aria2WebSocketClientConnectTimeoutException() {
    }

    @Override
    public String getMessage() {
        return String.format("Websocket connect to %s timeout:%dms", uri.toString(), timeout);
    }

    public Aria2WebSocketClientConnectTimeoutException(URI uri, long timeout) {
        this.uri = uri;
        this.timeout = timeout;
    }
}
