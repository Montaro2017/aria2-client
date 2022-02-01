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

    Aria2WebSocketConfig config = new Aria2WebSocketConfig()
            .setHost("192.168.99.120")
            .setSecret("montaro");
    Aria2Client client = Aria2ClientFactory.webSocketClient(config);

    @Test
    public void tellActive() {
        String s = client.tellActive("gid");
        System.out.println(s);
    }

    @Test
    public void tellWaiting() {
        String s = client.tellWaiting(0, 1000, null);
        System.out.println(s);
    }

    @Test
    public void getGlobalStat() {
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

    @Test
    public void tellStatus() {
        String s = client.tellStatus("1bfe98b1bc6c47aa");
        System.out.println("s = " + s);
    }

    @Test
    public void addDownload() {
        String magnet = "magnet:?xt=urn:btih:5e1464caced74be780397896d5a255a88b872542&tr=https%3A%2F%2Ftr.bangumi.moe%3A9696%2Fannounce&tr=http%3A%2F%2Ftr.bangumi.moe%3A6969%2Fannounce&tr=udp%3A%2F%2Ftr.bangumi.moe%3A6969%2Fannounce&tr=http%3A%2F%2Fopen.acgtracker.com%3A1096%2Fannounce&tr=http%3A%2F%2F208.67.16.113%3A8000%2Fannounce&tr=udp%3A%2F%2F208.67.16.113%3A8000%2Fannounce&tr=http%3A%2F%2Ftracker.ktxp.com%3A6868%2Fannounce&tr=http%3A%2F%2Ftracker.ktxp.com%3A7070%2Fannounce&tr=http%3A%2F%2Ft2.popgo.org%3A7456%2Fannonce&tr=http%3A%2F%2Fbt.sc-ol.com%3A2710%2Fannounce&tr=http%3A%2F%2Fshare.camoe.cn%3A8080%2Fannounce&tr=http%3A%2F%2F61.154.116.205%3A8000%2Fannounce&tr=http%3A%2F%2Fbt.rghost.net%3A80%2Fannounce&tr=http%3A%2F%2Ftracker.openbittorrent.com%3A80%2Fannounce&tr=http%3A%2F%2Ftracker.publicbt.com%3A80%2Fannounce&tr=http%3A%2F%2Ftracker.prq.to%2Fannounce&tr=http%3A%2F%2Fopen.nyaatorrents.info%3A6544%2Fannounce";
        List<String> uris = new ArrayList<>();
        uris.add(magnet);
        String s = client.addUri(uris, null, null);
        System.out.println(s);
    }
}
