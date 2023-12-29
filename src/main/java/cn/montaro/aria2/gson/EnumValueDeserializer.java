package cn.montaro.aria2.gson;

import cn.montaro.aria2.enums.EnumValue;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class EnumValueDeserializer implements JsonDeserializer<EnumValue<?>> {
    @Override
    public EnumValue<?> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        if (!(typeOfT instanceof Class)) {
            throw new IllegalArgumentException();
        }
        Class<EnumValue<?>> enumValueClass = (Class<EnumValue<?>>) typeOfT;
        EnumValue<?>[] enumConstants = enumValueClass.getEnumConstants();
        for (EnumValue<?> constant : enumConstants) {
            if (constant.getValue().equals(json.getAsString())) {
                return constant;
            }
        }
        return null;
    }
}
