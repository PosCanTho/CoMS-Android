package cse.duytan.coms.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Pham Van Thien on 7/27/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class Bookmark {

    @SerializedName("BOOKMARK_ID")
    private int bookmarkId;
    @SerializedName("PERSON_ID")
    private int personId;
    @SerializedName("PERSON_ID_BOOKMARK")
    private int personIdBookmark;
    @SerializedName("NAME_BOOKMARK")
    private String nameBookmark;
    @SerializedName("IMAGE_BOOKMARK")
    private String imageBookmark;
    @SerializedName("DESCRIPTION")
    private String description;
    @SerializedName("CREATE_DATE")
    private String createDate;

    public Bookmark() {
    }

    public Bookmark(int bookmarkId, int personId, int personIdBookmark, String nameBookmark, String imageBookmark, String description, String createDate) {
        this.bookmarkId = bookmarkId;
        this.personId = personId;
        this.personIdBookmark = personIdBookmark;
        this.nameBookmark = nameBookmark;
        this.imageBookmark = imageBookmark;
        this.description = description;
        this.createDate = createDate;
    }

    public int getBookmarkId() {
        return bookmarkId;
    }

    public void setBookmarkId(int bookmarkId) {
        this.bookmarkId = bookmarkId;
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

    public String getNameBookmark() {
        return nameBookmark;
    }

    public void setNameBookmark(String nameBookmark) {
        this.nameBookmark = nameBookmark;
    }

    public String getImageBookmark() {
        return imageBookmark;
    }

    public void setImageBookmark(String imageBookmark) {
        this.imageBookmark = imageBookmark;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
