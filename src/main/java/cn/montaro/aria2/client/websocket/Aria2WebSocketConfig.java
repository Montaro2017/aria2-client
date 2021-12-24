package cn.montaro.aria2.client.websocket;

import cn.montaro.aria2.constants.WebSocketProtocol;
import lombok.Data;
import lombok.experimental.Accessors;

import java.net.URI;

/**
 * Description:
 *
 * @author ZhangJiaYu
 * @date 2021/12/15
 */
@Data
@Accessors(chain = true)
public class Aria2WebSocketConfig {

    /**
     * 服务器地址 默认localhost
     */
    private String host = "localhost";
    /**
     * RPC连接端口 默认6800
     */
    private Integer port = 6800;
    /**
     * jsonrpc路径 默认jsonrpc
     */
    private String path = "jsonrpc";
    /**
     * 连接密钥 通过rpc-secret设置
     */
    private String secret;
    /**
     * 超时时间 单位ms
     */
    private Long timeout = 10000L;
    /**
     * 连接协议 默认ws
     * @see WebSocketProtocol
     */
    private String protocol = WebSocketProtocol.PROTOCOL_WS;

    public URI getURI() {
        return URI.create(protocol + "://" + host + ":" + port + "/" + path);
    }

}
