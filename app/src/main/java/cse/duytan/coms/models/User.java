package cse.duytan.coms.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Pham Van Thien on 7/6/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class User {

    @SerializedName("PersonId")
    private int personId;
    @SerializedName("Fullname")
    private String fullname;
    @SerializedName("Email")
    private String email;
    @SerializedName("PhoneNumber")
    private String phoneNumber;
    @SerializedName("BirthDay")
    private String birthDay;
    @SerializedName("Gender")
    private int gender;
    @SerializedName("Image")
    private String Image;

    public User() {
    }

    public User(int personId, String fullname, String email, String phoneNumber, String birthDay, int gender, String image) {
        this.personId = personId;
        this.fullname = fullname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthDay = birthDay;
        this.gender = gender;
        Image = image;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
