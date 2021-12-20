package cn.montaro.aria2.client.websocket.exception;

/**
 * Description:
 *
 * @author ZhangJiaYu
 * @date 2021/12/16
 */
public class Aria2WebSocketClientTimeoutException extends Aria2WebSocketClientException {
    public Aria2WebSocketClientTimeoutException() {
        this("Waiting for the result timed out");
    }

    public Aria2WebSocketClientTimeoutException(String message) {
        super(message);
    }
}
