package cn.montaro.aria2.gson;

import cn.montaro.aria2.enums.EnumValue;
import com.google.gson.*;

import java.lang.reflect.Type;

public class EnumValueSerializer implements JsonSerializer<EnumValue<?>> {
    @Override
    public JsonElement serialize(EnumValue<?> src, Type typeOfSrc, JsonSerializationContext context) {
        Object value = src.getValue();
        if (value instanceof String) {
            return new JsonPrimitive((String) value);
        } else if (value instanceof Number) {
            return new JsonPrimitive((Number) value);
        } else if (value instanceof Boolean) {
            return new JsonPrimitive((Boolean) value);
        }
        return JsonNull.INSTANCE;
    }
}
