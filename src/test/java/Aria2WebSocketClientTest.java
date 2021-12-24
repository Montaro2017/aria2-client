import cn.montaro.aria2.Aria2Client;
import cn.montaro.aria2.Aria2ClientFactory;
import cn.montaro.aria2.client.websocket.Aria2WebSocketConfig;
import cn.montaro.aria2.client.websocket.Aria2WebSocketClient;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @author ZhangJiaYu
 * @date 2021/12/15
 */
public class Aria2WebSocketClientTest {

    @Test
    public void test() {
        Aria2WebSocketConfig config = new Aria2WebSocketConfig().setSecret("123456");
        Aria2Client client = Aria2ClientFactory.webSocketClient(config);
        String version = client.getVersion();
        System.out.println(version);
    }
}
