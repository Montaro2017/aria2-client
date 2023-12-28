package cn.montaro.aria2.gson;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class EnumValueTypeAdapter<T extends Enum<T> & EnumValue<V>, V> extends TypeAdapter<T> {

    private final Class<T> enumClass;

    public EnumValueTypeAdapter(Class<T> enumClass) {
        this.enumClass = enumClass;
    }

    @Override
    public void write(JsonWriter out, T value) throws IOException {
        if (value == null) {
            out.nullValue();
        } else {
            V enumValue = value.getValue();
            if (enumValue instanceof String) {
                out.value((String) enumValue);
            } else if (enumValue instanceof Number) {
                out.value((Number) enumValue);
            } else if (enumValue instanceof Boolean) {
                out.value((Boolean) enumValue);
            } else {
                throw new IllegalArgumentException("Unsupported value type: " + enumValue.getClass());
            }
        }
    }

    @Override
    public T read(JsonReader in) throws IOException {
        String value = in.nextString();
        for (T enumValue : enumClass.getEnumConstants()) {
            if (enumValue.getValue().equals(value)) {
                return enumValue;
            }
        }
        throw new IllegalArgumentException("Invalid enum value: " + value);
    }
}
