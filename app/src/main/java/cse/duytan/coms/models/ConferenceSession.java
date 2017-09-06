package cse.duytan.coms.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by iMac on 8/4/17.
 */

public class ConferenceSession implements Serializable {
    @SerializedName("CONFERENCE_SESSION_ID")
    public int conferenceSessionId;
    @SerializedName("WALK_IN_OR_REGISTERED_SESSION")
    public String walkInOrRegisteredSession;
    @SerializedName("CONFERENCE_SESSION_TOPIC_ID")
    public int conferenceSessionTopicId;
    @SerializedName("CONFERENCE_SESSION_TOPIC_NAME")
    public String conferenceSessionTopicName;
    @SerializedName("CONFERENCE_SESSION_TOPIC_NAME_EN")
    public String conferenceSessionTopicNameEn;
    @SerializedName("CONFERENCE_SESSION_NAME")
    public String conferenceSessionName;
    @SerializedName("CONFERENCE_SESSION_NAME_EN")
    public String conferenceSessionNameEn;
    @SerializedName("CONFERENCE_ID")
    public int conferenceId;
    @SerializedName("CONFERENCE_NAME")
    public String conferenceName;
    @SerializedName("CONFERENCE_NAME_EN")
    public String conferenceNameEn;
    @SerializedName("START_DATETIME")
    public String startDatetime;
    @SerializedName("END_DATETIME")
    public String endDatetime;
    @SerializedName("FACILITY_ID")
    public int facilityId;
    @SerializedName("FACILITY_NAME")
    public String facilityName;
    @SerializedName("FACILITY_NAME_EN")
    public String facilityNameEn;
    @SerializedName("NUMBER_OF_PRESENTATION_SLOTS")
    public String numberOfPresentationSlots;
    @SerializedName("PRESENTATION_SLOT_1_START_DATETIME")
    public String presentationSlot1StartDatetime;
    @SerializedName("PRESENTATION_SLOT_1_END_DATETIME")
    public String presentationSlot1EndDatetime;
    @SerializedName("PRESENTATION_SLOT_2_START_DATETIME")
    public String presentationSlot2StartDatetime;
    @SerializedName("PRESENTATION_SLOT_2_END_DATETIME")
    public String presentationSlot2EndDatetime;

    @SerializedName("PRESENTATION_SLOT_3_START_DATETIME")
    public String presentationSlot3StartDatetime;
    @SerializedName("PRESENTATION_SLOT_3_END_DATETIME")
    public String presentationSlot3EndDatetime;
    @SerializedName("PRESENTATION_SLOT_4_START_DATETIME")
    public String presentationSlot4StartDatetime;
    @SerializedName("PRESENTATION_SLOT_4_END_DATETIME")
    public String presentationSlot4EndDatetime;

    @SerializedName("PRESENTATION_SLOT_5_START_DATETIME")
    public String presentationSlot5StartDatetime;
    @SerializedName("PRESENTATION_SLOT_5_END_DATETIME")
    public String presentationSlot5EndDatetime;
    @SerializedName("PRESENTATION_SLOT_6_START_DATETIME")
    public String presentationSlot6StartDatetime;
    @SerializedName("PRESENTATION_SLOT_6_END_DATETIME")
    public String presentationSlot6EndDatetime;

    @SerializedName("PRESENTATION_SLOT_7_START_DATETIME")
    public String presentationSlot7tartDatetime;
    @SerializedName("PRESENTATION_SLOT_7_END_DATETIME")
    public String presentationSlot7EndDatetime;
    @SerializedName("PRESENTATION_SLOT_8_START_DATETIME")
    public String presentationSlot8tartDatetime;
    @SerializedName("PRESENTATION_SLOT_8_END_DATETIME")
    public String presentationSlot8EndDatetime;

    @SerializedName("PRESENTATION_SLOT_9_START_DATETIME")
    public String presentationSlot9tartDatetime;
    @SerializedName("PRESENTATION_SLOT_9_END_DATETIME")
    public String presentationSlot9EndDatetime;
    @SerializedName("PRESENTATION_SLOT_10_START_DATETIME")
    public String presentationSlot10tartDatetime;
    @SerializedName("PRESENTATION_SLOT_10_END_DATETIME")
    public String presentationSlot10EndDatetime;

    @SerializedName("PRESENTATION_REVIEW_RATING_SCALE")
    public String presentationReviewRatingScale;
    @SerializedName("PRESENTATION_REVIEW_RATING_SCALE_STEP")
    public String presentationReviewRatingScaleStep;
    @SerializedName("PRESENTATION_REVIEW_RATING_SCALE_START_POINT")
    public String presentationReviewRatingScaleStartPoint;
    @SerializedName("PRESENTATION_REVIEW_RATING_SCALE_END_POINT")
    public String presentationReviewRatingScaleEndPoint;

    @SerializedName("DESCRIPTION")
    public String description;
    @SerializedName("DESCRIPTION_EN")
    public String descriptionEn;
    @SerializedName("CONFERENCE_MAIN_THEME")
    public String conferenceMainTheme;
    @SerializedName("CONFERENCE_MAIN_THEME_EN")
    public String conferenceMainThemeEn;

    @SerializedName("CURRENT_FIRST_NAME")
    public String currentFirstName;
    @SerializedName("CURRENT_MIDDLE_NAME")
    public String currentMiddleName;
    @SerializedName("CURRENT_LAST_NAME")
    public String currentLastName;
    @SerializedName("CURRENT_PERSONAL_TITLE")
    public String currentPersonalTitle;
    @SerializedName("CURRENT_SUFFIX")
    public String currentSuffix;



    public ConferenceSession() {
    }

    public ConferenceSession(int conferenceSessionId, String walkInOrRegisteredSession, int conferenceSessionTopicId, String conferenceSessionTopicName, String conferenceSessionTopicNameEn, String conferenceSessionName, String conferenceSessionNameEn, int conferenceId, String conferenceName, String conferenceNameEn, String startDatetime, String endDatetime, int facilityId, String facilityName, String facilityNameEn, String numberOfPresentationSlots, String presentationSlot1StartDatetime, String presentationSlot1EndDatetime, String presentationSlot2StartDatetime, String presentationSlot2EndDatetime, String presentationSlot3StartDatetime, String presentationSlot3EndDatetime, String presentationSlot4StartDatetime, String presentationSlot4EndDatetime, String presentationSlot5StartDatetime, String presentationSlot5EndDatetime, String presentationSlot6StartDatetime, String presentationSlot6EndDatetime, String presentationSlot7tartDatetime, String presentationSlot7EndDatetime, String presentationSlot8tartDatetime, String presentationSlot8EndDatetime, String presentationSlot9tartDatetime, String presentationSlot9EndDatetime, String presentationSlot10tartDatetime, String presentationSlot10EndDatetime, String presentationReviewRatingScale, String presentationReviewRatingScaleStep, String presentationReviewRatingScaleStartPoint, String presentationReviewRatingScaleEndPoint, String description, String descriptionEn, String conferenceMainTheme, String conferenceMainThemeEn, String currentLastName, String currentMiddleName, String currentFirstName, String currentPersonalTitle, String currentSuffix) {
        this.conferenceSessionId = conferenceSessionId;
        this.walkInOrRegisteredSession = walkInOrRegisteredSession;
        this.conferenceSessionTopicId = conferenceSessionTopicId;
        this.conferenceSessionTopicName = conferenceSessionTopicName;
        this.conferenceSessionTopicNameEn = conferenceSessionTopicNameEn;
        this.conferenceSessionName = conferenceSessionName;
        this.conferenceSessionNameEn = conferenceSessionNameEn;
        this.conferenceId = conferenceId;
        this.conferenceName = conferenceName;
        this.conferenceNameEn = conferenceNameEn;
        this.startDatetime = startDatetime;
        this.endDatetime = endDatetime;
        this.facilityId = facilityId;
        this.facilityName = facilityName;
        this.facilityNameEn = facilityNameEn;
        this.numberOfPresentationSlots = numberOfPresentationSlots;
        this.presentationSlot1StartDatetime = presentationSlot1StartDatetime;
        this.presentationSlot1EndDatetime = presentationSlot1EndDatetime;
        this.presentationSlot2StartDatetime = presentationSlot2StartDatetime;
        this.presentationSlot2EndDatetime = presentationSlot2EndDatetime;
        this.presentationSlot3StartDatetime = presentationSlot3StartDatetime;
        this.presentationSlot3EndDatetime = presentationSlot3EndDatetime;
        this.presentationSlot4StartDatetime = presentationSlot4StartDatetime;
        this.presentationSlot4EndDatetime = presentationSlot4EndDatetime;
        this.presentationSlot5StartDatetime = presentationSlot5StartDatetime;
        this.presentationSlot5EndDatetime = presentationSlot5EndDatetime;
        this.presentationSlot6StartDatetime = presentationSlot6StartDatetime;
        this.presentationSlot6EndDatetime = presentationSlot6EndDatetime;
        this.presentationSlot7tartDatetime = presentationSlot7tartDatetime;
        this.presentationSlot7EndDatetime = presentationSlot7EndDatetime;
        this.presentationSlot8tartDatetime = presentationSlot8tartDatetime;
        this.presentationSlot8EndDatetime = presentationSlot8EndDatetime;
        this.presentationSlot9tartDatetime = presentationSlot9tartDatetime;
        this.presentationSlot9EndDatetime = presentationSlot9EndDatetime;
        this.presentationSlot10tartDatetime = presentationSlot10tartDatetime;
        this.presentationSlot10EndDatetime = presentationSlot10EndDatetime;
        this.presentationReviewRatingScale = presentationReviewRatingScale;
        this.presentationReviewRatingScaleStep = presentationReviewRatingScaleStep;
        this.presentationReviewRatingScaleStartPoint = presentationReviewRatingScaleStartPoint;
        this.presentationReviewRatingScaleEndPoint = presentationReviewRatingScaleEndPoint;
        this.description = description;
        this.descriptionEn = descriptionEn;
        this.conferenceMainTheme = conferenceMainTheme;
        this.conferenceMainThemeEn = conferenceMainThemeEn;
        this.currentLastName = currentLastName;
        this.currentMiddleName = currentMiddleName;
        this.currentFirstName = currentFirstName;
        this.currentPersonalTitle = currentPersonalTitle;
        this.currentSuffix = currentSuffix;
    }

    public int getConferenceSessionId() {
        return conferenceSessionId;
    }

    public void setConferenceSessionId(int conferenceSessionId) {
        this.conferenceSessionId = conferenceSessionId;
    }

    public String getWalkInOrRegisteredSession() {
        return walkInOrRegisteredSession;
    }

    public void setWalkInOrRegisteredSession(String walkInOrRegisteredSession) {
        this.walkInOrRegisteredSession = walkInOrRegisteredSession;
    }

    public int getConferenceSessionTopicId() {
        return conferenceSessionTopicId;
    }

    public void setConferenceSessionTopicId(int conferenceSessionTopicId) {
        this.conferenceSessionTopicId = conferenceSessionTopicId;
    }

    public String getConferenceSessionTopicName() {
        return conferenceSessionTopicName;
    }

    public void setConferenceSessionTopicName(String conferenceSessionTopicName) {
        this.conferenceSessionTopicName = conferenceSessionTopicName;
    }

    public String getConferenceSessionTopicNameEn() {
        return conferenceSessionTopicNameEn;
    }

    public void setConferenceSessionTopicNameEn(String conferenceSessionTopicNameEn) {
        this.conferenceSessionTopicNameEn = conferenceSessionTopicNameEn;
    }

    public String getConferenceSessionName() {
        return conferenceSessionName;
    }

    public void setConferenceSessionName(String conferenceSessionName) {
        this.conferenceSessionName = conferenceSessionName;
    }

    public String getConferenceSessionNameEn() {
        return conferenceSessionNameEn;
    }

    public void setConferenceSessionNameEn(String conferenceSessionNameEn) {
        this.conferenceSessionNameEn = conferenceSessionNameEn;
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

    public String getConferenceNameEn() {
        return conferenceNameEn;
    }

    public void setConferenceNameEn(String conferenceNameEn) {
        this.conferenceNameEn = conferenceNameEn;
    }

    public String getStartDatetime() {
        return startDatetime;
    }

    public void setStartDatetime(String startDatetime) {
        this.startDatetime = startDatetime;
    }

    public String getEndDatetime() {
        return endDatetime;
    }

    public void setEndDatetime(String endDatetime) {
        this.endDatetime = endDatetime;
    }

    public int getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(int facilityId) {
        this.facilityId = facilityId;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getFacilityNameEn() {
        return facilityNameEn;
    }

    public void setFacilityNameEn(String facilityNameEn) {
        this.facilityNameEn = facilityNameEn;
    }

    public String getNumberOfPresentationSlots() {
        return numberOfPresentationSlots;
    }

    public void setNumberOfPresentationSlots(String numberOfPresentationSlots) {
        this.numberOfPresentationSlots = numberOfPresentationSlots;
    }

    public String getPresentationSlot1StartDatetime() {
        return presentationSlot1StartDatetime;
    }

    public void setPresentationSlot1StartDatetime(String presentationSlot1StartDatetime) {
        this.presentationSlot1StartDatetime = presentationSlot1StartDatetime;
    }

    public String getPresentationSlot1EndDatetime() {
        return presentationSlot1EndDatetime;
    }

    public void setPresentationSlot1EndDatetime(String presentationSlot1EndDatetime) {
        this.presentationSlot1EndDatetime = presentationSlot1EndDatetime;
    }

    public String getPresentationSlot2StartDatetime() {
        return presentationSlot2StartDatetime;
    }

    public void setPresentationSlot2StartDatetime(String presentationSlot2StartDatetime) {
        this.presentationSlot2StartDatetime = presentationSlot2StartDatetime;
    }

    public String getPresentationSlot2EndDatetime() {
        return presentationSlot2EndDatetime;
    }

    public void setPresentationSlot2EndDatetime(String presentationSlot2EndDatetime) {
        this.presentationSlot2EndDatetime = presentationSlot2EndDatetime;
    }

    public String getPresentationSlot3StartDatetime() {
        return presentationSlot3StartDatetime;
    }

    public void setPresentationSlot3StartDatetime(String presentationSlot3StartDatetime) {
        this.presentationSlot3StartDatetime = presentationSlot3StartDatetime;
    }

    public String getPresentationSlot3EndDatetime() {
        return presentationSlot3EndDatetime;
    }

    public void setPresentationSlot3EndDatetime(String presentationSlot3EndDatetime) {
        this.presentationSlot3EndDatetime = presentationSlot3EndDatetime;
    }

    public String getPresentationSlot4StartDatetime() {
        return presentationSlot4StartDatetime;
    }

    public void setPresentationSlot4StartDatetime(String presentationSlot4StartDatetime) {
        this.presentationSlot4StartDatetime = presentationSlot4StartDatetime;
    }

    public String getPresentationSlot4EndDatetime() {
        return presentationSlot4EndDatetime;
    }

    public void setPresentationSlot4EndDatetime(String presentationSlot4EndDatetime) {
        this.presentationSlot4EndDatetime = presentationSlot4EndDatetime;
    }

    public String getPresentationSlot5StartDatetime() {
        return presentationSlot5StartDatetime;
    }

    public void setPresentationSlot5StartDatetime(String presentationSlot5StartDatetime) {
        this.presentationSlot5StartDatetime = presentationSlot5StartDatetime;
    }

    public String getPresentationSlot5EndDatetime() {
        return presentationSlot5EndDatetime;
    }

    public void setPresentationSlot5EndDatetime(String presentationSlot5EndDatetime) {
        this.presentationSlot5EndDatetime = presentationSlot5EndDatetime;
    }

    public String getPresentationSlot6StartDatetime() {
        return presentationSlot6StartDatetime;
    }

    public void setPresentationSlot6StartDatetime(String presentationSlot6StartDatetime) {
        this.presentationSlot6StartDatetime = presentationSlot6StartDatetime;
    }

    public String getPresentationSlot6EndDatetime() {
        return presentationSlot6EndDatetime;
    }

    public void setPresentationSlot6EndDatetime(String presentationSlot6EndDatetime) {
        this.presentationSlot6EndDatetime = presentationSlot6EndDatetime;
    }

    public String getPresentationSlot7tartDatetime() {
        return presentationSlot7tartDatetime;
    }

    public void setPresentationSlot7tartDatetime(String presentationSlot7tartDatetime) {
        this.presentationSlot7tartDatetime = presentationSlot7tartDatetime;
    }

    public String getPresentationSlot7EndDatetime() {
        return presentationSlot7EndDatetime;
    }

    public void setPresentationSlot7EndDatetime(String presentationSlot7EndDatetime) {
        this.presentationSlot7EndDatetime = presentationSlot7EndDatetime;
    }

    public String getPresentationSlot8tartDatetime() {
        return presentationSlot8tartDatetime;
    }

    public void setPresentationSlot8tartDatetime(String presentationSlot8tartDatetime) {
        this.presentationSlot8tartDatetime = presentationSlot8tartDatetime;
    }

    public String getPresentationSlot8EndDatetime() {
        return presentationSlot8EndDatetime;
    }

    public void setPresentationSlot8EndDatetime(String presentationSlot8EndDatetime) {
        this.presentationSlot8EndDatetime = presentationSlot8EndDatetime;
    }

    public String getPresentationSlot9tartDatetime() {
        return presentationSlot9tartDatetime;
    }

    public void setPresentationSlot9tartDatetime(String presentationSlot9tartDatetime) {
        this.presentationSlot9tartDatetime = presentationSlot9tartDatetime;
    }

    public String getPresentationSlot9EndDatetime() {
        return presentationSlot9EndDatetime;
    }

    public void setPresentationSlot9EndDatetime(String presentationSlot9EndDatetime) {
        this.presentationSlot9EndDatetime = presentationSlot9EndDatetime;
    }

    public String getPresentationSlot10tartDatetime() {
        return presentationSlot10tartDatetime;
    }

    public void setPresentationSlot10tartDatetime(String presentationSlot10tartDatetime) {
        this.presentationSlot10tartDatetime = presentationSlot10tartDatetime;
    }

    public String getPresentationSlot10EndDatetime() {
        return presentationSlot10EndDatetime;
    }

    public void setPresentationSlot10EndDatetime(String presentationSlot10EndDatetime) {
        this.presentationSlot10EndDatetime = presentationSlot10EndDatetime;
    }

    public String getPresentationReviewRatingScale() {
        return presentationReviewRatingScale;
    }

    public void setPresentationReviewRatingScale(String presentationReviewRatingScale) {
        this.presentationReviewRatingScale = presentationReviewRatingScale;
    }

    public String getPresentationReviewRatingScaleStep() {
        return presentationReviewRatingScaleStep;
    }

    public void setPresentationReviewRatingScaleStep(String presentationReviewRatingScaleStep) {
        this.presentationReviewRatingScaleStep = presentationReviewRatingScaleStep;
    }

    public String getPresentationReviewRatingScaleStartPoint() {
        return presentationReviewRatingScaleStartPoint;
    }

    public void setPresentationReviewRatingScaleStartPoint(String presentationReviewRatingScaleStartPoint) {
        this.presentationReviewRatingScaleStartPoint = presentationReviewRatingScaleStartPoint;
    }

    public String getPresentationReviewRatingScaleEndPoint() {
        return presentationReviewRatingScaleEndPoint;
    }

    public void setPresentationReviewRatingScaleEndPoint(String presentationReviewRatingScaleEndPoint) {
        this.presentationReviewRatingScaleEndPoint = presentationReviewRatingScaleEndPoint;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionEn() {
        return descriptionEn;
    }

    public void setDescriptionEn(String descriptionEn) {
        this.descriptionEn = descriptionEn;
    }

    public String getConferenceMainTheme() {
        return conferenceMainTheme;
    }

    public void setConferenceMainTheme(String conferenceMainTheme) {
        this.conferenceMainTheme = conferenceMainTheme;
    }

    public String getConferenceMainThemeEn() {
        return conferenceMainThemeEn;
    }

    public void setConferenceMainThemeEn(String conferenceMainThemeEn) {
        this.conferenceMainThemeEn = conferenceMainThemeEn;
    }
    public String getCurrentFirstName(){ return currentFirstName;}
    public void setCurrentFirstName(String currentFirstName){
        this.currentFirstName = currentFirstName;
    }

    public String getCurrentMiddleName(){ return currentMiddleName;}
    public void setCurrentMiddleName(String currentMiddleName){
        this.currentMiddleName = currentMiddleName;
    }

    public String getCurrentLastName(){ return currentLastName;}
    public void setCurrentLastName(String currentLastName){
        this.currentLastName = currentLastName;
    }

    public String getCurrentPersonalTitle(){ return currentPersonalTitle;}
    public void setCurrentPersonalTitle(String currentPersonalTitle){
        this.currentPersonalTitle = currentPersonalTitle;
    }

    public String getCurrentSuffix(){ return currentSuffix;}
    public void setCurrentSuffix(String currentSuffix){
        this.currentSuffix = currentSuffix;
    }

    public String getCurrentFullName(){
        return currentLastName + " " + currentMiddleName + " " + currentFirstName;
    }
}
