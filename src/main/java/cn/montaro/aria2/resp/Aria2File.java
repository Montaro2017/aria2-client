package cn.montaro.aria2.resp;

import lombok.Data;

import java.util.List;

/**
 * Description:
 *
 * @author ZhangJiaYu
 * @date 2022/9/16
 */
@Data
public class Aria2File {
    private Long completedLength;
    private Integer index;
    private Long length;
    private String path;
    private Boolean selected;
    private List<String> uris;
}
