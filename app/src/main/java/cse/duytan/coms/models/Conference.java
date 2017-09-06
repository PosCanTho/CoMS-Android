package cse.duytan.coms.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by mac1 on 8/1/17.
 */

public class Conference implements Serializable {

    @SerializedName("CONFERENCE_ID")
    public int conferenceId;
    @SerializedName("CONFERENCE_NAME")
    public String conferenceName;
    @SerializedName("CONFERENCE_NAME_EN")
    public String conferenceNameEn;
    @SerializedName("CONFERENCE_TYPE_ID")
    public int conferenceTypeId;
    @SerializedName("CONFERENCE_TYPE_NAME")
    public String conferenceTypeName;
    @SerializedName("CONFERENCE_TYPE_NAME_EN")
    public String conferenceTypeNameEn;
    @SerializedName("FROM_DATE")
    public String fromDate;
    @SerializedName("THRU_DATE")
    public String thruDate;
    @SerializedName("ORGANIZING_ORGANIZATION_ID_1")
    public int organizingOrganizationId1;
    @SerializedName("ORGANIZING_ORGANIZATION_NAME_1")
    public String organizingOrganizationName1;
    @SerializedName("ORGANIZING_ORGANIZATION_NAME_EN_1")
    public String organizingOrganizationNameEn1;

    @SerializedName("ORGANIZING_ORGANIZATION_ID_2")
    public int organizingOrganizationId2;
    @SerializedName("ORGANIZING_ORGANIZATION_NAME_2")
    public String organizingOrganizationName2;
    @SerializedName("ORGANIZING_ORGANIZATION_NAME_EN_2")
    public String organizingOrganizationNameEn2;

    @SerializedName("ORGANIZING_ORGANIZATION_ID_3")
    public int organizingOrganizationId3;
    @SerializedName("ORGANIZING_ORGANIZATION_NAME_3")
    public String organizingOrganizationName3;
    @SerializedName("ORGANIZING_ORGANIZATION_NAME_EN_3")
    public String organizingOrganizationNameEn3;

    @SerializedName("ORGANIZING_ORGANIZATION_ID_4")
    public int organizingOrganizationId4;
    @SerializedName("ORGANIZING_ORGANIZATION_NAME_4")
    public String organizingOrganizationName4;
    @SerializedName("ORGANIZING_ORGANIZATION_NAME_EN_4")
    public String organizingOrganizationNameEn4;

    @SerializedName("ORGANIZING_ORGANIZATION_ID_5")
    public int organizingOrganizationId5;
    @SerializedName("ORGANIZING_ORGANIZATION_NAME_5")
    public String organizingOrganizationName5;
    @SerializedName("ORGANIZING_ORGANIZATION_NAME_EN_5")
    public String organizingOrganizationNameEn5;

    @SerializedName("ORGANIZING_ORGANIZATION_ID_6")
    public int organizingOrganizationId6;
    @SerializedName("ORGANIZING_ORGANIZATION_NAME_6")
    public String organizingOrganizationName6;
    @SerializedName("ORGANIZING_ORGANIZATION_NAME_EN_6")
    public String organizingOrganizationNameEn6;

    @SerializedName("ORGANIZING_ORGANIZATION_ID_7")
    public int organizingOrganizationId7;
    @SerializedName("ORGANIZING_ORGANIZATION_NAME_7")
    public String organizingOrganizationName7;
    @SerializedName("ORGANIZING_ORGANIZATION_NAME_EN_7")
    public String organizingOrganizationNameEn7;

    @SerializedName("ORGANIZING_ORGANIZATION_ID_8")
    public int organizingOrganizationId8;
    @SerializedName("ORGANIZING_ORGANIZATION_NAME_8")
    public String organizingOrganizationName8;
    @SerializedName("ORGANIZING_ORGANIZATION_NAME_EN_8")
    public String organizingOrganizationNameEn8;

    @SerializedName("ORGANIZING_ORGANIZATION_ID_9")
    public int organizingOrganizationId9;
    @SerializedName("ORGANIZING_ORGANIZATION_NAME_9")
    public String organizingOrganizationName9;
    @SerializedName("ORGANIZING_ORGANIZATION_NAME_EN_9")
    public String organizingOrganizationNameEn9;

    @SerializedName("ORGANIZING_ORGANIZATION_ID_10")
    public int organizingOrganizationId10;
    @SerializedName("ORGANIZING_ORGANIZATION_NAME_10")
    public String organizingOrganizationName10;
    @SerializedName("ORGANIZING_ORGANIZATION_NAME_EN_10")
    public String organizingOrganizationNameEn10;
    @SerializedName("MAIN_FIELD_OF_STUDY_ID")
    public int mainFieldOfStudyId;
    @SerializedName("MAIN_FIELD_OF_STUDY_NAME")
    public String mainFieldOfStudyName;
    @SerializedName("MAIN_FIELD_OF_STUDY_NAME_EN")
    public String mainFieldOfStudyNameEn;
    @SerializedName("CONFERENCE_MAIN_THEME")
    public String conferenceMainTheme;
    @SerializedName("CONFERENCE_MAIN_THEME_EN")
    public String conferenceMainThemeEn;
    @SerializedName("NUMBER_OF_PAPER_ABSTRACT_SUBMISSION_DEADLINES")
    public String numberOfPaperAbstractSubmissionDeadlines;
    @SerializedName("PAPER_ABSTRACT_DEADLINE_1")
    public String paperAbstractDeadline1;
    @SerializedName("PAPER_ABSTRACT_DEADLINE_2")
    public String paperAbstractDeadline2;
    @SerializedName("PAPER_ABSTRACT_DEADLINE_3")
    public String paperAbstractDeadline3;
    @SerializedName("PAPER_ABSTRACT_DEADLINE_4")
    public String paperAbstractDeadline4;
    @SerializedName("PAPER_ABSTRACT_DEADLINE_5")
    public String paperAbstractDeadline5;
    @SerializedName("WORD_COUNT_LIMIT_OF_PAPER_ABSTRACT")
    public String wordCountLimitOfPaperAbstract;
    @SerializedName("NUMBER_OF_PAPER_TEXT_SUBMISSION_DEADLINES")
    public String numberOfPaperTextSubmissionDeadlines;
    @SerializedName("PAPER_TEXT_DEADLINE_1")
    public String paperTextDeadline1;
    @SerializedName("PAPER_TEXT_DEADLINE_2")
    public String paperTextDeadline2;
    @SerializedName("PAPER_TEXT_DEADLINE_3")
    public String paperTextDeadline3;
    @SerializedName("PAPER_TEXT_DEADLINE_4")
    public String paperTextDeadline4;
    @SerializedName("PAPER_TEXT_DEADLINE_5")
    public String paperTextDeadline5;
    @SerializedName("LIMIT_NUMBER_OF_PAGES_OF_PAPER_TEXT")
    public String limitNumberOfPagesOfPaperText;
    @SerializedName("SUGGESTED_PAPER_ABSTRACT_REVIEW_RATING_SCALE")
    public int suggestedPaperAbstractReviewRatingScale;
    @SerializedName("SUGGESTED_PAPER_ABSTRACT_REVIEW_RATING_SCALE_STEP")
    public int suggestedPaperAbstractReviewRatingScaleStep;
    @SerializedName("SUGGESTED_PAPER_ABSTRACT_REVIEW_RATING_SCALE_START_POINT")
    public int suggestedPaperAbstractReviewRatingScaleStartPoint;
    @SerializedName("SUGGESTED_PAPER_ABSTRACT_REVIEW_RATING_SCALE_END_POINT")
    public int suggestedPaperAbstractReviewRatingScaleEndPoint;
    @SerializedName("SUGGESTED_PAPER_TEXT_REVIEW_RATING_SCALE")
    public int suggestedPaperTextReviewRatingScale;
    @SerializedName("SUGGESTED_PAPER_TEXT_REVIEW_RATING_SCALE_STEP")
    public int suggestedPaperTextReviewRatingScaleStep;
    @SerializedName("SUGGESTED_PAPER_TEXT_REVIEW_RATING_SCALE_START_POINT")
    public int suggestedPaperTextReviewRatingScaleStartPoint;
    @SerializedName("SUGGESTED_PAPER_TEXT_REVIEW_RATING_SCALE_END_POINT")
    public int suggestedPaperTextReviewRatingScaleEndPoint;

    public Conference() {
    }

    public Conference(int conferenceId, String conferenceName, String conferenceNameEn, int conferenceTypeId, String conferenceTypeName, String conferenceTypeNameEn, String fromDate, String thruDate, int organizingOrganizationId1, String organizingOrganizationName1, String organizingOrganizationNameEn1, int organizingOrganizationId2, String organizingOrganizationName2, String organizingOrganizationNameEn2, int organizingOrganizationId3, String organizingOrganizationName3, String organizingOrganizationNameEn3, int organizingOrganizationId4, String organizingOrganizationName4, String organizingOrganizationNameEn4, int organizingOrganizationId5, String organizingOrganizationName5, String organizingOrganizationNameEn5, int organizingOrganizationId6, String organizingOrganizationName6, String organizingOrganizationNameEn6, int organizingOrganizationId7, String organizingOrganizationName7, String organizingOrganizationNameEn7, int organizingOrganizationId8, String organizingOrganizationName8, String organizingOrganizationNameEn8, int organizingOrganizationId9, String organizingOrganizationName9, String organizingOrganizationNameEn9, int organizingOrganizationId10, String organizingOrganizationName10, String organizingOrganizationNameEn10, int mainFieldOfStudyId, String mainFieldOfStudyName, String mainFieldOfStudyNameEn, String conferenceMainTheme, String conferenceMainThemeEn, String numberOfPaperAbstractSubmissionDeadlines, String paperAbstractDeadline1, String paperAbstractDeadline2, String paperAbstractDeadline3, String paperAbstractDeadline4, String paperAbstractDeadline5, String wordCountLimitOfPaperAbstract, String numberOfPaperTextSubmissionDeadlines, String paperTextDeadline1, String paperTextDeadline2, String paperTextDeadline3, String paperTextDeadline4, String paperTextDeadline5, String limitNumberOfPagesOfPaperText, int suggestedPaperAbstractReviewRatingScale, int suggestedPaperAbstractReviewRatingScaleStep, int suggestedPaperAbstractReviewRatingScaleStartPoint, int suggestedPaperAbstractReviewRatingScaleEndPoint, int suggestedPaperTextReviewRatingScale, int suggestedPaperTextReviewRatingScaleStep, int suggestedPaperTextReviewRatingScaleStartPoint, int suggestedPaperTextReviewRatingScaleEndPoint) {
        this.conferenceId = conferenceId;
        this.conferenceName = conferenceName;
        this.conferenceNameEn = conferenceNameEn;
        this.conferenceTypeId = conferenceTypeId;
        this.conferenceTypeName = conferenceTypeName;
        this.conferenceTypeNameEn = conferenceTypeNameEn;
        this.fromDate = fromDate;
        this.thruDate = thruDate;
        this.organizingOrganizationId1 = organizingOrganizationId1;
        this.organizingOrganizationName1 = organizingOrganizationName1;
        this.organizingOrganizationNameEn1 = organizingOrganizationNameEn1;
        this.organizingOrganizationId2 = organizingOrganizationId2;
        this.organizingOrganizationName2 = organizingOrganizationName2;
        this.organizingOrganizationNameEn2 = organizingOrganizationNameEn2;
        this.organizingOrganizationId3 = organizingOrganizationId3;
        this.organizingOrganizationName3 = organizingOrganizationName3;
        this.organizingOrganizationNameEn3 = organizingOrganizationNameEn3;
        this.organizingOrganizationId4 = organizingOrganizationId4;
        this.organizingOrganizationName4 = organizingOrganizationName4;
        this.organizingOrganizationNameEn4 = organizingOrganizationNameEn4;
        this.organizingOrganizationId5 = organizingOrganizationId5;
        this.organizingOrganizationName5 = organizingOrganizationName5;
        this.organizingOrganizationNameEn5 = organizingOrganizationNameEn5;
        this.organizingOrganizationId6 = organizingOrganizationId6;
        this.organizingOrganizationName6 = organizingOrganizationName6;
        this.organizingOrganizationNameEn6 = organizingOrganizationNameEn6;
        this.organizingOrganizationId7 = organizingOrganizationId7;
        this.organizingOrganizationName7 = organizingOrganizationName7;
        this.organizingOrganizationNameEn7 = organizingOrganizationNameEn7;
        this.organizingOrganizationId8 = organizingOrganizationId8;
        this.organizingOrganizationName8 = organizingOrganizationName8;
        this.organizingOrganizationNameEn8 = organizingOrganizationNameEn8;
        this.organizingOrganizationId9 = organizingOrganizationId9;
        this.organizingOrganizationName9 = organizingOrganizationName9;
        this.organizingOrganizationNameEn9 = organizingOrganizationNameEn9;
        this.organizingOrganizationId10 = organizingOrganizationId10;
        this.organizingOrganizationName10 = organizingOrganizationName10;
        this.organizingOrganizationNameEn10 = organizingOrganizationNameEn10;
        this.mainFieldOfStudyId = mainFieldOfStudyId;
        this.mainFieldOfStudyName = mainFieldOfStudyName;
        this.mainFieldOfStudyNameEn = mainFieldOfStudyNameEn;
        this.conferenceMainTheme = conferenceMainTheme;
        this.conferenceMainThemeEn = conferenceMainThemeEn;
        this.numberOfPaperAbstractSubmissionDeadlines = numberOfPaperAbstractSubmissionDeadlines;
        this.paperAbstractDeadline1 = paperAbstractDeadline1;
        this.paperAbstractDeadline2 = paperAbstractDeadline2;
        this.paperAbstractDeadline3 = paperAbstractDeadline3;
        this.paperAbstractDeadline4 = paperAbstractDeadline4;
        this.paperAbstractDeadline5 = paperAbstractDeadline5;
        this.wordCountLimitOfPaperAbstract = wordCountLimitOfPaperAbstract;
        this.numberOfPaperTextSubmissionDeadlines = numberOfPaperTextSubmissionDeadlines;
        this.paperTextDeadline1 = paperTextDeadline1;
        this.paperTextDeadline2 = paperTextDeadline2;
        this.paperTextDeadline3 = paperTextDeadline3;
        this.paperTextDeadline4 = paperTextDeadline4;
        this.paperTextDeadline5 = paperTextDeadline5;
        this.limitNumberOfPagesOfPaperText = limitNumberOfPagesOfPaperText;
        this.suggestedPaperAbstractReviewRatingScale = suggestedPaperAbstractReviewRatingScale;
        this.suggestedPaperAbstractReviewRatingScaleStep = suggestedPaperAbstractReviewRatingScaleStep;
        this.suggestedPaperAbstractReviewRatingScaleStartPoint = suggestedPaperAbstractReviewRatingScaleStartPoint;
        this.suggestedPaperAbstractReviewRatingScaleEndPoint = suggestedPaperAbstractReviewRatingScaleEndPoint;
        this.suggestedPaperTextReviewRatingScale = suggestedPaperTextReviewRatingScale;
        this.suggestedPaperTextReviewRatingScaleStep = suggestedPaperTextReviewRatingScaleStep;
        this.suggestedPaperTextReviewRatingScaleStartPoint = suggestedPaperTextReviewRatingScaleStartPoint;
        this.suggestedPaperTextReviewRatingScaleEndPoint = suggestedPaperTextReviewRatingScaleEndPoint;
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

    public int getConferenceTypeId() {
        return conferenceTypeId;
    }

    public void setConferenceTypeId(int conferenceTypeId) {
        this.conferenceTypeId = conferenceTypeId;
    }

    public String getConferenceTypeName() {
        return conferenceTypeName;
    }

    public void setConferenceTypeName(String conferenceTypeName) {
        this.conferenceTypeName = conferenceTypeName;
    }

    public String getConferenceTypeNameEn() {
        return conferenceTypeNameEn;
    }

    public void setConferenceTypeNameEn(String conferenceTypeNameEn) {
        this.conferenceTypeNameEn = conferenceTypeNameEn;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getThruDate() {
        return thruDate;
    }

    public void setThruDate(String thruDate) {
        this.thruDate = thruDate;
    }

    public int getOrganizingOrganizationId1() {
        return organizingOrganizationId1;
    }

    public void setOrganizingOrganizationId1(int organizingOrganizationId1) {
        this.organizingOrganizationId1 = organizingOrganizationId1;
    }

    public String getOrganizingOrganizationName1() {
        return organizingOrganizationName1;
    }

    public void setOrganizingOrganizationName1(String organizingOrganizationName1) {
        this.organizingOrganizationName1 = organizingOrganizationName1;
    }

    public String getOrganizingOrganizationNameEn1() {
        return organizingOrganizationNameEn1;
    }

    public void setOrganizingOrganizationNameEn1(String organizingOrganizationNameEn1) {
        this.organizingOrganizationNameEn1 = organizingOrganizationNameEn1;
    }

    public int getOrganizingOrganizationId2() {
        return organizingOrganizationId2;
    }

    public void setOrganizingOrganizationId2(int organizingOrganizationId2) {
        this.organizingOrganizationId2 = organizingOrganizationId2;
    }

    public String getOrganizingOrganizationName2() {
        return organizingOrganizationName2;
    }

    public void setOrganizingOrganizationName2(String organizingOrganizationName2) {
        this.organizingOrganizationName2 = organizingOrganizationName2;
    }

    public String getOrganizingOrganizationNameEn2() {
        return organizingOrganizationNameEn2;
    }

    public void setOrganizingOrganizationNameEn2(String organizingOrganizationNameEn2) {
        this.organizingOrganizationNameEn2 = organizingOrganizationNameEn2;
    }

    public int getOrganizingOrganizationId3() {
        return organizingOrganizationId3;
    }

    public void setOrganizingOrganizationId3(int organizingOrganizationId3) {
        this.organizingOrganizationId3 = organizingOrganizationId3;
    }

    public String getOrganizingOrganizationName3() {
        return organizingOrganizationName3;
    }

    public void setOrganizingOrganizationName3(String organizingOrganizationName3) {
        this.organizingOrganizationName3 = organizingOrganizationName3;
    }

    public String getOrganizingOrganizationNameEn3() {
        return organizingOrganizationNameEn3;
    }

    public void setOrganizingOrganizationNameEn3(String organizingOrganizationNameEn3) {
        this.organizingOrganizationNameEn3 = organizingOrganizationNameEn3;
    }

    public int getOrganizingOrganizationId4() {
        return organizingOrganizationId4;
    }

    public void setOrganizingOrganizationId4(int organizingOrganizationId4) {
        this.organizingOrganizationId4 = organizingOrganizationId4;
    }

    public String getOrganizingOrganizationName4() {
        return organizingOrganizationName4;
    }

    public void setOrganizingOrganizationName4(String organizingOrganizationName4) {
        this.organizingOrganizationName4 = organizingOrganizationName4;
    }

    public String getOrganizingOrganizationNameEn4() {
        return organizingOrganizationNameEn4;
    }

    public void setOrganizingOrganizationNameEn4(String organizingOrganizationNameEn4) {
        this.organizingOrganizationNameEn4 = organizingOrganizationNameEn4;
    }

    public int getOrganizingOrganizationId5() {
        return organizingOrganizationId5;
    }

    public void setOrganizingOrganizationId5(int organizingOrganizationId5) {
        this.organizingOrganizationId5 = organizingOrganizationId5;
    }

    public String getOrganizingOrganizationName5() {
        return organizingOrganizationName5;
    }

    public void setOrganizingOrganizationName5(String organizingOrganizationName5) {
        this.organizingOrganizationName5 = organizingOrganizationName5;
    }

    public String getOrganizingOrganizationNameEn5() {
        return organizingOrganizationNameEn5;
    }

    public void setOrganizingOrganizationNameEn5(String organizingOrganizationNameEn5) {
        this.organizingOrganizationNameEn5 = organizingOrganizationNameEn5;
    }

    public int getOrganizingOrganizationId6() {
        return organizingOrganizationId6;
    }

    public void setOrganizingOrganizationId6(int organizingOrganizationId6) {
        this.organizingOrganizationId6 = organizingOrganizationId6;
    }

    public String getOrganizingOrganizationName6() {
        return organizingOrganizationName6;
    }

    public void setOrganizingOrganizationName6(String organizingOrganizationName6) {
        this.organizingOrganizationName6 = organizingOrganizationName6;
    }

    public String getOrganizingOrganizationNameEn6() {
        return organizingOrganizationNameEn6;
    }

    public void setOrganizingOrganizationNameEn6(String organizingOrganizationNameEn6) {
        this.organizingOrganizationNameEn6 = organizingOrganizationNameEn6;
    }

    public int getOrganizingOrganizationId7() {
        return organizingOrganizationId7;
    }

    public void setOrganizingOrganizationId7(int organizingOrganizationId7) {
        this.organizingOrganizationId7 = organizingOrganizationId7;
    }

    public String getOrganizingOrganizationName7() {
        return organizingOrganizationName7;
    }

    public void setOrganizingOrganizationName7(String organizingOrganizationName7) {
        this.organizingOrganizationName7 = organizingOrganizationName7;
    }

    public String getOrganizingOrganizationNameEn7() {
        return organizingOrganizationNameEn7;
    }

    public void setOrganizingOrganizationNameEn7(String organizingOrganizationNameEn7) {
        this.organizingOrganizationNameEn7 = organizingOrganizationNameEn7;
    }

    public int getOrganizingOrganizationId8() {
        return organizingOrganizationId8;
    }

    public void setOrganizingOrganizationId8(int organizingOrganizationId8) {
        this.organizingOrganizationId8 = organizingOrganizationId8;
    }

    public String getOrganizingOrganizationName8() {
        return organizingOrganizationName8;
    }

    public void setOrganizingOrganizationName8(String organizingOrganizationName8) {
        this.organizingOrganizationName8 = organizingOrganizationName8;
    }

    public String getOrganizingOrganizationNameEn8() {
        return organizingOrganizationNameEn8;
    }

    public void setOrganizingOrganizationNameEn8(String organizingOrganizationNameEn8) {
        this.organizingOrganizationNameEn8 = organizingOrganizationNameEn8;
    }

    public int getOrganizingOrganizationId9() {
        return organizingOrganizationId9;
    }

    public void setOrganizingOrganizationId9(int organizingOrganizationId9) {
        this.organizingOrganizationId9 = organizingOrganizationId9;
    }

    public String getOrganizingOrganizationName9() {
        return organizingOrganizationName9;
    }

    public void setOrganizingOrganizationName9(String organizingOrganizationName9) {
        this.organizingOrganizationName9 = organizingOrganizationName9;
    }

    public String getOrganizingOrganizationNameEn9() {
        return organizingOrganizationNameEn9;
    }

    public void setOrganizingOrganizationNameEn9(String organizingOrganizationNameEn9) {
        this.organizingOrganizationNameEn9 = organizingOrganizationNameEn9;
    }

    public int getOrganizingOrganizationId10() {
        return organizingOrganizationId10;
    }

    public void setOrganizingOrganizationId10(int organizingOrganizationId10) {
        this.organizingOrganizationId10 = organizingOrganizationId10;
    }

    public String getOrganizingOrganizationName10() {
        return organizingOrganizationName10;
    }

    public void setOrganizingOrganizationName10(String organizingOrganizationName10) {
        this.organizingOrganizationName10 = organizingOrganizationName10;
    }

    public String getOrganizingOrganizationNameEn10() {
        return organizingOrganizationNameEn10;
    }

    public void setOrganizingOrganizationNameEn10(String organizingOrganizationNameEn10) {
        this.organizingOrganizationNameEn10 = organizingOrganizationNameEn10;
    }

    public int getMainFieldOfStudyId() {
        return mainFieldOfStudyId;
    }

    public void setMainFieldOfStudyId(int mainFieldOfStudyId) {
        this.mainFieldOfStudyId = mainFieldOfStudyId;
    }

    public String getMainFieldOfStudyName() {
        return mainFieldOfStudyName;
    }

    public void setMainFieldOfStudyName(String mainFieldOfStudyName) {
        this.mainFieldOfStudyName = mainFieldOfStudyName;
    }

    public String getMainFieldOfStudyNameEn() {
        return mainFieldOfStudyNameEn;
    }

    public void setMainFieldOfStudyNameEn(String mainFieldOfStudyNameEn) {
        this.mainFieldOfStudyNameEn = mainFieldOfStudyNameEn;
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

    public String getNumberOfPaperAbstractSubmissionDeadlines() {
        return numberOfPaperAbstractSubmissionDeadlines;
    }

    public void setNumberOfPaperAbstractSubmissionDeadlines(String numberOfPaperAbstractSubmissionDeadlines) {
        this.numberOfPaperAbstractSubmissionDeadlines = numberOfPaperAbstractSubmissionDeadlines;
    }

    public String getPaperAbstractDeadline1() {
        return paperAbstractDeadline1;
    }

    public void setPaperAbstractDeadline1(String paperAbstractDeadline1) {
        this.paperAbstractDeadline1 = paperAbstractDeadline1;
    }

    public String getPaperAbstractDeadline2() {
        return paperAbstractDeadline2;
    }

    public void setPaperAbstractDeadline2(String paperAbstractDeadline2) {
        this.paperAbstractDeadline2 = paperAbstractDeadline2;
    }

    public String getPaperAbstractDeadline3() {
        return paperAbstractDeadline3;
    }

    public void setPaperAbstractDeadline3(String paperAbstractDeadline3) {
        this.paperAbstractDeadline3 = paperAbstractDeadline3;
    }

    public String getPaperAbstractDeadline4() {
        return paperAbstractDeadline4;
    }

    public void setPaperAbstractDeadline4(String paperAbstractDeadline4) {
        this.paperAbstractDeadline4 = paperAbstractDeadline4;
    }

    public String getPaperAbstractDeadline5() {
        return paperAbstractDeadline5;
    }

    public void setPaperAbstractDeadline5(String paperAbstractDeadline5) {
        this.paperAbstractDeadline5 = paperAbstractDeadline5;
    }

    public String getWordCountLimitOfPaperAbstract() {
        return wordCountLimitOfPaperAbstract;
    }

    public void setWordCountLimitOfPaperAbstract(String wordCountLimitOfPaperAbstract) {
        this.wordCountLimitOfPaperAbstract = wordCountLimitOfPaperAbstract;
    }

    public String getNumberOfPaperTextSubmissionDeadlines() {
        return numberOfPaperTextSubmissionDeadlines;
    }

    public void setNumberOfPaperTextSubmissionDeadlines(String numberOfPaperTextSubmissionDeadlines) {
        this.numberOfPaperTextSubmissionDeadlines = numberOfPaperTextSubmissionDeadlines;
    }

    public String getPaperTextDeadline1() {
        return paperTextDeadline1;
    }

    public void setPaperTextDeadline1(String paperTextDeadline1) {
        this.paperTextDeadline1 = paperTextDeadline1;
    }

    public String getPaperTextDeadline2() {
        return paperTextDeadline2;
    }

    public void setPaperTextDeadline2(String paperTextDeadline2) {
        this.paperTextDeadline2 = paperTextDeadline2;
    }

    public String getPaperTextDeadline3() {
        return paperTextDeadline3;
    }

    public void setPaperTextDeadline3(String paperTextDeadline3) {
        this.paperTextDeadline3 = paperTextDeadline3;
    }

    public String getPaperTextDeadline4() {
        return paperTextDeadline4;
    }

    public void setPaperTextDeadline4(String paperTextDeadline4) {
        this.paperTextDeadline4 = paperTextDeadline4;
    }

    public String getPaperTextDeadline5() {
        return paperTextDeadline5;
    }

    public void setPaperTextDeadline5(String paperTextDeadline5) {
        this.paperTextDeadline5 = paperTextDeadline5;
    }

    public String getLimitNumberOfPagesOfPaperText() {
        return limitNumberOfPagesOfPaperText;
    }

    public void setLimitNumberOfPagesOfPaperText(String limitNumberOfPagesOfPaperText) {
        this.limitNumberOfPagesOfPaperText = limitNumberOfPagesOfPaperText;
    }

    public int getSuggestedPaperAbstractReviewRatingScale() {
        return suggestedPaperAbstractReviewRatingScale;
    }

    public void setSuggestedPaperAbstractReviewRatingScale(int suggestedPaperAbstractReviewRatingScale) {
        this.suggestedPaperAbstractReviewRatingScale = suggestedPaperAbstractReviewRatingScale;
    }

    public int getSuggestedPaperAbstractReviewRatingScaleStep() {
        return suggestedPaperAbstractReviewRatingScaleStep;
    }

    public void setSuggestedPaperAbstractReviewRatingScaleStep(int suggestedPaperAbstractReviewRatingScaleStep) {
        this.suggestedPaperAbstractReviewRatingScaleStep = suggestedPaperAbstractReviewRatingScaleStep;
    }

    public int getSuggestedPaperAbstractReviewRatingScaleStartPoint() {
        return suggestedPaperAbstractReviewRatingScaleStartPoint;
    }

    public void setSuggestedPaperAbstractReviewRatingScaleStartPoint(int suggestedPaperAbstractReviewRatingScaleStartPoint) {
        this.suggestedPaperAbstractReviewRatingScaleStartPoint = suggestedPaperAbstractReviewRatingScaleStartPoint;
    }

    public int getSuggestedPaperAbstractReviewRatingScaleEndPoint() {
        return suggestedPaperAbstractReviewRatingScaleEndPoint;
    }

    public void setSuggestedPaperAbstractReviewRatingScaleEndPoint(int suggestedPaperAbstractReviewRatingScaleEndPoint) {
        this.suggestedPaperAbstractReviewRatingScaleEndPoint = suggestedPaperAbstractReviewRatingScaleEndPoint;
    }

    public int getSuggestedPaperTextReviewRatingScale() {
        return suggestedPaperTextReviewRatingScale;
    }

    public void setSuggestedPaperTextReviewRatingScale(int suggestedPaperTextReviewRatingScale) {
        this.suggestedPaperTextReviewRatingScale = suggestedPaperTextReviewRatingScale;
    }

    public int getSuggestedPaperTextReviewRatingScaleStep() {
        return suggestedPaperTextReviewRatingScaleStep;
    }

    public void setSuggestedPaperTextReviewRatingScaleStep(int suggestedPaperTextReviewRatingScaleStep) {
        this.suggestedPaperTextReviewRatingScaleStep = suggestedPaperTextReviewRatingScaleStep;
    }

    public int getSuggestedPaperTextReviewRatingScaleStartPoint() {
        return suggestedPaperTextReviewRatingScaleStartPoint;
    }

    public void setSuggestedPaperTextReviewRatingScaleStartPoint(int suggestedPaperTextReviewRatingScaleStartPoint) {
        this.suggestedPaperTextReviewRatingScaleStartPoint = suggestedPaperTextReviewRatingScaleStartPoint;
    }

    public int getSuggestedPaperTextReviewRatingScaleEndPoint() {
        return suggestedPaperTextReviewRatingScaleEndPoint;
    }

    public void setSuggestedPaperTextReviewRatingScaleEndPoint(int suggestedPaperTextReviewRatingScaleEndPoint) {
        this.suggestedPaperTextReviewRatingScaleEndPoint = suggestedPaperTextReviewRatingScaleEndPoint;
    }
}
