package cn.montaro.aria2.api;

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
    String addUri(List<String> uris, Map<String, String> option, Integer position);

    /**
     * 查询支持的方法列表
     *
     * @return 方法列表
     */
    List<String> listMethods();

    /**
     * 移除一个下载任务，如果任务正在进行中，任务会先停止
     *
     * @param gid GID
     * @return 操作成功返回GID
     */
    String remove(String gid);

    String forceRemove(String gid);

    String pause(String gid);

    String forcePause(String gid);

    String pauseAll();

    String forcePauseAll();

    String unpause(String gid);

    void tellStatus(String gid);

    void tellStopped(Integer offset, Integer num, String[] keys);

    void changePosition(String gid, Integer pos, String how);

}
