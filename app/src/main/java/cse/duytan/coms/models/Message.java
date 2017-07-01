package cse.duytan.coms.models;

/**
 * Created by Pham Van Thien on 7/1/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class Message {
    private String name;
    private String message;
    private String time;

    public Message() {
    }

    public Message(String name, String message, String time) {
        this.name = name;
        this.message = message;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
