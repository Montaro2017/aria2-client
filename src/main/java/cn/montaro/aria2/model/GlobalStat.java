package cn.montaro.aria2.model;

import lombok.Data;

@Data
public class GlobalStat {
    private Long downloadSpeed;
    private Long uploadSpeed;
    private Integer numActive;
    private Integer numWaiting;
    private Integer numStopped;
    private Integer numStoppedTotal;
}
