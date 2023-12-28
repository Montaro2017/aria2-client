package cn.montaro.aria2.model;

import com.google.gson.JsonElement;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Aria2Request {
    private String id;
    private String jsonrpc = "2.0";
    private String method;
    private JsonElement params;
}
