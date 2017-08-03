package cse.duytan.coms.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Pham Van Thien on 6/16/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class Account {

    @SerializedName("PersonId")
    private int personId;
    @SerializedName("Name")
    private String name;
    @SerializedName("Image")
    private String image;

    public Account() {
    }

    public Account(int personId, String name, String image) {
        this.personId = personId;
        this.name = name;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
