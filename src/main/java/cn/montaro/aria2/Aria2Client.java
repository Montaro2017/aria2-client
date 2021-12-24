package cn.montaro.aria2;

import cn.montaro.aria2.annotation.Aria2Method;
import cn.montaro.aria2.constants.Aria2MethodName;

import java.util.List;
import java.util.Map;

/**
 * Description:
 * Aria2 Client Api
 *
 * @author ZhangJiaYu
 * @date 2021/12/14
 */
public interface Aria2Client {

    /**
     * 添加文件下载
     *
     * @param uris
     * @param option
     * @param position
     * @return
     */
    @Aria2Method(Aria2MethodName.ADD_URI)
    String addUri(List<String> uris, Map<String, String> option, Integer position);

    @Aria2Method(Aria2MethodName.ADD_TORRENT)
    String addTorrent(List<String> uris, Map<String, String> option, Integer position);

    @Aria2Method(Aria2MethodName.ADD_METALINK)
    String addMetalink(List<String> uris, Map<String, String> option, Integer position);

    /**
     * 移除一个下载任务，如果任务正在进行中，任务会先停止
     *
     * @param gid GID
     * @return 操作成功返回GID
     */
    @Aria2Method(Aria2MethodName.REMOVE)
    String remove(String gid);

    @Aria2Method(Aria2MethodName.FORCE_REMOVE)
    String forceRemove(String gid);

    @Aria2Method(Aria2MethodName.PAUSE)
    String pause(String gid);

    @Aria2Method(Aria2MethodName.PAUSE_ALL)
    String pauseAll();

    @Aria2Method(Aria2MethodName.FORCE_PAUSE)
    String forcePause(String gid);

    @Aria2Method(Aria2MethodName.FORCE_PAUSE_ALL)
    String forcePauseAll();

    @Aria2Method(Aria2MethodName.UNPAUSE)
    String unpause(String gid);

    @Aria2Method(Aria2MethodName.UNPAUSE_ALL)
    String unpauseAll();

    // TODO: define return type
    @Aria2Method(Aria2MethodName.TELL_STATUS)
    String tellStatus(String gid, String... keys);

    @Aria2Method(Aria2MethodName.GET_URIS)
    String getUris(String gid);

    @Aria2Method(Aria2MethodName.GET_FILES)
    String getFiles(String gid);

    @Aria2Method(Aria2MethodName.GET_PEERS)
    String getPeers(String gid);

    @Aria2Method(Aria2MethodName.GET_SERVERS)
    String getServers(String gid);

    @Aria2Method(Aria2MethodName.TELL_ACTIVE)
    String tellActive(String... keys);

    @Aria2Method(Aria2MethodName.TELL_WAITING)
    String tellWaiting(int offset, int num, String... keys);

    @Aria2Method(Aria2MethodName.TELL_STOPPED)
    String tellStopped(int offset, int num, String... keys);

    @Aria2Method(Aria2MethodName.CHANGE_POSITION)
    Integer changePosition(String gid, Integer pos, String how);

    @Aria2Method(Aria2MethodName.CHANGE_URI)
    String changeUri(String gid, int fileIndex, List<String> delUris, List<String> addUris);

    @Aria2Method(Aria2MethodName.GET_OPTION)
    Map<String, String> getOption(String gid);

    @Aria2Method(Aria2MethodName.CHANGE_OPTION)
    String changeOption(String gid, Map<String, String> options);

    @Aria2Method(Aria2MethodName.GET_GLOBAL_OPTION)
    Map<String, String> getGlobalOption();

    @Aria2Method(Aria2MethodName.CHANGE_GLOBAL_OPTION)
    String changeGlobalOption(Map<String, String> options);

    @Aria2Method(Aria2MethodName.GET_GLOBAL_STAT)
    String getGlobalStat();

    @Aria2Method(Aria2MethodName.PURGE_DOWNLOAD_RESULT)
    String purgeDownloadResult();

    @Aria2Method(Aria2MethodName.REMOVE_DOWNLOAD_RESULT)
    String removeDownloadResult(String gid);

    @Aria2Method(Aria2MethodName.GET_VERSION)
    String getVersion();

    @Aria2Method(Aria2MethodName.GET_SESSION_INFO)
    String getSessionInfo();

    @Aria2Method(Aria2MethodName.SHUTDOWN)
    String shutdown();

    @Aria2Method(Aria2MethodName.FORCE_SHUTDOWN)
    String forceShutdown();

    @Aria2Method(Aria2MethodName.SAVE_SESSION)
    String saveSession();

    @Aria2Method(Aria2MethodName.MULTICALL)
    String multicall(List<Map<String, List<Object>>> methods);

    /**
     * 查询支持的方法列表
     *
     * @return 方法列表
     */
    @Aria2Method(Aria2MethodName.LIST_METHODS)
    List<String> listMethods();

    @Aria2Method(Aria2MethodName.LIST_NOTIFICATIONS)
    List<String> listNotifications();


}
