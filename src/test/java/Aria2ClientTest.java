import cn.hutool.core.collection.ListUtil;
import cn.montaro.aria2.Aria2Client;
import cn.montaro.aria2.Aria2ClientFactory;
import cn.montaro.aria2.Aria2Config;
import cn.montaro.aria2.resp.Aria2Status;
import org.junit.Test;

import java.util.List;

public class Aria2ClientTest {

    Aria2Config config = new Aria2Config()
            .setHost("localhost")
            .setSecret("123456");

    Aria2Client client = Aria2ClientFactory.httpClient(config);

    @Test
    public void test() {
        String gid = client.addUri(ListUtil.of("magnet:?xt=urn:btih:308f0122b1c3af5db9f3660775a6a2d81bd1e120"), null, null);
        System.out.println("gid = " + gid);
    }

    @Test
    public void status() {
        String gid = "acc1c7d7c2043dba";
        Aria2Status status = client.tellStatus(gid);
        System.out.println(status);
        List<String> followedBy = status.getFollowedBy();
        if (followedBy != null && followedBy.size() != 0) {
            gid = followedBy.get(0);
            status = client.tellStatus(gid);
            System.out.println(status);

        }

    }
}
