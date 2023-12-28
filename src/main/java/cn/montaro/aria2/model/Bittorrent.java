package cn.montaro.aria2.model;

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
}
