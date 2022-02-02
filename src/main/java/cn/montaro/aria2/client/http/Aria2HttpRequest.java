package cn.montaro.aria2.client.http;

import com.google.gson.JsonElement;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class Aria2HttpRequest implements Serializable {
    private String id;
    private String jsonrpc = "2.0";
    private String method;
    private JsonElement params;
}
