package cn.montaro.aria2;

import cn.montaro.aria2.constants.Aria2Protocol;
import lombok.Data;
import lombok.experimental.Accessors;

import java.net.URI;

@Data
@Accessors(chain = true)
public class Aria2Config {

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
     * 连接协议 默认http
     *
     * @see Aria2Protocol
     */
    private String protocol = Aria2Protocol.Http.HTTP;

    public URI getURI() {
        return URI.create(url());
    }

    public String url() {
        return protocol + "://" + host + ":" + port + "/" + path;
    }
}
