package cse.duytan.coms.connections;

/**
 * Created by Pham Van Thien on 7/6/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public interface DownloadCallback {
    void downloadSuccess(int processId, Object data);

    void downloadError(int processId, String msg);
}
