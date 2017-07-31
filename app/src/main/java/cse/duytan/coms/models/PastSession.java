package cse.duytan.coms.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Pham Van Thien on 6/27/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class PastSession {

    @SerializedName("ConferenceId")
    private int conferenceId;
    @SerializedName("ConferenceName")
    private String conferenceName;
    @SerializedName("StartDate")
    private String startDate;
    @SerializedName("EndDate")
    private String endDate;
    @SerializedName("FacilityName")
    private String facilityName;
    private boolean isSelected;

    public PastSession() {
    }

    public PastSession(int conferenceId, String conferenceName, String startDate, String endDate, String facilityName, boolean isSelected) {
        this.conferenceId = conferenceId;
        this.conferenceName = conferenceName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.facilityName = facilityName;
        this.isSelected = isSelected;
    }

    public int getConferenceId() {
        return conferenceId;
    }

    public void setConferenceId(int conferenceId) {
        this.conferenceId = conferenceId;
    }

    public String getConferenceName() {
        return conferenceName;
    }

    public void setConferenceName(String conferenceName) {
        this.conferenceName = conferenceName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
