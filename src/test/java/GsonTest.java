import cn.montaro.aria2.enums.*;
import cn.montaro.aria2.gson.*;
import cn.montaro.aria2.model.InputFile;
import com.google.gson.Gson;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GsonTest {

    public final Gson gson = Aria2Gson.GSON.newBuilder().setPrettyPrinting().create();

    @Test
    public void testGsonEnumSerialize() {
        InputFile inputFile = new InputFile();
        inputFile.setFollowTorrent(Follow.TRUE);
        List<String> noProxy = new ArrayList<>();
        noProxy.add("baidu.com");
        noProxy.add("google.com");
        inputFile.setNoProxy(noProxy);
        String json = gson.toJson(inputFile);
        System.out.println(json);
    }
}
