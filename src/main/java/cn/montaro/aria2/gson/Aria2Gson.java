package cn.montaro.aria2.gson;

import cn.montaro.aria2.enums.EnumValue;
import cn.montaro.aria2.model.InputFile;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Aria2Gson {
    public static final Gson GSON = new GsonBuilder()
            // 序列化枚举值
            .registerTypeHierarchyAdapter(EnumValue.class, new EnumValueSerializer())
            .registerTypeHierarchyAdapter(EnumValue.class, new EnumValueDeserializer())
            .setFieldNamingStrategy(new KebabCamelNamingStrategy(InputFile.class))
            .create();

    private Aria2Gson() {
    }
}
