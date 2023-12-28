import cn.montaro.aria2.Aria2Client;
import cn.montaro.aria2.Aria2ClientFactory;
import cn.montaro.aria2.Aria2Config;
import cn.montaro.aria2.model.InputFile;
import cn.montaro.aria2.model.Aria2Status;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Aria2ClientTest {

    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    Aria2Config config = new Aria2Config()
            .setHost("localhost")
            .setPort(16800);

    Aria2Client client = Aria2ClientFactory.httpClient(config);

    @Test
    public void test() {
        List<String> uris = new ArrayList<>();
        uris.add("magnet:?xt=urn:btih:5c736372b08570992c60220da68fc9fb64788208&dn=%5B%E5%8A%A8%E6%BC%AB%E5%9B%BD%E5%AD%97%E5%B9%95%E7%BB%84%26VCB-Studio%5D%20%E4%B8%9C%E4%BA%AC%E5%96%B0%E7%A7%8D%20%2F%20Tokyo%20Ghoul%20%2F%20%E6%9D%B1%E4%BA%AC%E5%96%B0%E7%A8%AE%2010-bit%201080p%20HEVC%20BDRip%20%5BS1%2BS2%2BOVAs%20Rev%20%2B%20S3%20%2B%20S4%20Fin%5D&tr=http%3A%2F%2Fnyaa.tracker.wf%3A7777%2Fannounce&tr=udp%3A%2F%2Fopen.stealth.si%3A80%2Fannounce&tr=udp%3A%2F%2Ftracker.opentrackr.org%3A1337%2Fannounce&tr=udp%3A%2F%2Fexodus.desync.com%3A6969%2Fannounce&tr=udp%3A%2F%2Ftracker.torrent.eu.org%3A451%2Fannounce");
        InputFile inputFile = new InputFile()
                .setDir("D:\\downloads");
        String gid = client.addUri(uris, inputFile, null);
        System.out.println("gid = " + gid);
    }

    @Test
    public void status() {
        String gid = "f919a518f4b4fc85";
        Aria2Status status = client.tellStatus(gid);
        System.out.println(status);
        List<String> followedBy = status.getFollowedBy();
        if (followedBy != null && followedBy.size() != 0) {
            gid = followedBy.get(0);
            status = client.tellStatus(gid);
            System.out.println(gson.toJson(status));
        }
    }
}
