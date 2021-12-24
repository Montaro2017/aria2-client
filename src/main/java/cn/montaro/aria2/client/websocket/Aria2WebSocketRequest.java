package cn.montaro.aria2.client.websocket;

import com.google.gson.JsonElement;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Description:
 *
 * @author ZhangJiaYu
 * @date 2021/12/14
 */
@Data
@Accessors(chain = true)
public class Aria2WebSocketRequest implements Serializable {

    private String id;
    private String jsonrpc = "2.0";
    private String method;
    private JsonElement params;

}
