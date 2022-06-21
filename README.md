# aria2-client

#### 介绍
aria2 java 库，能通过编写java代码的方式去控制aria2


#### 使用说明

aria2 java客户端，rpc远程控制aria2客户端，支持密码
目前仅完成http方式，欢迎PR

#### 示例代码

```java
// Aria2配置
Aria2Config config = new Aria2Config()
        // 主机地址 默认localhost
        .setHost("127.0.0.1")
        // 端口 默认6800
        .setPort(6800)
        // rpc-secret
        .setSecret("123456");
// 实例化http客户端
Aria2Client aria2Client = Aria2ClientFactory.httpClient(config);
// 添加下载地址链接
List<String> uris = new ArrayList<String>();
uris.add(url);
// 添加下载任务 返回任务gid
String gid = aria2Client.addUri(uris, null, null);
```
