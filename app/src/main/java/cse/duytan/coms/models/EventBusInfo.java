package cse.duytan.coms.models;

/**
 * Created by Pham Van Thien on 7/28/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class EventBusInfo {
    public int processId;

    public EventBusInfo() {
    }

    public EventBusInfo(int processId) {
        this.processId = processId;
    }

    public int getProcessId() {
        return processId;
    }

    public void setProcessId(int processId) {
        this.processId = processId;
    }
}
