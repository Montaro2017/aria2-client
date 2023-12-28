package cn.montaro.aria2.gson;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CommaAdapter extends TypeAdapter<List<String>> {

    private static final String COMMA = ",";

    @Override
    public void write(JsonWriter writer, List<String> list) throws IOException {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String value = it.next();
            writer.value(value);
            if (it.hasNext()) {
                writer.value(COMMA);
            }
        }
        writer.flush();
        writer.close();
    }

    @Override
    public List<String> read(JsonReader reader) throws IOException {
        String value = reader.nextString();
        String[] split = value.split(COMMA);
        return Arrays.asList(split);
    }
}
