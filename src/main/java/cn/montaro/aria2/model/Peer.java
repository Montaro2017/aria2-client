package cn.montaro.aria2.model;

import lombok.Data;

@Data
public class Peer {
    private String peerId;
    private String ip;
    private String bitfield;
    private Boolean amChoking;
    private Boolean peerChoking;
    private Long downloadSpeed;
    private Long uploadSpeed;
    private Boolean seeder;
}
