package cse.duytan.coms.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by lehoangdung on 9/18/2017.
 */

public class PaperTextModel implements Serializable {

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
    @SerializedName("PAPER_TEXT_DEADLINE")
    public String PAPER_TEXT_DEADLINE;
    @SerializedName("PAPER_TEXT_TITLE")
    public String PAPER_TEXT_TITLE;
    @SerializedName("PAPER_TEXT_TITLE_EN")
    public String PAPER_TEXT_TITLE_EN;
    @SerializedName("CONFERENCE_SESSION_TOPIC_ID")
    public int CONFERENCE_SESSION_TOPIC_ID;
    @SerializedName("CONFERENCE_SESSION_TOPIC_NAME")
    public String CONFERENCE_SESSION_TOPIC_NAME;
    @SerializedName("CONFERENCE_SESSION_TOPIC_NAME_EN")
    public String CONFERENCE_SESSION_TOPIC_NAME_EN;
    @SerializedName("PAPER_TEXT")
    public String PAPER_TEXT;
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
    @SerializedName("FINAL_APPROVAL_OR_REJECTION_OF_PAPER_TEXT")
    public Boolean FINAL_APPROVAL_OR_REJECTION_OF_PAPER_TEXT;
    @SerializedName("FROM_DATE")
    public String FROM_DATE;
    @SerializedName("THRU_DATE")
    public String THRU_DATE;
    @SerializedName("PAPER_TEXT_WITHDRAWN")
    public Boolean PAPER_TEXT_WITHDRAWN;
    @SerializedName("POSITION")
    public int POSITION;

    public PaperTextModel() {
    }

    public PaperTextModel(int PERSON_ID, int CONFERENCE_ID, String ORGANIZATION_NAME_1, String ORGANIZATION_NAME_2,
                          String ORGANIZATION_NAME_3, String ORGANIZATION_NAME_4, String ORGANIZATION_NAME_5,
                          String CORRESPONDING_AUTHOR, int PAPER_ID, String CONFERENCE_NAME, String PAPER_TEXT_DEADLINE,
                          String PAPER_TEXT_TITLE, String PAPER_TEXT_TITLE_EN, int CONFERENCE_SESSION_TOPIC_ID,
                          String CONFERENCE_SESSION_TOPIC_NAME, String CONFERENCE_SESSION_TOPIC_NAME_EN,
                          String PAPER_TEXT, int TYPE_OF_STUDY_ID, String TYPE_OF_STUDY_NAME, String TYPE_OF_STUDY_NAME_EN,
                          int CONFERENCE_PRESENTATION_TYPE_ID, String CONFERENCE_PRESENTATION_TYPE_NAME,
                          String CONFERENCE_PRESENTATION_TYPE_NAME_EN, String FIRST_SUBMITTED_DATE, String LAST_REVISED_DATE,
                          Boolean FINAL_APPROVAL_OR_REJECTION_OF_PAPER_TEXT, String FROM_DATE, String THRU_DATE,
                          Boolean PAPER_TEXT_WITHDRAWN, int POSITION) {
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
        this.PAPER_TEXT_DEADLINE = PAPER_TEXT_DEADLINE;
        this.PAPER_TEXT_TITLE = PAPER_TEXT_TITLE;
        this.PAPER_TEXT_TITLE_EN = PAPER_TEXT_TITLE_EN;
        this.CONFERENCE_SESSION_TOPIC_ID = CONFERENCE_SESSION_TOPIC_ID;
        this.CONFERENCE_SESSION_TOPIC_NAME = CONFERENCE_SESSION_TOPIC_NAME;
        this.CONFERENCE_SESSION_TOPIC_NAME_EN = CONFERENCE_SESSION_TOPIC_NAME_EN;
        this.PAPER_TEXT = PAPER_TEXT;
        this.TYPE_OF_STUDY_ID = TYPE_OF_STUDY_ID;
        this.TYPE_OF_STUDY_NAME = TYPE_OF_STUDY_NAME;
        this.TYPE_OF_STUDY_NAME_EN = TYPE_OF_STUDY_NAME_EN;
        this.CONFERENCE_PRESENTATION_TYPE_ID = CONFERENCE_PRESENTATION_TYPE_ID;
        this.CONFERENCE_PRESENTATION_TYPE_NAME = CONFERENCE_PRESENTATION_TYPE_NAME;
        this.CONFERENCE_PRESENTATION_TYPE_NAME_EN = CONFERENCE_PRESENTATION_TYPE_NAME_EN;
        this.FIRST_SUBMITTED_DATE = FIRST_SUBMITTED_DATE;
        this.LAST_REVISED_DATE = LAST_REVISED_DATE;
        this.FINAL_APPROVAL_OR_REJECTION_OF_PAPER_TEXT = FINAL_APPROVAL_OR_REJECTION_OF_PAPER_TEXT;
        this.FROM_DATE = FROM_DATE;
        this.THRU_DATE = THRU_DATE;
        this.PAPER_TEXT_WITHDRAWN = PAPER_TEXT_WITHDRAWN;
        this.POSITION = POSITION;
    }

    public Boolean getFINAL_APPROVAL_OR_REJECTION_OF_PAPER_TEXT() {
        return FINAL_APPROVAL_OR_REJECTION_OF_PAPER_TEXT;
    }

    public void setFINAL_APPROVAL_OR_REJECTION_OF_PAPER_TEXT(Boolean FINAL_APPROVAL_OR_REJECTION_OF_PAPER_TEXT) {
        this.FINAL_APPROVAL_OR_REJECTION_OF_PAPER_TEXT = FINAL_APPROVAL_OR_REJECTION_OF_PAPER_TEXT;
    }

    public Boolean getPAPER_TEXT_WITHDRAWN() {
        return PAPER_TEXT_WITHDRAWN;
    }

    public void setPAPER_TEXT_WITHDRAWN(Boolean PAPER_TEXT_WITHDRAWN) {
        this.PAPER_TEXT_WITHDRAWN = PAPER_TEXT_WITHDRAWN;
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

    public String getPAPER_TEXT_DEADLINE() {
        return PAPER_TEXT_DEADLINE;
    }

    public void setPAPER_TEXT_DEADLINE(String PAPER_TEXT_DEADLINE) {
        this.PAPER_TEXT_DEADLINE = PAPER_TEXT_DEADLINE;
    }

    public String getPAPER_TEXT_TITLE() {
        return PAPER_TEXT_TITLE;
    }

    public void setPAPER_TEXT_TITLE(String PAPER_TEXT_TITLE) {
        this.PAPER_TEXT_TITLE = PAPER_TEXT_TITLE;
    }

    public String getPAPER_TEXT_TITLE_EN() {
        return PAPER_TEXT_TITLE_EN;
    }

    public void setPAPER_TEXT_TITLE_EN(String PAPER_TEXT_TITLE_EN) {
        this.PAPER_TEXT_TITLE_EN = PAPER_TEXT_TITLE_EN;
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

    public String getPAPER_TEXT() {
        return PAPER_TEXT;
    }

    public void setPAPER_TEXT(String PAPER_TEXT) {
        this.PAPER_TEXT = PAPER_TEXT;
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

    public boolean isFINAL_APPROVAL_OR_REJECTION_OF_PAPER_TEXT() {
        return FINAL_APPROVAL_OR_REJECTION_OF_PAPER_TEXT;
    }

    public void setFINAL_APPROVAL_OR_REJECTION_OF_PAPER_TEXT(boolean FINAL_APPROVAL_OR_REJECTION_OF_PAPER_TEXT) {
        this.FINAL_APPROVAL_OR_REJECTION_OF_PAPER_TEXT = FINAL_APPROVAL_OR_REJECTION_OF_PAPER_TEXT;
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



    public int getPOSITION() {
        return POSITION;
    }

    public void setPOSITION(int POSITION) {
        this.POSITION = POSITION;
    }
}
