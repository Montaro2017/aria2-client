package cn.montaro.aria2.model;

import com.google.gson.JsonElement;
import lombok.Data;

@Data
public class Aria2Response {
    private String id;
    private String jsonrpc;
    private JsonElement result;
    private Error error;

    @Data
    public static class Error {
        private Integer code;
        private String message;
    }
}
