import cn.montaro.aria2.Aria2Client;
import cn.montaro.aria2.Aria2ClientFactory;
import cn.montaro.aria2.Aria2Config;
import cn.montaro.aria2.enums.Follow;
import cn.montaro.aria2.gson.Aria2Gson;
import cn.montaro.aria2.model.InputFile;
import cn.montaro.aria2.model.Aria2Status;
import com.google.gson.Gson;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Aria2ClientTest {

    Gson gson = Aria2Gson.GSON.newBuilder()
            .setPrettyPrinting()
            .create();

    Aria2Config config = new Aria2Config()
            .setHost("localhost")
            .setPort(16800);

    Aria2Client client = Aria2ClientFactory.httpClient(config);

    @Test
    public void testAddUri() {
        List<String> uris = new ArrayList<>();
        uris.add("magnet:?xt=urn:btih:5c736372b08570992c60220da68fc9fb64788208");
        InputFile inputFile = new InputFile()
                .setDir("D:\\downloads")
                .setFollowMetalink(Follow.FALSE);
        String gid = client.addUri(uris, inputFile, null);
        System.out.println("gid = " + gid);
    }

    @Test
    public void testPause() {
        String gid = "1ef502ed410d0dc2";
        String result = client.pause(gid);
        System.out.println(result);
    }

    @Test
    public void testUnpause() {
        String gid = "1ef502ed410d0dc2";
        String result = client.unpause(gid);
        System.out.println(result);
    }

    @Test
    public void testRemove() {
        String gid = "1ef502ed410d0dc2";
        String result = client.remove(gid);
        System.out.println(result);
    }

    @Test
    public void testForceRemove() {
        String gid = "2559359622f46d67";
        String result = client.forceRemove(gid);
        System.out.println(result);
    }

    @Test
    public void testTellStatus() {
        String gid = "d4b8f66500df8701";
        Aria2Status status = client.tellStatus(gid);
        System.out.println(gson.toJson(status));
        List<String> followedBy = status.getFollowedBy();
        if (followedBy != null && followedBy.size() != 0) {
            gid = followedBy.get(0);
            status = client.tellStatus(gid);
            System.out.println(gson.toJson(status));
        }
    }

    @Test
    public void testTellActive() {
        List<Aria2Status> actives = client.tellActive();
        System.out.println(gson.toJson(actives));
    }

    @Test
    public void testTellWaiting() {
        List<Aria2Status> waiting = client.tellWaiting(0, 10);
        System.out.println(gson.toJson(waiting));
    }

    @Test
    public void testTellStopped() {
        List<Aria2Status> stopped = client.tellStopped(0, 10);
        List<String> gidList = stopped.stream().map(Aria2Status::getGid).collect(Collectors.toList());
        System.out.println(gidList);
    }

    @Test
    public void testGetOption() {
        String gid = "86be8aa5e3473c61";
        Map<String, String> option = client.getOption(gid);
        System.out.println(option);
    }

    @Test
    public void testGetGlobalOption() {
        InputFile globalOption = client.getGlobalOption();
        System.out.println(globalOption);
    }
}
