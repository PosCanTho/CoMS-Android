package cse.duytan.coms.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Pham Van Thien on 7/1/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class Message {

    @SerializedName("ConversationReplyId")
    private int conversationReplyId;
    @SerializedName("Message")
    private String message;
    @SerializedName("IsMoreThanOneDay")
    private boolean isMoreThanOneDay;
    @SerializedName("IsToDay")
    private boolean isToDay;
    @SerializedName("TimeFormat")
    private String timeFormat;
    @SerializedName("Time")
    private String time;
    @SerializedName("PersonIdFrom")
    private int personIdFrom;
    @SerializedName("PersonIdTo")
    private int personIdTo;

    public Message() {
    }

    public Message(int conversationReplyId, String message, boolean isMoreThanOneDay, boolean isToDay, String timeFormat, String time, int personIdFrom, int personIdTo) {
        this.conversationReplyId = conversationReplyId;
        this.message = message;
        this.isMoreThanOneDay = isMoreThanOneDay;
        this.isToDay = isToDay;
        this.timeFormat = timeFormat;
        this.time = time;
        this.personIdFrom = personIdFrom;
        this.personIdTo = personIdTo;
    }

    public int getConversationReplyId() {
        return conversationReplyId;
    }

    public void setConversationReplyId(int conversationReplyId) {
        this.conversationReplyId = conversationReplyId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isMoreThanOneDay() {
        return isMoreThanOneDay;
    }

    public void setMoreThanOneDay(boolean moreThanOneDay) {
        isMoreThanOneDay = moreThanOneDay;
    }

    public String getTimeFormat() {
        return timeFormat;
    }

    public void setTimeFormat(String timeFormat) {
        this.timeFormat = timeFormat;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getPersonIdFrom() {
        return personIdFrom;
    }

    public void setPersonIdFrom(int personIdFrom) {
        this.personIdFrom = personIdFrom;
    }

    public int getPersonIdTo() {
        return personIdTo;
    }

    public void setPersonIdTo(int personIdTo) {
        this.personIdTo = personIdTo;
    }

    public boolean isToDay() {
        return isToDay;
    }

    public void setToDay(boolean toDay) {
        isToDay = toDay;
    }
}
