package cn.montaro.aria2.gson;

import cn.montaro.aria2.model.InputFile;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class InputFileSerializer implements JsonSerializer<InputFile> {
    @Override
    public JsonElement serialize(InputFile inputFile, Type type, JsonSerializationContext jsonSerializationContext) {
        return null;
    }
}
