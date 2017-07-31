package cse.duytan.coms.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Pham Van Thien on 7/25/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class ChatBody {

    @SerializedName("IdFrom")
    public int IdFrom;
    @SerializedName("IdTo")
    public int IdTo;
    @SerializedName("Message")
    public String Message;
    @SerializedName("Time")
    public String Time;

    public ChatBody() {
    }

    public ChatBody(int idFrom, int idTo, String message, String time) {
        IdFrom = idFrom;
        IdTo = idTo;
        Message = message;
        Time = time;
    }

    public int getIdFrom() {
        return IdFrom;
    }

    public void setIdFrom(int idFrom) {
        IdFrom = idFrom;
    }

    public int getIdTo() {
        return IdTo;
    }

    public void setIdTo(int idTo) {
        IdTo = idTo;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }
}
