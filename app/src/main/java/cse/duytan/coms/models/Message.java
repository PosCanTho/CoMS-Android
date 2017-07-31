package cse.duytan.coms.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Pham Van Thien on 7/1/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class Message {

    @SerializedName("CONVERSATION_REPLY_ID")
    public int conversationReply;
    @SerializedName("MESSAGE")
    public String message;
    @SerializedName("TIME")
    public String time;
    @SerializedName("PERSON_ID_FROM")
    public int personIdFrom;
    @SerializedName("PERSON_ID_TO")
    public int personIdTo;

    public Message() {
    }

    public Message(int conversationReply, String message, String time, int personIdFrom, int personIdTo) {
        this.conversationReply = conversationReply;
        this.message = message;
        this.time = time;
        this.personIdFrom = personIdFrom;
        this.personIdTo = personIdTo;
    }

    public int getConversationReply() {
        return conversationReply;
    }

    public void setConversationReply(int conversationReply) {
        this.conversationReply = conversationReply;
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
}
