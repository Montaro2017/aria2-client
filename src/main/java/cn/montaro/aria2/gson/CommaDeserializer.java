package cn.montaro.aria2.gson;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

public class CommaDeserializer implements JsonDeserializer<List<String>> {
    @Override
    public List<String> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        String commaString = json.getAsString();
        if (commaString.length() == 0) {
            return null;
        }
        String[] split = commaString.split(",");
        return Arrays.asList(split);
    }
}
