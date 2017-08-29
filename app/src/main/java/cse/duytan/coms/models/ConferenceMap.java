package cse.duytan.coms.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Pham Van Thien on 8/26/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class ConferenceMap {

    @SerializedName("CONFERENCE_MAP_ID")
    private int CONFERENCE_MAP_ID;
    @SerializedName("CONFERENCE_ID")
    private int CONFERENCE_ID;
    @SerializedName("CONFERENCE_NAME")
    private String CONFERENCE_NAME;
    @SerializedName("CONFERENCE_NAME_EN")
    private String CONFERENCE_NAME_EN;
    @SerializedName("IMAGE")
    private String IMAGE;
    @SerializedName("DESCRIPTION")
    private String DESCRIPTION;

    public ConferenceMap() {
    }

    public ConferenceMap(int CONFERENCE_MAP_ID, int CONFERENCE_ID, String CONFERENCE_NAME, String CONFERENCE_NAME_EN, String IMAGE, String DESCRIPTION) {
        this.CONFERENCE_MAP_ID = CONFERENCE_MAP_ID;
        this.CONFERENCE_ID = CONFERENCE_ID;
        this.CONFERENCE_NAME = CONFERENCE_NAME;
        this.CONFERENCE_NAME_EN = CONFERENCE_NAME_EN;
        this.IMAGE = IMAGE;
        this.DESCRIPTION = DESCRIPTION;
    }

    public int getCONFERENCE_MAP_ID() {
        return CONFERENCE_MAP_ID;
    }

    public void setCONFERENCE_MAP_ID(int CONFERENCE_MAP_ID) {
        this.CONFERENCE_MAP_ID = CONFERENCE_MAP_ID;
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

    public String getIMAGE() {
        return IMAGE;
    }

    public void setIMAGE(String IMAGE) {
        this.IMAGE = IMAGE;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }
}
