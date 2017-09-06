package cse.duytan.coms.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import cse.duytan.coms.untils.Constants;

/**
 * Created by iMac on 8/17/17.
 */

public class PresentationSlot implements Serializable, Constants {

    @SerializedName("PERSON_ID")
    public int PERSON_ID;

    @SerializedName("PAPER_ID")
    public int PAPER_ID;

    @SerializedName("CONFERENCE_ID")
    public int CONFERENCE_ID;

    @SerializedName("CONFERENCE_SESSION_ID")
    public int CONFERENCE_SESSION_ID;

    @SerializedName("PRESENTATION_SLOT_NUMBER")
    public int PRESENTATION_SLOT_NUMBER;

    @SerializedName("ACTUAL_PRESENTATION_SLOT_NUMBER")
    public int ACTUAL_PRESENTATION_SLOT_NUMBER;

    @SerializedName("ACTUAL_PRESENTATION_SLOT_START_DATETIME")
    public String ACTUAL_PRESENTATION_SLOT_START_DATETIME;

    @SerializedName("ACTUAL_PRESENTATION_SLOT_END_DATETIME")
    public String ACTUAL_PRESENTATION_SLOT_END_DATETIME;

    @SerializedName("ABSENT")
    public boolean ABSENT;

    @SerializedName("CURRENT_LAST_NAME")
    public String CURRENT_LAST_NAME;

    @SerializedName("CURRENT_FIRST_NAME")
    public String CURRENT_FIRST_NAME;

    @SerializedName("CURRENT_MIDDLE_NAME")
    public String CURRENT_MIDDLE_NAME;

    @SerializedName("PAPER_TEXT_TITLE_1")
    public String PAPER_TEXT_TITLE_1;

    @SerializedName("PAPER_TEXT_TITLE_EN_1")
    public String PAPER_TEXT_TITLE_EN_1;

    @SerializedName("PAPER_TEXT_TITLE_2")
    public String PAPER_TEXT_TITLE_2;

    @SerializedName("PAPER_TEXT_TITLE_EN_2")
    public String PAPER_TEXT_TITLE_EN_2;

    @SerializedName("PAPER_TEXT_TITLE_3")
    public String PAPER_TEXT_TITLE_3;

    @SerializedName("PAPER_TEXT_TITLE_EN_3")
    public String PAPER_TEXT_TITLE_EN_3;

    @SerializedName("PAPER_TEXT_TITLE_4")
    public String PAPER_TEXT_TITLE_4;

    @SerializedName("PAPER_TEXT_TITLE_EN_4")
    public String PAPER_TEXT_TITLE_EN_4;

    @SerializedName("PAPER_TEXT_TITLE_5")
    public String PAPER_TEXT_TITLE_5;

    @SerializedName("PAPER_TEXT_TITLE_EN_5")
    public String PAPER_TEXT_TITLE_EN_5;

    @SerializedName("PAPER_TEXT_WITHDRAWN")
    public boolean PAPER_TEXT_WITHDRAWN;

    @SerializedName("FINAL_APPROVAL_OR_REJECTION_OF_PAPER_TEXT")
    public boolean FINAL_APPROVAL_OR_REJECTION_OF_PAPER_TEXT;

    @SerializedName("FINAL_APPROVED_FULL_PAPER_OR_WORK_IN_PROGRESS")
    public String FINAL_APPROVED_FULL_PAPER_OR_WORK_IN_PROGRESS;

    @SerializedName("CONFERENCE_NAME")
    public String CONFERENCE_NAME;

    @SerializedName("CONFERENCE_NAME_EN")
    public String CONFERENCE_NAME_EN;

    @SerializedName("CONFERENCE_SESSION_NAME")
    public String CONFERENCE_SESSION_NAME;

    @SerializedName("CONFERENCE_SESSION_NAME_EN")
    public String CONFERENCE_SESSION_NAME_EN;

    @SerializedName("FACILITY_NAME_EN")
    public String FACILITY_NAME_EN;

    @SerializedName("FACILITY_NAME")
    public String FACILITY_NAME;


    public PresentationSlot() {
    }

    public PresentationSlot(int PERSON_ID, int PAPER_ID, int CONFERENCE_ID, int CONFERENCE_SESSION_ID, int PRESENTATION_SLOT_NUMBER, int ACTUAL_PRESENTATION_SLOT_NUMBER, String ACTUAL_PRESENTATION_SLOT_START_DATETIME, String ACTUAL_PRESENTATION_SLOT_END_DATETIME, boolean ABSENT, String CURRENT_LAST_NAME, String CURRENT_FIRST_NAME, String CURRENT_MIDDLE_NAME, String PAPER_TEXT_TITLE_1, String PAPER_TEXT_TITLE_EN_1, String PAPER_TEXT_TITLE_2, String PAPER_TEXT_TITLE_EN_2, String PAPER_TEXT_TITLE_3, String PAPER_TEXT_TITLE_EN_3, String PAPER_TEXT_TITLE_4, String PAPER_TEXT_TITLE_EN_4, String PAPER_TEXT_TITLE_5, String PAPER_TEXT_TITLE_EN_5, boolean PAPER_TEXT_WITHDRAWN, boolean FINAL_APPROVAL_OR_REJECTION_OF_PAPER_TEXT, String FINAL_APPROVED_FULL_PAPER_OR_WORK_IN_PROGRESS, String CONFERENCE_NAME, String CONFERENCE_NAME_EN, String CONFERENCE_SESSION_NAME, String CONFERENCE_SESSION_NAME_EN, String FACILITY_NAME, String FACILITY_NAME_EN) {
        this.PERSON_ID = PERSON_ID;
        this.PAPER_ID = PAPER_ID;
        this.CONFERENCE_ID = CONFERENCE_ID;
        this.CONFERENCE_SESSION_ID = CONFERENCE_SESSION_ID;
        this.PRESENTATION_SLOT_NUMBER = PRESENTATION_SLOT_NUMBER;
        this.ACTUAL_PRESENTATION_SLOT_NUMBER = ACTUAL_PRESENTATION_SLOT_NUMBER;
        this.ACTUAL_PRESENTATION_SLOT_START_DATETIME = ACTUAL_PRESENTATION_SLOT_START_DATETIME;
        this.ACTUAL_PRESENTATION_SLOT_END_DATETIME = ACTUAL_PRESENTATION_SLOT_END_DATETIME;
        this.ABSENT = ABSENT;
        this.CURRENT_LAST_NAME = CURRENT_LAST_NAME;
        this.CURRENT_FIRST_NAME = CURRENT_FIRST_NAME;
        this.CURRENT_MIDDLE_NAME = CURRENT_MIDDLE_NAME;
        this.PAPER_TEXT_TITLE_1 = PAPER_TEXT_TITLE_1;
        this.PAPER_TEXT_TITLE_EN_1 = PAPER_TEXT_TITLE_EN_1;
        this.PAPER_TEXT_TITLE_2 = PAPER_TEXT_TITLE_2;
        this.PAPER_TEXT_TITLE_EN_2 = PAPER_TEXT_TITLE_EN_2;
        this.PAPER_TEXT_TITLE_3 = PAPER_TEXT_TITLE_3;
        this.PAPER_TEXT_TITLE_EN_3 = PAPER_TEXT_TITLE_EN_3;
        this.PAPER_TEXT_TITLE_4 = PAPER_TEXT_TITLE_4;
        this.PAPER_TEXT_TITLE_EN_4 = PAPER_TEXT_TITLE_EN_4;
        this.PAPER_TEXT_TITLE_5 = PAPER_TEXT_TITLE_5;
        this.PAPER_TEXT_TITLE_EN_5 = PAPER_TEXT_TITLE_EN_5;
        this.PAPER_TEXT_WITHDRAWN = PAPER_TEXT_WITHDRAWN;
        this.FINAL_APPROVAL_OR_REJECTION_OF_PAPER_TEXT = FINAL_APPROVAL_OR_REJECTION_OF_PAPER_TEXT;
        this.FINAL_APPROVED_FULL_PAPER_OR_WORK_IN_PROGRESS = FINAL_APPROVED_FULL_PAPER_OR_WORK_IN_PROGRESS;
        this.CONFERENCE_NAME = CONFERENCE_NAME;
        this.CONFERENCE_NAME_EN = CONFERENCE_NAME_EN;
        this.CONFERENCE_SESSION_NAME = CONFERENCE_SESSION_NAME;
        this.CONFERENCE_SESSION_NAME_EN = CONFERENCE_SESSION_NAME_EN;
        this.FACILITY_NAME = FACILITY_NAME;
        this.FACILITY_NAME_EN = FACILITY_NAME_EN;
    }

    public int getPERSON_ID() {
        return PERSON_ID;
    }

    public void setPERSON_ID(int PERSON_ID) {
        this.PERSON_ID = PERSON_ID;
    }

    public int getPAPER_ID() {
        return PAPER_ID;
    }

    public void setPAPER_ID(int PAPER_ID) {
        this.PAPER_ID = PAPER_ID;
    }

    public int getCONFERENCE_ID() {
        return CONFERENCE_ID;
    }

    public void setCONFERENCE_ID(int CONFERENCE_ID) {
        this.CONFERENCE_ID = CONFERENCE_ID;
    }

    public int getCONFERENCE_SESSION_ID() {
        return CONFERENCE_SESSION_ID;
    }

    public void setCONFERENCE_SESSION_ID(int CONFERENCE_SESSION_ID) {
        this.CONFERENCE_SESSION_ID = CONFERENCE_SESSION_ID;
    }

    public int getPRESENTATION_SLOT_NUMBER() {
        return PRESENTATION_SLOT_NUMBER;
    }

    public void setPRESENTATION_SLOT_NUMBER(int PRESENTATION_SLOT_NUMBER) {
        this.PRESENTATION_SLOT_NUMBER = PRESENTATION_SLOT_NUMBER;
    }

    public int getACTUAL_PRESENTATION_SLOT_NUMBER() {
        return ACTUAL_PRESENTATION_SLOT_NUMBER;
    }

    public void setACTUAL_PRESENTATION_SLOT_NUMBER(int ACTUAL_PRESENTATION_SLOT_NUMBER) {
        this.ACTUAL_PRESENTATION_SLOT_NUMBER = ACTUAL_PRESENTATION_SLOT_NUMBER;
    }

    public String getACTUAL_PRESENTATION_SLOT_START_DATETIME() {
        return ACTUAL_PRESENTATION_SLOT_START_DATETIME;
    }

    public void setACTUAL_PRESENTATION_SLOT_START_DATETIME(String ACTUAL_PRESENTATION_SLOT_START_DATETIME) {
        this.ACTUAL_PRESENTATION_SLOT_START_DATETIME = ACTUAL_PRESENTATION_SLOT_START_DATETIME;
    }

    public String getACTUAL_PRESENTATION_SLOT_END_DATETIME() {
        return ACTUAL_PRESENTATION_SLOT_END_DATETIME;
    }

    public void setACTUAL_PRESENTATION_SLOT_END_DATETIME(String ACTUAL_PRESENTATION_SLOT_END_DATETIME) {
        this.ACTUAL_PRESENTATION_SLOT_END_DATETIME = ACTUAL_PRESENTATION_SLOT_END_DATETIME;
    }

    public boolean isABSENT() {
        return ABSENT;
    }

    public void setABSENT(boolean ABSENT) {
        this.ABSENT = ABSENT;
    }

    public String getCURRENT_LAST_NAME() {
        return CURRENT_LAST_NAME;
    }

    public void setCURRENT_LAST_NAME(String CURRENT_LAST_NAME) {
        this.CURRENT_LAST_NAME = CURRENT_LAST_NAME;
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

    public String getPAPER_TEXT_TITLE_1() {
        return PAPER_TEXT_TITLE_1;
    }

    public void setPAPER_TEXT_TITLE_1(String PAPER_TEXT_TITLE_1) {
        this.PAPER_TEXT_TITLE_1 = PAPER_TEXT_TITLE_1;
    }

    public String getPAPER_TEXT_TITLE_EN_1() {
        return PAPER_TEXT_TITLE_EN_1;
    }

    public void setPAPER_TEXT_TITLE_EN_1(String PAPER_TEXT_TITLE_EN_1) {
        this.PAPER_TEXT_TITLE_EN_1 = PAPER_TEXT_TITLE_EN_1;
    }

    public String getPAPER_TEXT_TITLE_2() {
        return PAPER_TEXT_TITLE_2;
    }

    public void setPAPER_TEXT_TITLE_2(String PAPER_TEXT_TITLE_2) {
        this.PAPER_TEXT_TITLE_2 = PAPER_TEXT_TITLE_2;
    }

    public String getPAPER_TEXT_TITLE_EN_2() {
        return PAPER_TEXT_TITLE_EN_2;
    }

    public void setPAPER_TEXT_TITLE_EN_2(String PAPER_TEXT_TITLE_EN_2) {
        this.PAPER_TEXT_TITLE_EN_2 = PAPER_TEXT_TITLE_EN_2;
    }

    public String getPAPER_TEXT_TITLE_3() {
        return PAPER_TEXT_TITLE_3;
    }

    public void setPAPER_TEXT_TITLE_3(String PAPER_TEXT_TITLE_3) {
        this.PAPER_TEXT_TITLE_3 = PAPER_TEXT_TITLE_3;
    }

    public String getPAPER_TEXT_TITLE_EN_3() {
        return PAPER_TEXT_TITLE_EN_3;
    }

    public void setPAPER_TEXT_TITLE_EN_3(String PAPER_TEXT_TITLE_EN_3) {
        this.PAPER_TEXT_TITLE_EN_3 = PAPER_TEXT_TITLE_EN_3;
    }

    public String getPAPER_TEXT_TITLE_4() {
        return PAPER_TEXT_TITLE_4;
    }

    public void setPAPER_TEXT_TITLE_4(String PAPER_TEXT_TITLE_4) {
        this.PAPER_TEXT_TITLE_4 = PAPER_TEXT_TITLE_4;
    }

    public String getPAPER_TEXT_TITLE_EN_4() {
        return PAPER_TEXT_TITLE_EN_4;
    }

    public void setPAPER_TEXT_TITLE_EN_4(String PAPER_TEXT_TITLE_EN_4) {
        this.PAPER_TEXT_TITLE_EN_4 = PAPER_TEXT_TITLE_EN_4;
    }

    public String getPAPER_TEXT_TITLE_5() {
        return PAPER_TEXT_TITLE_5;
    }

    public void setPAPER_TEXT_TITLE_5(String PAPER_TEXT_TITLE_5) {
        this.PAPER_TEXT_TITLE_5 = PAPER_TEXT_TITLE_5;
    }

    public String getPAPER_TEXT_TITLE_EN_5() {
        return PAPER_TEXT_TITLE_EN_5;
    }

    public void setPAPER_TEXT_TITLE_EN_5(String PAPER_TEXT_TITLE_EN_5) {
        this.PAPER_TEXT_TITLE_EN_5 = PAPER_TEXT_TITLE_EN_5;
    }

    public boolean isPAPER_TEXT_WITHDRAWN() {
        return PAPER_TEXT_WITHDRAWN;
    }

    public void setPAPER_TEXT_WITHDRAWN(boolean PAPER_TEXT_WITHDRAWN) {
        this.PAPER_TEXT_WITHDRAWN = PAPER_TEXT_WITHDRAWN;
    }

    public boolean isFINAL_APPROVAL_OR_REJECTION_OF_PAPER_TEXT() {
        return FINAL_APPROVAL_OR_REJECTION_OF_PAPER_TEXT;
    }

    public void setFINAL_APPROVAL_OR_REJECTION_OF_PAPER_TEXT(boolean FINAL_APPROVAL_OR_REJECTION_OF_PAPER_TEXT) {
        this.FINAL_APPROVAL_OR_REJECTION_OF_PAPER_TEXT = FINAL_APPROVAL_OR_REJECTION_OF_PAPER_TEXT;
    }

    public String getFINAL_APPROVED_FULL_PAPER_OR_WORK_IN_PROGRESS() {
        return FINAL_APPROVED_FULL_PAPER_OR_WORK_IN_PROGRESS;
    }

    public void setFINAL_APPROVED_FULL_PAPER_OR_WORK_IN_PROGRESS(String FINAL_APPROVED_FULL_PAPER_OR_WORK_IN_PROGRESS) {
        this.FINAL_APPROVED_FULL_PAPER_OR_WORK_IN_PROGRESS = FINAL_APPROVED_FULL_PAPER_OR_WORK_IN_PROGRESS;
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

    public String getCONFERENCE_SESSION_NAME() {
        return CONFERENCE_SESSION_NAME;
    }

    public void setCONFERENCE_SESSION_NAME(String CONFERENCE_SESSION_NAME) {
        this.CONFERENCE_SESSION_NAME = CONFERENCE_SESSION_NAME;
    }

    public String getCONFERENCE_SESSION_NAME_EN() {
        return CONFERENCE_SESSION_NAME_EN;
    }

    public void setCONFERENCE_SESSION_NAME_EN(String CONFERENCE_SESSION_NAME_EN) {
        this.CONFERENCE_SESSION_NAME_EN = CONFERENCE_SESSION_NAME_EN;
    }
    public String getCurrentFullName(){
        return getCURRENT_LAST_NAME() + " " + getCURRENT_MIDDLE_NAME() + " " + getCURRENT_FIRST_NAME();
    }

    public String getFACILITY_NAME() {
        return FACILITY_NAME;
    }

    public void setFACILITY_NAME(String FACILITY_NAME) {
        this.FACILITY_NAME = FACILITY_NAME;
    }

    public String getFACILITY_NAME_EN() {
        return FACILITY_NAME_EN;
    }
    public void setFACILITY_NAME_EN(String FACILITY_NAME_EN) {
        this.FACILITY_NAME_EN = FACILITY_NAME_EN;
    }

}
