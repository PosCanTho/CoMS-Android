package cse.duytan.coms.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Pham Van Thien on 7/28/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class Profile {

    @SerializedName("PersonId")
    public int personId;
    @SerializedName("PersonIdBookmark")
    public int personIdBookmark;
    @SerializedName("Image")
    public String image;
    @SerializedName("Name")
    public String name;
    @SerializedName("Description")
    public String description;
    @SerializedName("FacebookUrl")
    public String facebookUrl;
    @SerializedName("TwitterUrl")
    public String twitterUrl;
    @SerializedName("Instagram")
    public String instagram;
    @SerializedName("IsBookmark")
    public boolean isBookmark;
    @SerializedName("ListPastSession")
    public List<PastSession> listPastSession;

    public Profile() {
    }

    public Profile(int personId, int personIdBookmark, String image, String name, String description, String facebookUrl, String twitterUrl, String instagram, boolean isBookmark, List<PastSession> listPastSession) {
        this.personId = personId;
        this.personIdBookmark = personIdBookmark;
        this.image = image;
        this.name = name;
        this.description = description;
        this.facebookUrl = facebookUrl;
        this.twitterUrl = twitterUrl;
        this.instagram = instagram;
        this.isBookmark = isBookmark;
        this.listPastSession = listPastSession;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getPersonIdBookmark() {
        return personIdBookmark;
    }

    public void setPersonIdBookmark(int personIdBookmark) {
        this.personIdBookmark = personIdBookmark;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFacebookUrl() {
        return facebookUrl;
    }

    public void setFacebookUrl(String facebookUrl) {
        this.facebookUrl = facebookUrl;
    }

    public String getTwitterUrl() {
        return twitterUrl;
    }

    public void setTwitterUrl(String twitterUrl) {
        this.twitterUrl = twitterUrl;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public boolean isBookmark() {
        return isBookmark;
    }

    public void setBookmark(boolean bookmark) {
        isBookmark = bookmark;
    }

    public List<PastSession> getListPastSession() {
        return listPastSession;
    }

    public void setListPastSession(List<PastSession> listPastSession) {
        this.listPastSession = listPastSession;
    }
}
