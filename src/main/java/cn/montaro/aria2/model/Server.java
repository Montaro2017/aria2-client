package cn.montaro.aria2.model;

import lombok.Data;

import java.util.List;

@Data
public class Server {
    private Integer index;
    private List<ServerDetail> servers;

    @Data
    public static class ServerDetail {
        private String uri;
        private String currentUri;
        private Long downloadSpeed;
    }
}
