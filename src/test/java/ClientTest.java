import cn.montaro.aria2.api.Aria2Client;
import cn.montaro.aria2.client.websocket.Aria2WebSocketConfig;
import cn.montaro.aria2.client.websocket.Aria2WebSocketClient;
import org.junit.Test;

import java.util.List;

/**
 * Description:
 *
 * @author ZhangJiaYu
 * @date 2021/12/15
 */
public class ClientTest {

    @Test
    public void test() {
        Aria2WebSocketConfig aria2WebSocketConfig = new Aria2WebSocketConfig();
        aria2WebSocketConfig.setSecret("123456");
        Aria2Client client = new Aria2WebSocketClient(aria2WebSocketConfig);
        List<String> methods = client.listMethods();
        for (String method : methods) {
            System.out.println(method);
        }
    }
}
