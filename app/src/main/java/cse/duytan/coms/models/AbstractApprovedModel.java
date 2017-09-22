package cse.duytan.coms.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by lehoangdung on 9/14/2017.
 */

public class AbstractApprovedModel implements Serializable {

    @SerializedName("PERSON_ID")
    public int PERSON_ID;
    @SerializedName("CONFERENCE_ID")
    public int CONFERENCE_ID;
    @SerializedName("ORGANIZATION_NAME_1")
    public String ORGANIZATION_NAME_1;
    @SerializedName("ORGANIZATION_NAME_2")
    public String ORGANIZATION_NAME_2;
    @SerializedName("ORGANIZATION_NAME_3")
    public String ORGANIZATION_NAME_3;
    @SerializedName("ORGANIZATION_NAME_4")
    public String ORGANIZATION_NAME_4;
    @SerializedName("ORGANIZATION_NAME_5")
    public String ORGANIZATION_NAME_5;
    @SerializedName("CORRESPONDING_AUTHOR")
    public String CORRESPONDING_AUTHOR;
    @SerializedName("PAPER_ID")
    public int PAPER_ID;
    @SerializedName("CONFERENCE_NAME")
    public String CONFERENCE_NAME;
    @SerializedName("PAPER_ABSTRACT_DEADLINE")
    public String PAPER_ABSTRACT_DEADLINE;
    @SerializedName("PAPER_ABSTRACT_TITLE")
    public String PAPER_ABSTRACT_TITLE;
    @SerializedName("PAPER_ABSTRACT_TITLE_EN")
    public String PAPER_ABSTRACT_TITLE_EN;
    @SerializedName("CONFERENCE_SESSION_TOPIC_ID")
    public int CONFERENCE_SESSION_TOPIC_ID;
    @SerializedName("CONFERENCE_SESSION_TOPIC_NAME")
    public String CONFERENCE_SESSION_TOPIC_NAME;
    @SerializedName("CONFERENCE_SESSION_TOPIC_NAME_EN")
    public String CONFERENCE_SESSION_TOPIC_NAME_EN;
    @SerializedName("PAPER_ABSTRACT_TEXT")
    public String PAPER_ABSTRACT_TEXT;
    @SerializedName("FULL_PAPER_OR_WORK_IN_PROGRESS")
    public String FULL_PAPER_OR_WORK_IN_PROGRESS;
    @SerializedName("TYPE_OF_STUDY_ID")
    public int TYPE_OF_STUDY_ID;
    @SerializedName("TYPE_OF_STUDY_NAME")
    public String TYPE_OF_STUDY_NAME;
    @SerializedName("TYPE_OF_STUDY_NAME_EN")
    public String TYPE_OF_STUDY_NAME_EN;
    @SerializedName("CONFERENCE_PRESENTATION_TYPE_ID")
    public int CONFERENCE_PRESENTATION_TYPE_ID;
    @SerializedName("CONFERENCE_PRESENTATION_TYPE_NAME")
    public String CONFERENCE_PRESENTATION_TYPE_NAME;
    @SerializedName("CONFERENCE_PRESENTATION_TYPE_NAME_EN")
    public String CONFERENCE_PRESENTATION_TYPE_NAME_EN;
    @SerializedName("FIRST_SUBMITTED_DATE")
    public String FIRST_SUBMITTED_DATE;
    @SerializedName("LAST_REVISED_DATE")
    public String LAST_REVISED_DATE;
    @SerializedName("FINAL_APPROVAL_OR_REJECTION_OF_PAPER_ABSTRACT")
    public boolean FINAL_APPROVAL_OR_REJECTION_OF_PAPER_ABSTRACT;
    @SerializedName("FROM_DATE")
    public String FROM_DATE;
    @SerializedName("THRU_DATE")
    public String THRU_DATE;
    @SerializedName("PAPER_ABSTRACT_WITHDRAWN")
    public String PAPER_ABSTRACT_WITHDRAWN;
    @SerializedName("POSITION")
    public int POSITION;

    public AbstractApprovedModel() {
    }

    public AbstractApprovedModel(int PERSON_ID, int CONFERENCE_ID, String ORGANIZATION_NAME_1, String ORGANIZATION_NAME_2,
                                 String ORGANIZATION_NAME_3, String ORGANIZATION_NAME_4, String ORGANIZATION_NAME_5,
                                 String CORRESPONDING_AUTHOR, int PAPER_ID, String CONFERENCE_NAME, String PAPER_ABSTRACT_DEADLINE,
                                 String PAPER_ABSTRACT_TITLE, String PAPER_ABSTRACT_TITLE_EN, int CONFERENCE_SESSION_TOPIC_ID,
                                 String CONFERENCE_SESSION_TOPIC_NAME, String CONFERENCE_SESSION_TOPIC_NAME_EN,
                                 String PAPER_ABSTRACT_TEXT, String FULL_PAPER_OR_WORK_IN_PROGRESS, int TYPE_OF_STUDY_ID,
                                 String TYPE_OF_STUDY_NAME, String TYPE_OF_STUDY_NAME_EN, int CONFERENCE_PRESENTATION_TYPE_ID,
                                 String CONFERENCE_PRESENTATION_TYPE_NAME, String CONFERENCE_PRESENTATION_TYPE_NAME_EN,
                                 String FIRST_SUBMITTED_DATE, String LAST_REVISED_DATE,
                                 boolean FINAL_APPROVAL_OR_REJECTION_OF_PAPER_ABSTRACT, String FROM_DATE, String THRU_DATE,
                                 String PAPER_ABSTRACT_WITHDRAWN, int POSITION) {
        this.PERSON_ID = PERSON_ID;
        this.CONFERENCE_ID = CONFERENCE_ID;
        this.ORGANIZATION_NAME_1 = ORGANIZATION_NAME_1;
        this.ORGANIZATION_NAME_2 = ORGANIZATION_NAME_2;
        this.ORGANIZATION_NAME_3 = ORGANIZATION_NAME_3;
        this.ORGANIZATION_NAME_4 = ORGANIZATION_NAME_4;
        this.ORGANIZATION_NAME_5 = ORGANIZATION_NAME_5;
        this.CORRESPONDING_AUTHOR = CORRESPONDING_AUTHOR;
        this.PAPER_ID = PAPER_ID;
        this.CONFERENCE_NAME = CONFERENCE_NAME;
        this.PAPER_ABSTRACT_DEADLINE = PAPER_ABSTRACT_DEADLINE;
        this.PAPER_ABSTRACT_TITLE = PAPER_ABSTRACT_TITLE;
        this.PAPER_ABSTRACT_TITLE_EN = PAPER_ABSTRACT_TITLE_EN;
        this.CONFERENCE_SESSION_TOPIC_ID = CONFERENCE_SESSION_TOPIC_ID;
        this.CONFERENCE_SESSION_TOPIC_NAME = CONFERENCE_SESSION_TOPIC_NAME;
        this.CONFERENCE_SESSION_TOPIC_NAME_EN = CONFERENCE_SESSION_TOPIC_NAME_EN;
        this.PAPER_ABSTRACT_TEXT = PAPER_ABSTRACT_TEXT;
        this.FULL_PAPER_OR_WORK_IN_PROGRESS = FULL_PAPER_OR_WORK_IN_PROGRESS;
        this.TYPE_OF_STUDY_ID = TYPE_OF_STUDY_ID;
        this.TYPE_OF_STUDY_NAME = TYPE_OF_STUDY_NAME;
        this.TYPE_OF_STUDY_NAME_EN = TYPE_OF_STUDY_NAME_EN;
        this.CONFERENCE_PRESENTATION_TYPE_ID = CONFERENCE_PRESENTATION_TYPE_ID;
        this.CONFERENCE_PRESENTATION_TYPE_NAME = CONFERENCE_PRESENTATION_TYPE_NAME;
        this.CONFERENCE_PRESENTATION_TYPE_NAME_EN = CONFERENCE_PRESENTATION_TYPE_NAME_EN;
        this.FIRST_SUBMITTED_DATE = FIRST_SUBMITTED_DATE;
        this.LAST_REVISED_DATE = LAST_REVISED_DATE;
        this.FINAL_APPROVAL_OR_REJECTION_OF_PAPER_ABSTRACT = FINAL_APPROVAL_OR_REJECTION_OF_PAPER_ABSTRACT;
        this.FROM_DATE = FROM_DATE;
        this.THRU_DATE = THRU_DATE;
        this.PAPER_ABSTRACT_WITHDRAWN = PAPER_ABSTRACT_WITHDRAWN;
        this.POSITION = POSITION;
    }

    public int getPERSON_ID() {
        return PERSON_ID;
    }

    public void setPERSON_ID(int PERSON_ID) {
        this.PERSON_ID = PERSON_ID;
    }

    public int getCONFERENCE_ID() {
        return CONFERENCE_ID;
    }

    public void setCONFERENCE_ID(int CONFERENCE_ID) {
        this.CONFERENCE_ID = CONFERENCE_ID;
    }

    public String getORGANIZATION_NAME_1() {
        return ORGANIZATION_NAME_1;
    }

    public void setORGANIZATION_NAME_1(String ORGANIZATION_NAME_1) {
        this.ORGANIZATION_NAME_1 = ORGANIZATION_NAME_1;
    }

    public String getORGANIZATION_NAME_2() {
        return ORGANIZATION_NAME_2;
    }

    public void setORGANIZATION_NAME_2(String ORGANIZATION_NAME_2) {
        this.ORGANIZATION_NAME_2 = ORGANIZATION_NAME_2;
    }

    public String getORGANIZATION_NAME_3() {
        return ORGANIZATION_NAME_3;
    }

    public void setORGANIZATION_NAME_3(String ORGANIZATION_NAME_3) {
        this.ORGANIZATION_NAME_3 = ORGANIZATION_NAME_3;
    }

    public String getORGANIZATION_NAME_4() {
        return ORGANIZATION_NAME_4;
    }

    public void setORGANIZATION_NAME_4(String ORGANIZATION_NAME_4) {
        this.ORGANIZATION_NAME_4 = ORGANIZATION_NAME_4;
    }

    public String getORGANIZATION_NAME_5() {
        return ORGANIZATION_NAME_5;
    }

    public void setORGANIZATION_NAME_5(String ORGANIZATION_NAME_5) {
        this.ORGANIZATION_NAME_5 = ORGANIZATION_NAME_5;
    }

    public String getCORRESPONDING_AUTHOR() {
        return CORRESPONDING_AUTHOR;
    }

    public void setCORRESPONDING_AUTHOR(String CORRESPONDING_AUTHOR) {
        this.CORRESPONDING_AUTHOR = CORRESPONDING_AUTHOR;
    }

    public int getPAPER_ID() {
        return PAPER_ID;
    }

    public void setPAPER_ID(int PAPER_ID) {
        this.PAPER_ID = PAPER_ID;
    }

    public String getCONFERENCE_NAME() {
        return CONFERENCE_NAME;
    }

    public void setCONFERENCE_NAME(String CONFERENCE_NAME) {
        this.CONFERENCE_NAME = CONFERENCE_NAME;
    }

    public String getPAPER_ABSTRACT_DEADLINE() {
        return PAPER_ABSTRACT_DEADLINE;
    }

    public void setPAPER_ABSTRACT_DEADLINE(String PAPER_ABSTRACT_DEADLINE) {
        this.PAPER_ABSTRACT_DEADLINE = PAPER_ABSTRACT_DEADLINE;
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

    public String getPAPER_ABSTRACT_TEXT() {
        return PAPER_ABSTRACT_TEXT;
    }

    public void setPAPER_ABSTRACT_TEXT(String PAPER_ABSTRACT_TEXT) {
        this.PAPER_ABSTRACT_TEXT = PAPER_ABSTRACT_TEXT;
    }

    public String getFULL_PAPER_OR_WORK_IN_PROGRESS() {
        return FULL_PAPER_OR_WORK_IN_PROGRESS;
    }

    public void setFULL_PAPER_OR_WORK_IN_PROGRESS(String FULL_PAPER_OR_WORK_IN_PROGRESS) {
        this.FULL_PAPER_OR_WORK_IN_PROGRESS = FULL_PAPER_OR_WORK_IN_PROGRESS;
    }

    public int getTYPE_OF_STUDY_ID() {
        return TYPE_OF_STUDY_ID;
    }

    public void setTYPE_OF_STUDY_ID(int TYPE_OF_STUDY_ID) {
        this.TYPE_OF_STUDY_ID = TYPE_OF_STUDY_ID;
    }

    public String getTYPE_OF_STUDY_NAME() {
        return TYPE_OF_STUDY_NAME;
    }

    public void setTYPE_OF_STUDY_NAME(String TYPE_OF_STUDY_NAME) {
        this.TYPE_OF_STUDY_NAME = TYPE_OF_STUDY_NAME;
    }

    public String getTYPE_OF_STUDY_NAME_EN() {
        return TYPE_OF_STUDY_NAME_EN;
    }

    public void setTYPE_OF_STUDY_NAME_EN(String TYPE_OF_STUDY_NAME_EN) {
        this.TYPE_OF_STUDY_NAME_EN = TYPE_OF_STUDY_NAME_EN;
    }

    public int getCONFERENCE_PRESENTATION_TYPE_ID() {
        return CONFERENCE_PRESENTATION_TYPE_ID;
    }

    public void setCONFERENCE_PRESENTATION_TYPE_ID(int CONFERENCE_PRESENTATION_TYPE_ID) {
        this.CONFERENCE_PRESENTATION_TYPE_ID = CONFERENCE_PRESENTATION_TYPE_ID;
    }

    public String getCONFERENCE_PRESENTATION_TYPE_NAME() {
        return CONFERENCE_PRESENTATION_TYPE_NAME;
    }

    public void setCONFERENCE_PRESENTATION_TYPE_NAME(String CONFERENCE_PRESENTATION_TYPE_NAME) {
        this.CONFERENCE_PRESENTATION_TYPE_NAME = CONFERENCE_PRESENTATION_TYPE_NAME;
    }

    public String getCONFERENCE_PRESENTATION_TYPE_NAME_EN() {
        return CONFERENCE_PRESENTATION_TYPE_NAME_EN;
    }

    public void setCONFERENCE_PRESENTATION_TYPE_NAME_EN(String CONFERENCE_PRESENTATION_TYPE_NAME_EN) {
        this.CONFERENCE_PRESENTATION_TYPE_NAME_EN = CONFERENCE_PRESENTATION_TYPE_NAME_EN;
    }

    public String getFIRST_SUBMITTED_DATE() {
        return FIRST_SUBMITTED_DATE;
    }

    public void setFIRST_SUBMITTED_DATE(String FIRST_SUBMITTED_DATE) {
        this.FIRST_SUBMITTED_DATE = FIRST_SUBMITTED_DATE;
    }

    public String getLAST_REVISED_DATE() {
        return LAST_REVISED_DATE;
    }

    public void setLAST_REVISED_DATE(String LAST_REVISED_DATE) {
        this.LAST_REVISED_DATE = LAST_REVISED_DATE;
    }

    public boolean isFINAL_APPROVAL_OR_REJECTION_OF_PAPER_ABSTRACT() {
        return FINAL_APPROVAL_OR_REJECTION_OF_PAPER_ABSTRACT;
    }

    public void setFINAL_APPROVAL_OR_REJECTION_OF_PAPER_ABSTRACT(boolean FINAL_APPROVAL_OR_REJECTION_OF_PAPER_ABSTRACT) {
        this.FINAL_APPROVAL_OR_REJECTION_OF_PAPER_ABSTRACT = FINAL_APPROVAL_OR_REJECTION_OF_PAPER_ABSTRACT;
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

    public String getPAPER_ABSTRACT_WITHDRAWN() {
        return PAPER_ABSTRACT_WITHDRAWN;
    }

    public void setPAPER_ABSTRACT_WITHDRAWN(String PAPER_ABSTRACT_WITHDRAWN) {
        this.PAPER_ABSTRACT_WITHDRAWN = PAPER_ABSTRACT_WITHDRAWN;
    }

    public int getPOSITION() {
        return POSITION;
    }

    public void setPOSITION(int POSITION) {
        this.POSITION = POSITION;
    }
}
