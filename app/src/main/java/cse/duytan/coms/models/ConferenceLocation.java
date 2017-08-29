package cse.duytan.coms.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Pham Van Thien on 8/26/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class ConferenceLocation {

    @SerializedName("CONFERENCE_LOCATION_ID")
    private int CONFERENCE_LOCATION_ID;
    @SerializedName("CONFERENCE_MAP_ID")
    private int CONFERENCE_MAP_ID;
    @SerializedName("LOCATION_LAT")
    private int LOCATION_LAT;
    @SerializedName("LOCATION_LONG")
    private int LOCATION_LONG;
    @SerializedName("DESCRIPTION")
    private String DESCRIPTION;

    public ConferenceLocation() {
    }

    public ConferenceLocation(int CONFERENCE_LOCATION_ID, int CONFERENCE_MAP_ID, int LOCATION_LAT, int LOCATION_LONG, String DESCRIPTION) {
        this.CONFERENCE_LOCATION_ID = CONFERENCE_LOCATION_ID;
        this.CONFERENCE_MAP_ID = CONFERENCE_MAP_ID;
        this.LOCATION_LAT = LOCATION_LAT;
        this.LOCATION_LONG = LOCATION_LONG;
        this.DESCRIPTION = DESCRIPTION;
    }

    public int getCONFERENCE_LOCATION_ID() {
        return CONFERENCE_LOCATION_ID;
    }

    public void setCONFERENCE_LOCATION_ID(int CONFERENCE_LOCATION_ID) {
        this.CONFERENCE_LOCATION_ID = CONFERENCE_LOCATION_ID;
    }

    public int getCONFERENCE_MAP_ID() {
        return CONFERENCE_MAP_ID;
    }

    public void setCONFERENCE_MAP_ID(int CONFERENCE_MAP_ID) {
        this.CONFERENCE_MAP_ID = CONFERENCE_MAP_ID;
    }

    public int getLOCATION_LAT() {
        return LOCATION_LAT;
    }

    public void setLOCATION_LAT(int LOCATION_LAT) {
        this.LOCATION_LAT = LOCATION_LAT;
    }

    public int getLOCATION_LONG() {
        return LOCATION_LONG;
    }

    public void setLOCATION_LONG(int LOCATION_LONG) {
        this.LOCATION_LONG = LOCATION_LONG;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }
}
