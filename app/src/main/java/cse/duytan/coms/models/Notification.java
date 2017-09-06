package cse.duytan.coms.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Pham Van Thien on 8/30/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class Notification {

    @SerializedName("NotificationId")
    public int NotificationId;
    @SerializedName("Title")
    public String Title;
    @SerializedName("Message")
    public String Message;
    @SerializedName("Image")
    public String Image;
    @SerializedName("PersonIdFrom")
    public int PersonIdFrom;
    @SerializedName("PersonIdTo")
    public int PersonIdTo;
    @SerializedName("Readed")
    public boolean Readed;
    @SerializedName("CreateDate")
    public String CreateDate;
    @SerializedName("NumberUnread")
    public int NumberUnread;

    public Notification() {
    }

    public Notification(int notificationId, String title, String message, String image, int personIdFrom, int personIdTo, boolean readed, String createDate, int numberUnread) {
        NotificationId = notificationId;
        Title = title;
        Message = message;
        Image = image;
        PersonIdFrom = personIdFrom;
        PersonIdTo = personIdTo;
        Readed = readed;
        CreateDate = createDate;
        NumberUnread = numberUnread;
    }

    public int getNotificationId() {
        return NotificationId;
    }

    public void setNotificationId(int notificationId) {
        NotificationId = notificationId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public int getPersonIdFrom() {
        return PersonIdFrom;
    }

    public void setPersonIdFrom(int personIdFrom) {
        PersonIdFrom = personIdFrom;
    }

    public int getPersonIdTo() {
        return PersonIdTo;
    }

    public void setPersonIdTo(int personIdTo) {
        PersonIdTo = personIdTo;
    }

    public boolean isReaded() {
        return Readed;
    }

    public void setReaded(boolean readed) {
        Readed = readed;
    }

    public String getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(String createDate) {
        CreateDate = createDate;
    }

    public int getNumberUnread() {
        return NumberUnread;
    }

    public void setNumberUnread(int numberUnread) {
        NumberUnread = numberUnread;
    }
}
