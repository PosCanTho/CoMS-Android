package cse.duytan.coms.models;

/**
 * Created by Pham Van Thien on 7/28/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class EventBusInfo {
    private int processId;
    private Object data;

    public EventBusInfo(int processId, Object data) {
        this.processId = processId;
        this.data = data;
    }

    public EventBusInfo() {
    }

    public EventBusInfo(int processId) {
        this.processId = processId;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getProcessId() {
        return processId;
    }

    public void setProcessId(int processId) {
        this.processId = processId;
    }
}
