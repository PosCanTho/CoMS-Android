package cse.duytan.coms.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by iMac on 8/31/17.
 */

public class Schedule {
    @SerializedName("CONFERENCE_ID")
    public int CONFERENCE_ID;
    @SerializedName("CONFERENCE_NAME")
    public String CONFERENCE_NAME;
    @SerializedName("CONFERENCE_NAME_EN")
    public String CONFERENCE_NAME_EN;
    @SerializedName("FROM_DATE")
    public String FROM_DATE;
    @SerializedName("THRU_DATE")
    public String THRU_DATE;

    public Schedule() {
    }

    public Schedule(int CONFERENCE_ID, String CONFERENCE_NAME, String CONFERENCE_NAME_EN, String FROM_DATE, String THRU_DATE) {
        this.CONFERENCE_ID = CONFERENCE_ID;
        this.CONFERENCE_NAME = CONFERENCE_NAME;
        this.CONFERENCE_NAME_EN = CONFERENCE_NAME_EN;
        this.FROM_DATE = FROM_DATE;
        this.THRU_DATE = THRU_DATE;
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
