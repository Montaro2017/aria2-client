package cn.montaro.aria2.model;

import cn.montaro.aria2.enums.TorrentMode;
import lombok.Data;

import java.util.List;

/**
 * Description:
 *
 * @author ZhangJiaYu
 * @date 2022/9/16
 */
@Data
public class Bittorrent {
    private List<List<String>> announceList;
    private String comment;
    private Long creationDate;
    private TorrentMode mode;
    private Info info;

    @Data
    public static class Info {
        private String name;
    }
}
