package cse.duytan.coms.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Pham Van Thien on 6/27/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class Conversation {


    @SerializedName("PersonId")
    private int personId;
    @SerializedName("Name")
    private String name;
    @SerializedName("Message")
    private String message;
    @SerializedName("Image")
    private String image;

    public Conversation() {
    }

    public Conversation(int personId, String name, String message, String image) {
        this.personId = personId;
        this.name = name;
        this.message = message;
        this.image = image;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
