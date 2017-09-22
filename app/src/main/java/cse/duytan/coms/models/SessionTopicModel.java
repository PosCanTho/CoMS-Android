package cse.duytan.coms.models;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by lehoangdung on 8/29/2017.
 */

public class SessionTopicModel implements Serializable {


    @SerializedName("CONFERENCE_SESSION_TOPIC_ID")
    public int CONFERENCE_SESSION_TOPIC_ID;
    @SerializedName("CONFERENCE_SESSION_TOPIC_NAME")
    public String CONFERENCE_SESSION_TOPIC_NAME;
    @SerializedName("CONFERENCE_SESSION_TOPIC_NAME_EN")
    public String CONFERENCE_SESSION_TOPIC_NAME_EN;

    public SessionTopicModel() {
    }

    public SessionTopicModel(int CONFERENCE_SESSION_TOPIC_ID, String CONFERENCE_SESSION_TOPIC_NAME, String CONFERENCE_SESSION_TOPIC_NAME_EN) {
        this.CONFERENCE_SESSION_TOPIC_ID = CONFERENCE_SESSION_TOPIC_ID;
        this.CONFERENCE_SESSION_TOPIC_NAME = CONFERENCE_SESSION_TOPIC_NAME;
        this.CONFERENCE_SESSION_TOPIC_NAME_EN = CONFERENCE_SESSION_TOPIC_NAME_EN;
    }

    public int getCONFERENCE_SESSION_TOPIC_ID() {
        return CONFERENCE_SESSION_TOPIC_ID;
    }

    public void setCONFERENCE_SESSION_TOPIC_ID(int CONFERENCE_SESSION_TOPIC_ID) {
        this.CONFERENCE_SESSION_TOPIC_ID = CONFERENCE_SESSION_TOPIC_ID;
    }

    public String getCONFERENCE_SESSION_TOPIC_NAME() {
        return CONFERENCE_SESSION_TOPIC_NAME;
    }

    public void setCONFERENCE_SESSION_TOPIC_NAME(String CONFERENCE_SESSION_TOPIC_NAME) {
        this.CONFERENCE_SESSION_TOPIC_NAME = CONFERENCE_SESSION_TOPIC_NAME;
    }

    public String getCONFERENCE_SESSION_TOPIC_NAME_EN() {
        return CONFERENCE_SESSION_TOPIC_NAME_EN;
    }

    public void setCONFERENCE_SESSION_TOPIC_NAME_EN(String CONFERENCE_SESSION_TOPIC_NAME_EN) {
        this.CONFERENCE_SESSION_TOPIC_NAME_EN = CONFERENCE_SESSION_TOPIC_NAME_EN;
    }
}
