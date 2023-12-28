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
public class Aria2Status {
    private String bitfield;
    private Bittorrent bittorrent;
    private Long completedLength;
    private Integer connections;
    private String dir;
    private Long downloadSpeed;
    private Integer errorCode;
    private String errorMessage;
    private List<Aria2File> files;
    private String following;
    private List<String> followedBy;
    private String gid;
    private String infoHash;
    private Integer numPieces;
    private Integer numSeeders;
    private Long pieceLength;
    private Boolean seeder;
    private String status;
    private Long totalLength;
    private Long uploadLength;
    private Long uploadSpeed;
}
