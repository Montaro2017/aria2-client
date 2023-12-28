package cn.montaro.aria2;

import cn.montaro.aria2.annotation.Aria2Method;
import cn.montaro.aria2.constants.Methods;
import cn.montaro.aria2.model.InputFile;
import cn.montaro.aria2.model.Aria2Status;

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
    String getUris(String gid);

    @Aria2Method(Methods.GET_FILES)
    String getFiles(String gid);

    @Aria2Method(Methods.GET_PEERS)
    String getPeers(String gid);

    @Aria2Method(Methods.GET_SERVERS)
    String getServers(String gid);

    @Aria2Method(Methods.TELL_ACTIVE)
    String tellActive(String... keys);

    @Aria2Method(Methods.TELL_WAITING)
    String tellWaiting(int offset, int num, String... keys);

    @Aria2Method(Methods.TELL_STOPPED)
    String tellStopped(int offset, int num, String... keys);

    @Aria2Method(Methods.CHANGE_POSITION)
    Integer changePosition(String gid, Integer pos, String how);

    @Aria2Method(Methods.CHANGE_URI)
    String changeUri(String gid, int fileIndex, List<String> delUris, List<String> addUris);

    @Aria2Method(Methods.GET_OPTION)
    Map<String, String> getOption(String gid);

    @Aria2Method(Methods.CHANGE_OPTION)
    String changeOption(String gid, InputFile option);

    @Aria2Method(Methods.GET_GLOBAL_OPTION)
    Map<String, String> getGlobalOption();

    @Aria2Method(Methods.CHANGE_GLOBAL_OPTION)
    String changeGlobalOption(InputFile option);

    @Aria2Method(Methods.GET_GLOBAL_STAT)
    String getGlobalStat();

    @Aria2Method(Methods.PURGE_DOWNLOAD_RESULT)
    String purgeDownloadResult();

    @Aria2Method(Methods.REMOVE_DOWNLOAD_RESULT)
    String removeDownloadResult(String gid);

    @Aria2Method(Methods.GET_VERSION)
    String getVersion();

    @Aria2Method(Methods.GET_SESSION_INFO)
    String getSessionInfo();

    @Aria2Method(Methods.SHUTDOWN)
    String shutdown();

    @Aria2Method(Methods.FORCE_SHUTDOWN)
    String forceShutdown();

    @Aria2Method(Methods.SAVE_SESSION)
    String saveSession();

    @Aria2Method(Methods.MULTI_CALL)
    String multicall(List<Map<String, List<Object>>> methods);

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
