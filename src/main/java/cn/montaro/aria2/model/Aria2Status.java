package cn.montaro.aria2.model;

import cn.montaro.aria2.enums.Status;
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
    private String gid;
    private Status status;
    private Long totalLength;
    private Long completedLength;
    private Long uploadLength;
    private String bitfield;
    private Long downloadSpeed;
    private Long uploadSpeed;
    private String infoHash;
    private Integer numSeeders;
    private Boolean seeder;
    private Long pieceLength;
    private Integer numPieces;
    private Integer connections;
    private Integer errorCode;
    private String errorMessage;
    private List<String> followedBy;
    private String following;
    private String belongsTo;
    private String dir;
    private List<Aria2File> files;
    private Bittorrent bittorrent;
    private Long verifiedLength;
    private Long verifyIntegrityPending;
}
