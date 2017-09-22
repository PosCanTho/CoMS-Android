package cse.duytan.coms.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by lehoangdung on 9/7/2017.
 */

public class SeeAbstractModel implements Serializable {

    @SerializedName("PAPER_ABSTRACT_TITLE")
    public String PAPER_ABSTRACT_TITLE;

    @SerializedName("PAPER_ABSTRACT_TITLE_EN")
    public String PAPER_ABSTRACT_TITLE_EN;

    @SerializedName("CONFERENCE_SESSION_TOPIC_NAME")
    public String CONFERENCE_SESSION_TOPIC_NAME;

    @SerializedName("TYPE_OF_STUDY_NAME")
    public String TYPE_OF_STUDY_NAME;

    @SerializedName("CONFERENCE_PRESENTATION_TYPE_NAME")
    public String CONFERENCE_PRESENTATION_TYPE_NAME;

    @SerializedName("PAPER_ABSTRACT_TEXT")
    public String PAPER_ABSTRACT_TEXT;

    public SeeAbstractModel() {
    }

    public SeeAbstractModel(String PAPER_ABSTRACT_TITLE, String PAPER_ABSTRACT_TITLE_EN, String CONFERENCE_SESSION_TOPIC_NAME,
                            String TYPE_OF_STUDY_NAME, String CONFERENCE_PRESENTATION_TYPE_NAME, String PAPER_ABSTRACT_TEXT) {
        this.PAPER_ABSTRACT_TITLE = PAPER_ABSTRACT_TITLE;
        this.PAPER_ABSTRACT_TITLE_EN = PAPER_ABSTRACT_TITLE_EN;
        this.CONFERENCE_SESSION_TOPIC_NAME = CONFERENCE_SESSION_TOPIC_NAME;
        this.TYPE_OF_STUDY_NAME = TYPE_OF_STUDY_NAME;
        this.CONFERENCE_PRESENTATION_TYPE_NAME = CONFERENCE_PRESENTATION_TYPE_NAME;
        this.PAPER_ABSTRACT_TEXT = PAPER_ABSTRACT_TEXT;
    }

    public String getPAPER_ABSTRACT_TITLE() {
        return PAPER_ABSTRACT_TITLE;
    }

    public void setPAPER_ABSTRACT_TITLE(String PAPER_ABSTRACT_TITLE) {
        this.PAPER_ABSTRACT_TITLE = PAPER_ABSTRACT_TITLE;
    }

    public String getPAPER_ABSTRACT_TITLE_EN() {
        return PAPER_ABSTRACT_TITLE_EN;
    }

    public void setPAPER_ABSTRACT_TITLE_EN(String PAPER_ABSTRACT_TITLE_EN) {
        this.PAPER_ABSTRACT_TITLE_EN = PAPER_ABSTRACT_TITLE_EN;
    }

    public String getCONFERENCE_SESSION_TOPIC_NAME() {
        return CONFERENCE_SESSION_TOPIC_NAME;
    }

    public void setCONFERENCE_SESSION_TOPIC_NAME(String CONFERENCE_SESSION_TOPIC_NAME) {
        this.CONFERENCE_SESSION_TOPIC_NAME = CONFERENCE_SESSION_TOPIC_NAME;
    }

    public String getTYPE_OF_STUDY_NAME() {
        return TYPE_OF_STUDY_NAME;
    }

    public void setTYPE_OF_STUDY_NAME(String TYPE_OF_STUDY_NAME) {
        this.TYPE_OF_STUDY_NAME = TYPE_OF_STUDY_NAME;
    }

    public String getCONFERENCE_PRESENTATION_TYPE_NAME() {
        return CONFERENCE_PRESENTATION_TYPE_NAME;
    }

    public void setCONFERENCE_PRESENTATION_TYPE_NAME(String CONFERENCE_PRESENTATION_TYPE_NAME) {
        this.CONFERENCE_PRESENTATION_TYPE_NAME = CONFERENCE_PRESENTATION_TYPE_NAME;
    }

    public String getPAPER_ABSTRACT_TEXT() {
        return PAPER_ABSTRACT_TEXT;
    }

    public void setPAPER_ABSTRACT_TEXT(String PAPER_ABSTRACT_TEXT) {
        this.PAPER_ABSTRACT_TEXT = PAPER_ABSTRACT_TEXT;
    }
}
