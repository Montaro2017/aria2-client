package cn.montaro.aria2.constants;

/**
 * Description:
 * Aria2可调用方法名称
 *
 * @author ZhangJiaYu
 * @date 2021/12/14
 */
public class Methods {

    public static final String DOT = ".";
    private static final String ARIA2 = "aria2";
    public static final String ADD_URI = ARIA2 + DOT + "addUri";
    public static final String ADD_TORRENT = ARIA2 + DOT + "addTorrent";
    public static final String ADD_METALINK = ARIA2 + DOT + "addMetalink";
    public static final String REMOVE = ARIA2 + DOT + "remove";
    public static final String FORCE_REMOVE = ARIA2 + DOT + "forceRemove";
    public static final String PAUSE = ARIA2 + DOT + "pause";
    public static final String UNPAUSE = ARIA2 + DOT + "unpause";
    public static final String PAUSE_ALL = ARIA2 + DOT + "pauseAll";
    public static final String UNPAUSE_ALL = ARIA2 + DOT + "unpauseAll";
    public static final String FORCE_PAUSE = ARIA2 + DOT + "forcePause";
    public static final String FORCE_PAUSE_ALL = ARIA2 + DOT + "forcePauseAll";

    public static final String TELL_STATUS = ARIA2 + DOT + "tellStatus";
    public static final String TELL_ACTIVE = ARIA2 + DOT + "tellActive";
    public static final String TELL_WAITING = ARIA2 + DOT + "tellWaiting";
    public static final String TELL_STOPPED = ARIA2 + DOT + "tellStopped";

    public static final String GET_URIS = ARIA2 + DOT + "getUris";
    public static final String GET_FILES = ARIA2 + DOT + "getFiles";
    public static final String GET_PEERS = ARIA2 + DOT + "getPeers";
    public static final String GET_OPTION = ARIA2 + DOT + "getOption";
    public static final String GET_SERVERS = ARIA2 + DOT + "getServers";
    public static final String GET_VERSION = ARIA2 + DOT + "getVersion";
    public static final String GET_GLOBAL_STAT = ARIA2 + DOT + "getGlobalStat";
    public static final String GET_SESSION_INFO = ARIA2 + DOT + "getSessionInfo";
    public static final String GET_GLOBAL_OPTION = ARIA2 + DOT + "getGlobalOption";

    public static final String CHANGE_URI = ARIA2 + DOT + "changeUri";
    public static final String CHANGE_OPTION = ARIA2 + DOT + "changeOption";
    public static final String CHANGE_POSITION = ARIA2 + DOT + "changePosition";
    public static final String CHANGE_GLOBAL_OPTION = ARIA2 + DOT + "changeGlobalOption";
    public static final String PURGE_DOWNLOAD_RESULT = ARIA2 + DOT + "purgeDownloadResult";
    public static final String REMOVE_DOWNLOAD_RESULT = ARIA2 + DOT + "removeDownloadResult";
    
    public static final String SHUTDOWN = ARIA2 + DOT + "shutdown";
    public static final String SAVE_SESSION = ARIA2 + DOT + "saveSession";
    public static final String FORCE_SHUTDOWN = ARIA2 + DOT + "forceShutdown";

    private static final String SYSTEM = "system";
    public static final String MULTI_CALL = SYSTEM + DOT + "multicall";
    public static final String LIST_METHODS = SYSTEM + DOT + "listMethods";
    public static final String LIST_NOTIFICATIONS = SYSTEM + DOT + "listNotifications";

    private Methods() {

    }

}
