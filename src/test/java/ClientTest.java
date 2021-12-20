import cn.montaro.aria2.client.websocket.Aria2WebSocketConfig;
import cn.montaro.aria2.client.websocket.Aria2WebSocketClient;
import org.junit.Test;

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
        Aria2WebSocketClient client = new Aria2WebSocketClient(aria2WebSocketConfig);
        String gid = client.addUri(new String[]{"https://www.baidu.com"});
        System.out.println("gid = " + gid);

    }
}
