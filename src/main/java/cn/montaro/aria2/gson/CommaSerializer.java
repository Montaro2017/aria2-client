package cn.montaro.aria2.gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.util.List;

public class CommaSerializer implements JsonSerializer<List<String>> {
    private static final String COMMA = ",";

    @Override
    public JsonElement serialize(List<String> src, Type typeOfSrc, JsonSerializationContext context) {
        String value = String.join(COMMA, src);
        return new JsonPrimitive(value);
    }


}
