package cn.montaro.aria2;

import cn.montaro.aria2.enums.Protocol;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.net.URI;
import java.util.concurrent.TimeUnit;

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
    private int port = 6800;
    /**
     * jsonrpc路径 默认jsonrpc
     */
    private String path = "jsonrpc";
    /**
     * 连接密钥 通过rpc-secret设置
     */
    private String secret;

    /**
     * 连接协议 默认http
     *
     * @see Protocol
     */
    private Protocol protocol = Protocol.HTTP;
    @Setter(AccessLevel.NONE)
    private long connectTimeout = TimeUnit.SECONDS.toMillis(10L);
    @Setter(AccessLevel.NONE)
    private long readTimeout = TimeUnit.SECONDS.toMillis(10L);

    public URI getURI() {
        return URI.create(url());
    }

    public String url() {
        return protocol.getValue() + "://" + host + ":" + port + "/" + path;
    }

    public void setConnectTimeout(long timeout, TimeUnit timeUnit) {
        if (timeout > 0) {
            this.connectTimeout = timeUnit.toMillis(timeout);
        }
    }

    public void setReadTimeout(long timeout, TimeUnit timeUnit) {
        if (timeout > 0) {
            this.readTimeout = timeUnit.toMillis(timeout);
        }
    }
}
