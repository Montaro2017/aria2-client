package cn.montaro.aria2.client.websocket;

import lombok.Data;

/**
 * Description:
 *
 * @author ZhangJiaYu
 * @date 2021/12/14
 */
@Data
public class Aria2WebSocketResponse<T> {

    private String id;
    private String jsonrpc;
    private T result;

}
