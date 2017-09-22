package cse.duytan.coms.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by lehoangdung on 9/12/2017.
 */

public class ReviewAbstractModel implements Serializable {

    @SerializedName("REVIEWED_DATE")
    public String REVIEWED_DATE;

    @SerializedName("PAPER_ABSTRACT_SUBMISSION_DEADLINE_ORDER_NUMBER")
    public int PAPER_ABSTRACT_SUBMISSION_DEADLINE_ORDER_NUMBER;

    @SerializedName("PROPOSED_CONFERENCE_SESSION_TOPIC_ID")
    public int PROPOSED_CONFERENCE_SESSION_TOPIC_ID;

    @SerializedName("PROPOSED_CONFERENCE_SESSION_TOPIC_NAME")
    public String PROPOSED_CONFERENCE_SESSION_TOPIC_NAME;

    @SerializedName("PROPOSED_CONFERENCE_SESSION_TOPIC_NAME_EN")
    public String PROPOSED_CONFERENCE_SESSION_TOPIC_NAME_EN;

    @SerializedName("PROPOSED_TYPE_OF_STUDY_ID")
    public int PROPOSED_TYPE_OF_STUDY_ID;

    @SerializedName("PROPOSED_TYPE_OF_STUDY_NAME")
    public String PROPOSED_TYPE_OF_STUDY_NAME;

    @SerializedName("PROPOSED_TYPE_OF_STUDY_NAME_EN")
    public String PROPOSED_TYPE_OF_STUDY_NAME_EN;

    @SerializedName("PROPOSED_FOR_PRESENTATION")
    public String PROPOSED_FOR_PRESENTATION;

    @SerializedName("PROPOSED_CONFERENCE_PRESENTATION_TYPE_ID")
    public int PROPOSED_CONFERENCE_PRESENTATION_TYPE_ID;

    @SerializedName("PROPOSED_CONFERENCE_PRESENTATION_TYPE_NAME")
    public String PROPOSED_CONFERENCE_PRESENTATION_TYPE_NAME;

    @SerializedName("PROPOSED_CONFERENCE_PRESENTATION_TYPE_NAME_EN")
    public String PROPOSED_CONFERENCE_PRESENTATION_TYPE_NAME_EN;

    @SerializedName("PAPER_ABSTRACT_REVIEW_RATING_POINT")
    public String PAPER_ABSTRACT_REVIEW_RATING_POINT;

    @SerializedName("SIGNIFICANT_REVISION_OR_MINIMAL_REVISION_OR_REVISION_NEEDED_OR_NO_REVISION_NEEDED")
    public String SIGNIFICANT_REVISION_OR_MINIMAL_REVISION_OR_REVISION_NEEDED_OR_NO_REVISION_NEEDED;

    @SerializedName("REVIEW_TEXT")
    public String REVIEW_TEXT;

    @SerializedName("REVIEW_TEXT_EN")
    public String REVIEW_TEXT_EN;

    @SerializedName("APPROVAL_OR_REJECTION_OF_PAPER_ABSTRACT")
    public boolean APPROVAL_OR_REJECTION_OF_PAPER_ABSTRACT;

    @SerializedName("APPROVAL_OR_REJECTION_OF_PAPER_ABSTRACT_DATE")
    public String APPROVAL_OR_REJECTION_OF_PAPER_ABSTRACT_DATE;

    public ReviewAbstractModel() {
    }

    public ReviewAbstractModel(String REVIEWED_DATE, int PAPER_ABSTRACT_SUBMISSION_DEADLINE_ORDER_NUMBER,
                               int PROPOSED_CONFERENCE_SESSION_TOPIC_ID, String PROPOSED_CONFERENCE_SESSION_TOPIC_NAME,
                               String PROPOSED_CONFERENCE_SESSION_TOPIC_NAME_EN, int PROPOSED_TYPE_OF_STUDY_ID,
                               String PROPOSED_TYPE_OF_STUDY_NAME, String PROPOSED_TYPE_OF_STUDY_NAME_EN,
                               String PROPOSED_FOR_PRESENTATION, int PROPOSED_CONFERENCE_PRESENTATION_TYPE_ID,
                               String PROPOSED_CONFERENCE_PRESENTATION_TYPE_NAME, String PROPOSED_CONFERENCE_PRESENTATION_TYPE_NAME_EN,
                               String PAPER_ABSTRACT_REVIEW_RATING_POINT,
                               String SIGNIFICANT_REVISION_OR_MINIMAL_REVISION_OR_REVISION_NEEDED_OR_NO_REVISION_NEEDED,
                               String REVIEW_TEXT, String REVIEW_TEXT_EN, boolean APPROVAL_OR_REJECTION_OF_PAPER_ABSTRACT,
                               String APPROVAL_OR_REJECTION_OF_PAPER_ABSTRACT_DATE) {
        this.REVIEWED_DATE = REVIEWED_DATE;
        this.PAPER_ABSTRACT_SUBMISSION_DEADLINE_ORDER_NUMBER = PAPER_ABSTRACT_SUBMISSION_DEADLINE_ORDER_NUMBER;
        this.PROPOSED_CONFERENCE_SESSION_TOPIC_ID = PROPOSED_CONFERENCE_SESSION_TOPIC_ID;
        this.PROPOSED_CONFERENCE_SESSION_TOPIC_NAME = PROPOSED_CONFERENCE_SESSION_TOPIC_NAME;
        this.PROPOSED_CONFERENCE_SESSION_TOPIC_NAME_EN = PROPOSED_CONFERENCE_SESSION_TOPIC_NAME_EN;
        this.PROPOSED_TYPE_OF_STUDY_ID = PROPOSED_TYPE_OF_STUDY_ID;
        this.PROPOSED_TYPE_OF_STUDY_NAME = PROPOSED_TYPE_OF_STUDY_NAME;
        this.PROPOSED_TYPE_OF_STUDY_NAME_EN = PROPOSED_TYPE_OF_STUDY_NAME_EN;
        this.PROPOSED_FOR_PRESENTATION = PROPOSED_FOR_PRESENTATION;
        this.PROPOSED_CONFERENCE_PRESENTATION_TYPE_ID = PROPOSED_CONFERENCE_PRESENTATION_TYPE_ID;
        this.PROPOSED_CONFERENCE_PRESENTATION_TYPE_NAME = PROPOSED_CONFERENCE_PRESENTATION_TYPE_NAME;
        this.PROPOSED_CONFERENCE_PRESENTATION_TYPE_NAME_EN = PROPOSED_CONFERENCE_PRESENTATION_TYPE_NAME_EN;
        this.PAPER_ABSTRACT_REVIEW_RATING_POINT = PAPER_ABSTRACT_REVIEW_RATING_POINT;
        this.SIGNIFICANT_REVISION_OR_MINIMAL_REVISION_OR_REVISION_NEEDED_OR_NO_REVISION_NEEDED = SIGNIFICANT_REVISION_OR_MINIMAL_REVISION_OR_REVISION_NEEDED_OR_NO_REVISION_NEEDED;
        this.REVIEW_TEXT = REVIEW_TEXT;
        this.REVIEW_TEXT_EN = REVIEW_TEXT_EN;
        this.APPROVAL_OR_REJECTION_OF_PAPER_ABSTRACT = APPROVAL_OR_REJECTION_OF_PAPER_ABSTRACT;
        this.APPROVAL_OR_REJECTION_OF_PAPER_ABSTRACT_DATE = APPROVAL_OR_REJECTION_OF_PAPER_ABSTRACT_DATE;
    }

    public String getREVIEWED_DATE() {
        return REVIEWED_DATE;
    }

    public void setREVIEWED_DATE(String REVIEWED_DATE) {
        this.REVIEWED_DATE = REVIEWED_DATE;
    }

    public int getPAPER_ABSTRACT_SUBMISSION_DEADLINE_ORDER_NUMBER() {
        return PAPER_ABSTRACT_SUBMISSION_DEADLINE_ORDER_NUMBER;
    }

    public void setPAPER_ABSTRACT_SUBMISSION_DEADLINE_ORDER_NUMBER(int PAPER_ABSTRACT_SUBMISSION_DEADLINE_ORDER_NUMBER) {
        this.PAPER_ABSTRACT_SUBMISSION_DEADLINE_ORDER_NUMBER = PAPER_ABSTRACT_SUBMISSION_DEADLINE_ORDER_NUMBER;
    }

    public int getPROPOSED_CONFERENCE_SESSION_TOPIC_ID() {
        return PROPOSED_CONFERENCE_SESSION_TOPIC_ID;
    }

    public void setPROPOSED_CONFERENCE_SESSION_TOPIC_ID(int PROPOSED_CONFERENCE_SESSION_TOPIC_ID) {
        this.PROPOSED_CONFERENCE_SESSION_TOPIC_ID = PROPOSED_CONFERENCE_SESSION_TOPIC_ID;
    }

    public String getPROPOSED_CONFERENCE_SESSION_TOPIC_NAME() {
        return PROPOSED_CONFERENCE_SESSION_TOPIC_NAME;
    }

    public void setPROPOSED_CONFERENCE_SESSION_TOPIC_NAME(String PROPOSED_CONFERENCE_SESSION_TOPIC_NAME) {
        this.PROPOSED_CONFERENCE_SESSION_TOPIC_NAME = PROPOSED_CONFERENCE_SESSION_TOPIC_NAME;
    }

    public String getPROPOSED_CONFERENCE_SESSION_TOPIC_NAME_EN() {
        return PROPOSED_CONFERENCE_SESSION_TOPIC_NAME_EN;
    }

    public void setPROPOSED_CONFERENCE_SESSION_TOPIC_NAME_EN(String PROPOSED_CONFERENCE_SESSION_TOPIC_NAME_EN) {
        this.PROPOSED_CONFERENCE_SESSION_TOPIC_NAME_EN = PROPOSED_CONFERENCE_SESSION_TOPIC_NAME_EN;
    }

    public int getPROPOSED_TYPE_OF_STUDY_ID() {
        return PROPOSED_TYPE_OF_STUDY_ID;
    }

    public void setPROPOSED_TYPE_OF_STUDY_ID(int PROPOSED_TYPE_OF_STUDY_ID) {
        this.PROPOSED_TYPE_OF_STUDY_ID = PROPOSED_TYPE_OF_STUDY_ID;
    }

    public String getPROPOSED_TYPE_OF_STUDY_NAME() {
        return PROPOSED_TYPE_OF_STUDY_NAME;
    }

    public void setPROPOSED_TYPE_OF_STUDY_NAME(String PROPOSED_TYPE_OF_STUDY_NAME) {
        this.PROPOSED_TYPE_OF_STUDY_NAME = PROPOSED_TYPE_OF_STUDY_NAME;
    }

    public String getPROPOSED_TYPE_OF_STUDY_NAME_EN() {
        return PROPOSED_TYPE_OF_STUDY_NAME_EN;
    }

    public void setPROPOSED_TYPE_OF_STUDY_NAME_EN(String PROPOSED_TYPE_OF_STUDY_NAME_EN) {
        this.PROPOSED_TYPE_OF_STUDY_NAME_EN = PROPOSED_TYPE_OF_STUDY_NAME_EN;
    }

    public String getPROPOSED_FOR_PRESENTATION() {
        return PROPOSED_FOR_PRESENTATION;
    }

    public void setPROPOSED_FOR_PRESENTATION(String PROPOSED_FOR_PRESENTATION) {
        this.PROPOSED_FOR_PRESENTATION = PROPOSED_FOR_PRESENTATION;
    }

    public int getPROPOSED_CONFERENCE_PRESENTATION_TYPE_ID() {
        return PROPOSED_CONFERENCE_PRESENTATION_TYPE_ID;
    }

    public void setPROPOSED_CONFERENCE_PRESENTATION_TYPE_ID(int PROPOSED_CONFERENCE_PRESENTATION_TYPE_ID) {
        this.PROPOSED_CONFERENCE_PRESENTATION_TYPE_ID = PROPOSED_CONFERENCE_PRESENTATION_TYPE_ID;
    }

    public String getPROPOSED_CONFERENCE_PRESENTATION_TYPE_NAME() {
        return PROPOSED_CONFERENCE_PRESENTATION_TYPE_NAME;
    }

    public void setPROPOSED_CONFERENCE_PRESENTATION_TYPE_NAME(String PROPOSED_CONFERENCE_PRESENTATION_TYPE_NAME) {
        this.PROPOSED_CONFERENCE_PRESENTATION_TYPE_NAME = PROPOSED_CONFERENCE_PRESENTATION_TYPE_NAME;
    }

    public String getPROPOSED_CONFERENCE_PRESENTATION_TYPE_NAME_EN() {
        return PROPOSED_CONFERENCE_PRESENTATION_TYPE_NAME_EN;
    }

    public void setPROPOSED_CONFERENCE_PRESENTATION_TYPE_NAME_EN(String PROPOSED_CONFERENCE_PRESENTATION_TYPE_NAME_EN) {
        this.PROPOSED_CONFERENCE_PRESENTATION_TYPE_NAME_EN = PROPOSED_CONFERENCE_PRESENTATION_TYPE_NAME_EN;
    }

    public String getPAPER_ABSTRACT_REVIEW_RATING_POINT() {
        return PAPER_ABSTRACT_REVIEW_RATING_POINT;
    }

    public void setPAPER_ABSTRACT_REVIEW_RATING_POINT(String PAPER_ABSTRACT_REVIEW_RATING_POINT) {
        this.PAPER_ABSTRACT_REVIEW_RATING_POINT = PAPER_ABSTRACT_REVIEW_RATING_POINT;
    }

    public String getSIGNIFICANT_REVISION_OR_MINIMAL_REVISION_OR_REVISION_NEEDED_OR_NO_REVISION_NEEDED() {
        return SIGNIFICANT_REVISION_OR_MINIMAL_REVISION_OR_REVISION_NEEDED_OR_NO_REVISION_NEEDED;
    }

    public void setSIGNIFICANT_REVISION_OR_MINIMAL_REVISION_OR_REVISION_NEEDED_OR_NO_REVISION_NEEDED(String SIGNIFICANT_REVISION_OR_MINIMAL_REVISION_OR_REVISION_NEEDED_OR_NO_REVISION_NEEDED) {
        this.SIGNIFICANT_REVISION_OR_MINIMAL_REVISION_OR_REVISION_NEEDED_OR_NO_REVISION_NEEDED = SIGNIFICANT_REVISION_OR_MINIMAL_REVISION_OR_REVISION_NEEDED_OR_NO_REVISION_NEEDED;
    }

    public String getREVIEW_TEXT() {
        return REVIEW_TEXT;
    }

    public void setREVIEW_TEXT(String REVIEW_TEXT) {
        this.REVIEW_TEXT = REVIEW_TEXT;
    }

    public String getREVIEW_TEXT_EN() {
        return REVIEW_TEXT_EN;
    }

    public void setREVIEW_TEXT_EN(String REVIEW_TEXT_EN) {
        this.REVIEW_TEXT_EN = REVIEW_TEXT_EN;
    }

    public boolean isAPPROVAL_OR_REJECTION_OF_PAPER_ABSTRACT() {
        return APPROVAL_OR_REJECTION_OF_PAPER_ABSTRACT;
    }

    public void setAPPROVAL_OR_REJECTION_OF_PAPER_ABSTRACT(boolean APPROVAL_OR_REJECTION_OF_PAPER_ABSTRACT) {
        this.APPROVAL_OR_REJECTION_OF_PAPER_ABSTRACT = APPROVAL_OR_REJECTION_OF_PAPER_ABSTRACT;
    }

    public String getAPPROVAL_OR_REJECTION_OF_PAPER_ABSTRACT_DATE() {
        return APPROVAL_OR_REJECTION_OF_PAPER_ABSTRACT_DATE;
    }

    public void setAPPROVAL_OR_REJECTION_OF_PAPER_ABSTRACT_DATE(String APPROVAL_OR_REJECTION_OF_PAPER_ABSTRACT_DATE) {
        this.APPROVAL_OR_REJECTION_OF_PAPER_ABSTRACT_DATE = APPROVAL_OR_REJECTION_OF_PAPER_ABSTRACT_DATE;
    }
}
