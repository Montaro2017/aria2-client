import cn.hutool.core.collection.ListUtil;
import cn.montaro.aria2.Aria2Client;
import cn.montaro.aria2.Aria2ClientFactory;
import cn.montaro.aria2.Aria2Config;
import org.junit.Test;

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
}
