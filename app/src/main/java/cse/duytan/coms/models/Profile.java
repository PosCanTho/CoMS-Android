package cse.duytan.coms.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Pham Van Thien on 7/28/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class Profile {

    @SerializedName("PersonId")
    private int PersonId;
    @SerializedName("PersonIdBookmark")
    private int PersonIdBookmark;
    @SerializedName("Image")
    private String Image;
    @SerializedName("Name")
    private String Name;
    @SerializedName("Description")
    private String Description;
    @SerializedName("FacebookUrl")
    private String FacebookUrl;
    @SerializedName("TwitterUrl")
    private String TwitterUrl;
    @SerializedName("Instagram")
    private String Instagram;
    @SerializedName("IsBookmark")
    private boolean IsBookmark;
    @SerializedName("ListPastConference")
    private ArrayList<PastConference> ListPastConference;

    public int getPersonId() {
        return PersonId;
    }

    public void setPersonId(int personId) {
        PersonId = personId;
    }

    public int getPersonIdBookmark() {
        return PersonIdBookmark;
    }

    public void setPersonIdBookmark(int personIdBookmark) {
        PersonIdBookmark = personIdBookmark;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getFacebookUrl() {
        return FacebookUrl;
    }

    public void setFacebookUrl(String facebookUrl) {
        FacebookUrl = facebookUrl;
    }

    public String getTwitterUrl() {
        return TwitterUrl;
    }

    public void setTwitterUrl(String twitterUrl) {
        TwitterUrl = twitterUrl;
    }

    public String getInstagram() {
        return Instagram;
    }

    public void setInstagram(String instagram) {
        Instagram = instagram;
    }

    public boolean isBookmark() {
        return IsBookmark;
    }

    public void setBookmark(boolean bookmark) {
        IsBookmark = bookmark;
    }

    public ArrayList<PastConference> getListPastConference() {
        return ListPastConference;
    }

    public void setListPastConference(ArrayList<PastConference> listPastConference) {
        ListPastConference = listPastConference;
    }

    public Profile() {
    }

    public Profile(int personId, int personIdBookmark, String image, String name, String description, String facebookUrl, String twitterUrl, String instagram, boolean isBookmark, ArrayList<PastConference> listPastConference) {
        PersonId = personId;
        PersonIdBookmark = personIdBookmark;
        Image = image;
        Name = name;
        Description = description;
        FacebookUrl = facebookUrl;
        TwitterUrl = twitterUrl;
        Instagram = instagram;
        IsBookmark = isBookmark;
        ListPastConference = listPastConference;
    }
}
