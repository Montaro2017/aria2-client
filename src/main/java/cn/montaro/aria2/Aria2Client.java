package cn.montaro.aria2;

import cn.montaro.aria2.annotation.Aria2Method;
import cn.montaro.aria2.constants.Methods;
import cn.montaro.aria2.model.*;

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
    @Aria2Method(Methods.ADD_URI)
    String addUri(List<String> uris, InputFile option, Integer position);

    @Aria2Method(Methods.ADD_TORRENT)
    String addTorrent(List<String> uris, InputFile option, Integer position);

    @Aria2Method(Methods.ADD_METALINK)
    String addMetalink(List<String> uris, InputFile option, Integer position);

    /**
     * 移除一个下载任务，如果任务正在进行中，任务会先停止
     *
     * @param gid GID
     * @return 操作成功返回GID
     */
    @Aria2Method(Methods.REMOVE)
    String remove(String gid);

    @Aria2Method(Methods.FORCE_REMOVE)
    String forceRemove(String gid);

    @Aria2Method(Methods.PAUSE)
    String pause(String gid);

    @Aria2Method(Methods.PAUSE_ALL)
    String pauseAll();

    @Aria2Method(Methods.FORCE_PAUSE)
    String forcePause(String gid);

    @Aria2Method(Methods.FORCE_PAUSE_ALL)
    String forcePauseAll();

    @Aria2Method(Methods.UNPAUSE)
    String unpause(String gid);

    @Aria2Method(Methods.UNPAUSE_ALL)
    String unpauseAll();

    @Aria2Method(Methods.TELL_STATUS)
    Aria2Status tellStatus(String gid, String... keys);

    @Aria2Method(Methods.GET_URIS)
    List<Aria2Uri> getUris(String gid);

    @Aria2Method(Methods.GET_FILES)
    List<Aria2File> getFiles(String gid);

    @Aria2Method(Methods.GET_PEERS)
    List<Peer> getPeers(String gid);

    @Aria2Method(Methods.GET_SERVERS)
    List<Server> getServers(String gid);

    @Aria2Method(Methods.TELL_ACTIVE)
    List<Aria2Status> tellActive(String... keys);

    @Aria2Method(Methods.TELL_WAITING)
    List<Aria2Status> tellWaiting(Integer offset, Integer num, String... keys);

    @Aria2Method(Methods.TELL_STOPPED)
    List<Aria2Status> tellStopped(Integer offset, Integer num, String... keys);

    @Aria2Method(Methods.CHANGE_POSITION)
    Integer changePosition(String gid, Integer pos, String how);

    @Aria2Method(Methods.CHANGE_URI)
    List<Boolean> changeUri(String gid, int fileIndex, List<String> delUris, List<String> addUris, Integer position);

    @Aria2Method(Methods.GET_OPTION)
    Map<String, String> getOption(String gid);

    @Aria2Method(Methods.CHANGE_OPTION)
    String changeOption(String gid, InputFile option);

    @Aria2Method(Methods.GET_GLOBAL_OPTION)
    InputFile getGlobalOption();

    @Aria2Method(Methods.CHANGE_GLOBAL_OPTION)
    Boolean changeGlobalOption(InputFile option);

    @Aria2Method(Methods.GET_GLOBAL_STAT)
    GlobalStat getGlobalStat();

    @Aria2Method(Methods.PURGE_DOWNLOAD_RESULT)
    Boolean purgeDownloadResult();

    @Aria2Method(Methods.REMOVE_DOWNLOAD_RESULT)
    Boolean removeDownloadResult(String gid);

    @Aria2Method(Methods.GET_VERSION)
    Aria2Version getVersion();

    @Aria2Method(Methods.GET_SESSION_INFO)
    SessionInfo getSessionInfo();

    @Aria2Method(Methods.SHUTDOWN)
    Boolean shutdown();

    @Aria2Method(Methods.FORCE_SHUTDOWN)
    Boolean forceShutdown();

    @Aria2Method(Methods.SAVE_SESSION)
    Boolean saveSession();

    @Aria2Method(Methods.MULTI_CALL)
    List<String> multicall(List<Map<String, List<Object>>> methods);

    /**
     * 查询支持的方法列表
     *
     * @return 方法列表
     */
    @Aria2Method(Methods.LIST_METHODS)
    List<String> listMethods();

    @Aria2Method(Methods.LIST_NOTIFICATIONS)
    List<String> listNotifications();

}
