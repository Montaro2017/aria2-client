import cn.montaro.aria2.Aria2Client;
import cn.montaro.aria2.Aria2ClientFactory;
import cn.montaro.aria2.client.websocket.Aria2WebSocketConfig;
import cn.montaro.aria2.client.websocket.Aria2WebSocketClient;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.Test;

import javax.lang.model.element.VariableElement;
import java.sql.Array;
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

    Aria2WebSocketConfig config = new Aria2WebSocketConfig().setSecret("123456");
    Aria2Client client = Aria2ClientFactory.webSocketClient(config);

    @Test
    public void tellActive() {
        String s = client.tellActive();
        System.out.println(s);
    }

    @Test
    public void tellWaiting() {
        String s = client.tellWaiting(0, 1000, null);
        System.out.println(s);
    }

    @Test
    public void getGlobalStat(){
        String globalStat = client.getGlobalStat();
        System.out.println(globalStat);
    }

    @Test
    public void changeUri() {
        List<String> addUris = new ArrayList<String>();
        addUris.add("https://mirrors.tuna.tsinghua.edu.cn/centos/8.5.2111/isos/x86_64/CentOS-8.5.2111-x86_64-dvd1.iso");
        String result = client.changeUri("97d4d126a7263df8", 1, new ArrayList<String>(), addUris);
        System.out.println(result);
    }
}
