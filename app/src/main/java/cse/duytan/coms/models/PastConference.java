package cse.duytan.coms.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Pham Van Thien on 6/27/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class PastConference {

    @SerializedName("PERSON_ID")
    private int PERSON_ID;
    @SerializedName("CURRENT_FIRST_NAME")
    private String CURRENT_FIRST_NAME;
    @SerializedName("CURRENT_MIDDLE_NAME")
    private String CURRENT_MIDDLE_NAME;
    @SerializedName("CURRENT_LAST_NAME")
    private String CURRENT_LAST_NAME;
    @SerializedName("CONFERENCE_ID")
    private int CONFERENCE_ID;
    @SerializedName("CONFERENCE_NAME")
    private String CONFERENCE_NAME;
    @SerializedName("CONFERENCE_NAME_EN")
    private String CONFERENCE_NAME_EN;
    @SerializedName("FROM_DATE")
    private String FROM_DATE;
    @SerializedName("THRU_DATE")
    private String THRU_DATE;

    private boolean isSelected;

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public PastConference() {
    }

    public PastConference(int PERSON_ID, String CURRENT_FIRST_NAME, String CURRENT_MIDDLE_NAME, String CURRENT_LAST_NAME, int CONFERENCE_ID, String CONFERENCE_NAME, String CONFERENCE_NAME_EN, String FROM_DATE, String THRU_DATE) {
        this.PERSON_ID = PERSON_ID;
        this.CURRENT_FIRST_NAME = CURRENT_FIRST_NAME;
        this.CURRENT_MIDDLE_NAME = CURRENT_MIDDLE_NAME;
        this.CURRENT_LAST_NAME = CURRENT_LAST_NAME;
        this.CONFERENCE_ID = CONFERENCE_ID;
        this.CONFERENCE_NAME = CONFERENCE_NAME;
        this.CONFERENCE_NAME_EN = CONFERENCE_NAME_EN;
        this.FROM_DATE = FROM_DATE;
        this.THRU_DATE = THRU_DATE;
    }

    public int getPERSON_ID() {
        return PERSON_ID;
    }

    public void setPERSON_ID(int PERSON_ID) {
        this.PERSON_ID = PERSON_ID;
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

    public String getCURRENT_LAST_NAME() {
        return CURRENT_LAST_NAME;
    }

    public void setCURRENT_LAST_NAME(String CURRENT_LAST_NAME) {
        this.CURRENT_LAST_NAME = CURRENT_LAST_NAME;
    }

    public int getCONFERENCE_ID() {
        return CONFERENCE_ID;
    }

    public void setCONFERENCE_ID(int CONFERENCE_ID) {
        this.CONFERENCE_ID = CONFERENCE_ID;
    }

    public String getCONFERENCE_NAME() {
        return CONFERENCE_NAME;
    }

    public void setCONFERENCE_NAME(String CONFERENCE_NAME) {
        this.CONFERENCE_NAME = CONFERENCE_NAME;
    }

    public String getCONFERENCE_NAME_EN() {
        return CONFERENCE_NAME_EN;
    }

    public void setCONFERENCE_NAME_EN(String CONFERENCE_NAME_EN) {
        this.CONFERENCE_NAME_EN = CONFERENCE_NAME_EN;
    }

    public String getFROM_DATE() {
        return FROM_DATE;
    }

    public void setFROM_DATE(String FROM_DATE) {
        this.FROM_DATE = FROM_DATE;
    }

    public String getTHRU_DATE() {
        return THRU_DATE;
    }

    public void setTHRU_DATE(String THRU_DATE) {
        this.THRU_DATE = THRU_DATE;
    }
}
