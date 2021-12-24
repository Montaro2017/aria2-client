package cn.montaro.aria2.client.websocket.exception;

/**
 * Description:
 *
 * @author ZhangJiaYu
 * @date 2021/12/16
 */
public class Aria2WebSocketClientException extends RuntimeException {

    public Aria2WebSocketClientException() {
        super();
    }

    public Aria2WebSocketClientException(String message) {
        super(message);
    }

    public Aria2WebSocketClientException(Exception e) {
        super(e);
    }
}
