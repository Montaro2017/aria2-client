import cn.montaro.aria2.Aria2Client;
import cn.montaro.aria2.Aria2ClientFactory;
import cn.montaro.aria2.Aria2Config;
import org.junit.Test;

public class Aria2ClientTest {

    Aria2Config config = new Aria2Config()
            .setHost("192.168.99.120")
            .setSecret("montaro");

    Aria2Client client = Aria2ClientFactory.httpClient(config);

    @Test
    public void test() {
        String globalStat = client.getGlobalStat();
        System.out.println("globalStat = " + globalStat);
    }
}
