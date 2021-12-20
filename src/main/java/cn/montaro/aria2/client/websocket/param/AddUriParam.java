package cn.montaro.aria2.client.websocket.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @author ZhangJiaYu
 * @date 2021/12/14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddUriParam extends Aria2Param {

    /**
     * 资源URI，支持HTTP/FTP/SFTP/BitTorrent
     */
    private List<String> uris = new ArrayList<>();
    /**
     * 下载选项 详情请看<a href="http://aria2.github.io/manual/en/html/aria2c.html#id3">文档</a>
     */
    private Map<String, String> options = null;
    /**
     * 下载顺序，如果是0则添加到开头
     * <p>If position is given, it must be an integer starting from 0. The new download will be inserted at position in the waiting queue.</p>
     * <p>If position is omitted or position is larger than the current size of the queue, the new download is appended to the end of the queue. </p>
     */
    private Integer position;

    public AddUriParam addUri(String uri) {
        this.uris.add(uri);
        return this;
    }

    public AddUriParam setOption(String name, String value) {
        if (this.options == null) {
            this.options = new HashMap<>();
        }
        this.options.put(name, value);
        return this;
    }

    public void setPosition(Integer position) {
        if (this.options == null) {
            this.options = new HashMap<>();
        }
        this.position = position;
    }
}
