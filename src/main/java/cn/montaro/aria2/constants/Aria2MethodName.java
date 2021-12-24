package cn.montaro.aria2.constants;

/**
 * Description:
 * Aria2可调用方法名称
 *
 * @author ZhangJiaYu
 * @date 2021/12/14
 */
public class Aria2MethodName {

    private final static String ARIA2 = "aria2.";
    private final static String SYSTEM = "system.";
    
    public final static String ADD_URI = ARIA2 + "addUri";
    public final static String ADD_TORRENT = ARIA2 + "addTorrent";
    public final static String ADD_METALINK = ARIA2 + "addMetalink";

    public final static String REMOVE = ARIA2 + "remove";
    public final static String FORCE_REMOVE = ARIA2 + "forceRemove";

    public final static String PAUSE = ARIA2 + "pause";
    public final static String UNPAUSE = ARIA2 + "unpause";
    public final static String PAUSE_ALL = ARIA2 + "pauseAll";
    public final static String UNPAUSE_ALL = ARIA2 + "unpauseAll";
    public final static String FORCE_PAUSE = ARIA2 + "forcePause";
    public final static String FORCE_PAUSE_ALL = ARIA2 + "forcePauseAll";

    public final static String TELL_STATUS = ARIA2 + "tellStatus";
    public final static String TELL_ACTIVE = ARIA2 + "tellActive";
    public final static String TELL_WAITING = ARIA2 + "tellWaiting";
    public final static String TELL_STOPPED = ARIA2 + "tellStopped";

    public final static String GET_URIS = ARIA2 + "getUris";
    public final static String GET_FILES = ARIA2 + "getFiles";
    public final static String GET_PEERS = ARIA2 + "getPeers";
    public final static String GET_OPTION = ARIA2 + "getOption";
    public final static String GET_SERVERS = ARIA2 + "getServers";
    public final static String GET_VERSION = ARIA2 + "getVersion";
    public final static String GET_GLOBAL_STAT = ARIA2 + "getGlobalStat";
    public final static String GET_SESSION_INFO = ARIA2 + "getSessionInfo";
    public final static String GET_GLOBAL_OPTION = ARIA2 + "getGlobalOption";

    public final static String CHANGE_URI = ARIA2 + "changeUri";
    public final static String CHANGE_OPTION = ARIA2 + "changeOption";
    public final static String CHANGE_POSITION = ARIA2 + "changePosition";
    public final static String CHANGE_GLOBAL_OPTION = ARIA2 + "changeGlobalOption";

    public final static String PURGE_DOWNLOAD_RESULT = ARIA2 + "purgeDownloadResult";
    public final static String REMOVE_DOWNLOAD_RESULT = ARIA2 + "removeDownloadResult";

    public final static String SHUTDOWN = ARIA2 + "shutdown";
    public final static String SAVE_SESSION = ARIA2 + "saveSession";
    public final static String FORCE_SHUTDOWN = ARIA2 + "forceShutdown";

    public final static String MULTICALL = SYSTEM + "multicall";
    public final static String LIST_METHODS = SYSTEM + "listMethods";
    public final static String LIST_NOTIFICATIONS = SYSTEM + "listNotifications";

}
