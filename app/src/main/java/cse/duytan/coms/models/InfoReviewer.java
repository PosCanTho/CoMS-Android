package cse.duytan.coms.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by lehoangdung on 9/13/2017.
 */

public class InfoReviewer implements Serializable {

    @SerializedName("PERSON_ID")
    public int PERSON_ID;
    @SerializedName("CURRENT_LAST_NAME")
    public String CURRENT_LAST_NAME;
    @SerializedName("CURRENT_FIRST_NAME")
    public String CURRENT_FIRST_NAME;
    @SerializedName("CURRENT_MIDDLE_NAME")
    public String CURRENT_MIDDLE_NAME;

    public InfoReviewer() {
    }

    public InfoReviewer(int PERSON_ID, String CURRENT_LAST_NAME, String CURRENT_FIRST_NAME, String CURRENT_MIDDLE_NAME) {
        this.PERSON_ID = PERSON_ID;
        this.CURRENT_LAST_NAME = CURRENT_LAST_NAME;
        this.CURRENT_FIRST_NAME = CURRENT_FIRST_NAME;
        this.CURRENT_MIDDLE_NAME = CURRENT_MIDDLE_NAME;
    }

    public int getPERSON_ID() {
        return PERSON_ID;
    }

    public void setPERSON_ID(int PERSON_ID) {
        this.PERSON_ID = PERSON_ID;
    }

    public String getCURRENT_LAST_NAME() {
        return CURRENT_LAST_NAME;
    }

    public void setCURRENT_LAST_NAME(String CURRENT_LAST_NAME) {
        this.CURRENT_LAST_NAME = CURRENT_LAST_NAME;
    }

    public String getCURRENT_FIRST_NAME() {
        return CURRENT_FIRST_NAME;
    }

    public void setCURRENT_FIRST_NAME(String CURRENT_FIRST_NAME) {
        this.CURRENT_FIRST_NAME = CURRENT_FIRST_NAME;
    }

    public String getCURRENT_MIDDLE_NAME() {
        return CURRENT_MIDDLE_NAME;
    }

    public void setCURRENT_MIDDLE_NAME(String CURRENT_MIDDLE_NAME) {
        this.CURRENT_MIDDLE_NAME = CURRENT_MIDDLE_NAME;
    }
}
