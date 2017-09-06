package cse.duytan.coms.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by iMac on 8/9/17.
 */

public class Attendee {
    @SerializedName("PERSON_ID")
    public int personId;
    @SerializedName("CURRENT_LAST_NAME")
    public String currentLastName;
    @SerializedName("CURRENT_FIRST_NAME")
    public String currentFirstName;
    @SerializedName("CURRENT_MIDDLE_NAME")
    public String currentMiddleName;
    @SerializedName("CURRENT_PERSONAL_TITLE")
    public String currentPersonalTitle;
    @SerializedName("CURRENT_SUFFIX")
    public String currentSuffix;
    @SerializedName("CURRENT_HOME_ORGANIZATION_ID")
    public String currentHomeOrganizationId;
    @SerializedName("CURRENT_HOME_ORGANIZATION_NAME")
    public String currentHomeOrganizationName;
    @SerializedName("CURRENT_HOME_ORGANIZATION_NAME_EN")
    public String currentHomeOrganizationNameEn;
    @SerializedName("CONFERENCE_ID")
    public int conferenceId;
    @SerializedName("CONFERENCE_NAME")
    public String conferenceName;
    @SerializedName("CONFERENCE_NAME_EN")
    public String conferenceNameEn;
    @SerializedName("REGISTERED_CONFERENCE_REGISTRATION_PACKAGE_ID_1")
    public int registeredConferenceRegistrationPackageId_1;
    @SerializedName("REGISTERED_CONFERENCE_REGISTRATION_PACKAGE_ID_2")
    public int registeredConferenceRegistrationPackageId_2;
    @SerializedName("REGISTERED_CONFERENCE_REGISTRATION_PACKAGE_ID_3")
    public int registeredConferenceRegistrationPackageId_3;
    @SerializedName("REGISTERED_CONFERENCE_REGISTRATION_PACKAGE_ID_4")
    public int registeredConferenceRegistrationPackageId_4;
    @SerializedName("REGISTERED_CONFERENCE_REGISTRATION_PACKAGE_ID_5")
    public int registeredConferenceRegistrationPackageId_5;
    @SerializedName("REGISTERED_CONFERENCE_REGISTRATION_PACKAGE_ID_6")
    public int registeredConferenceRegistrationPackageId_6;
    @SerializedName("REGISTERED_CONFERENCE_REGISTRATION_PACKAGE_ID_7")
    public int registeredConferenceRegistrationPackageId_7;
    @SerializedName("REGISTERED_CONFERENCE_REGISTRATION_PACKAGE_ID_8")
    public int registeredConferenceRegistrationPackageId_8;
    @SerializedName("REGISTERED_CONFERENCE_REGISTRATION_PACKAGE_ID_9")
    public int registeredConferenceRegistrationPackageId_9;
    @SerializedName("REGISTERED_CONFERENCE_REGISTRATION_PACKAGE_ID_10")
    public int registeredConferenceRegistrationPackageId_10;
    @SerializedName("CONFERENCE_ADMIN_RIGHT")
    public boolean conferenceAdminRight;
    @SerializedName("REVIEWER_RIGHT")
    public boolean reviewerRight;
    @SerializedName("CONFERENCE_BOARD_OF_REVIEW_CHAIR_RIGHT")
    public boolean conferenceBoardOfReviewChairRight;
    @SerializedName("AUTHOR_RIGHT")
    public boolean authorRight;
    @SerializedName("PRESENTER_RIGHT")
    public boolean presenterRight;
    @SerializedName("CONFERENCE_ATTENDEE_RIGHT")
    public boolean conferenceAttendeeRight;
    @SerializedName("SUPPORT_STAFF_RIGHT")
    public boolean supportStaffRight;


    public Attendee() {
    }

    public Attendee(int personId, String currentLastName, String currentFirstName, String currentMiddleName, String currentPersonalTitle, String currentSuffix, String currentHomeOrganizationId, String currentHomeOrganizationName, String currentHomeOrganizationNameEn, int conferenceId, String conferenceName, String conferenceNameEn, int registeredConferenceRegistrationPackageId_1, int registeredConferenceRegistrationPackageId_2, int registeredConferenceRegistrationPackageId_3, int registeredConferenceRegistrationPackageId_4, int registeredConferenceRegistrationPackageId_5, int registeredConferenceRegistrationPackageId_6, int registeredConferenceRegistrationPackageId_7, int registeredConferenceRegistrationPackageId_8, int registeredConferenceRegistrationPackageId_9, int registeredConferenceRegistrationPackageId_10, boolean conferenceAdminRight, boolean reviewerRight, boolean conferenceBoardOfReviewChairRight, boolean authorRight, boolean presenterRight, boolean conferenceAttendeeRight, boolean supportStaffRight) {
        this.personId = personId;
        this.currentLastName = currentLastName;
        this.currentFirstName = currentFirstName;
        this.currentMiddleName = currentMiddleName;
        this.currentPersonalTitle = currentPersonalTitle;
        this.currentSuffix = currentSuffix;
        this.currentHomeOrganizationId = currentHomeOrganizationId;
        this.currentHomeOrganizationName = currentHomeOrganizationName;
        this.currentHomeOrganizationNameEn = currentHomeOrganizationNameEn;
        this.conferenceId = conferenceId;
        this.conferenceName = conferenceName;
        this.conferenceNameEn = conferenceNameEn;
        this.registeredConferenceRegistrationPackageId_1 = registeredConferenceRegistrationPackageId_1;
        this.registeredConferenceRegistrationPackageId_2 = registeredConferenceRegistrationPackageId_2;
        this.registeredConferenceRegistrationPackageId_3 = registeredConferenceRegistrationPackageId_3;
        this.registeredConferenceRegistrationPackageId_4 = registeredConferenceRegistrationPackageId_4;
        this.registeredConferenceRegistrationPackageId_5 = registeredConferenceRegistrationPackageId_5;
        this.registeredConferenceRegistrationPackageId_6 = registeredConferenceRegistrationPackageId_6;
        this.registeredConferenceRegistrationPackageId_7 = registeredConferenceRegistrationPackageId_7;
        this.registeredConferenceRegistrationPackageId_8 = registeredConferenceRegistrationPackageId_8;
        this.registeredConferenceRegistrationPackageId_9 = registeredConferenceRegistrationPackageId_9;
        this.registeredConferenceRegistrationPackageId_10 = registeredConferenceRegistrationPackageId_10;
        this.conferenceAdminRight = conferenceAdminRight;
        this.reviewerRight = reviewerRight;
        this.conferenceBoardOfReviewChairRight = conferenceBoardOfReviewChairRight;
        this.authorRight = authorRight;
        this.presenterRight = presenterRight;
        this.conferenceAttendeeRight = conferenceAttendeeRight;
        this.supportStaffRight = supportStaffRight;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getCurrentLastName() {
        return currentLastName;
    }

    public void setCurrentLastName(String currentLastName) {
        this.currentLastName = currentLastName;
    }

    public String getCurrentFirstName() {
        return currentFirstName;
    }

    public void setCurrentFirstName(String currentFirstName) {
        this.currentFirstName = currentFirstName;
    }

    public String getCurrentMiddleName() {
        return currentMiddleName;
    }

    public void setCurrentMiddleName(String currentMiddleName) {
        this.currentMiddleName = currentMiddleName;
    }

    public String getCurrentPersonalTitle() {
        return currentPersonalTitle;
    }

    public void setCurrentPersonalTitle(String currentPersonalTitle) {
        this.currentPersonalTitle = currentPersonalTitle;
    }

    public String getCurrentSuffix() {
        return currentSuffix;
    }

    public void setCurrentSuffix(String currentSuffix) {
        this.currentSuffix = currentSuffix;
    }

    public String getCurrentHomeOrganizationId() {
        return currentHomeOrganizationId;
    }

    public void setCurrentHomeOrganizationId(String currentHomeOrganizationId) {
        this.currentHomeOrganizationId = currentHomeOrganizationId;
    }

    public String getCurrentHomeOrganizationName() {
        return currentHomeOrganizationName;
    }

    public void setCurrentHomeOrganizationName(String currentHomeOrganizationName) {
        this.currentHomeOrganizationName = currentHomeOrganizationName;
    }

    public String getCurrentHomeOrganizationNameEn() {
        return currentHomeOrganizationNameEn;
    }

    public void setCurrentHomeOrganizationNameEn(String currentHomeOrganizationNameEn) {
        this.currentHomeOrganizationNameEn = currentHomeOrganizationNameEn;
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

    public int getRegisteredConferenceRegistrationPackageId_1() {
        return registeredConferenceRegistrationPackageId_1;
    }

    public void setRegisteredConferenceRegistrationPackageId_1(int registeredConferenceRegistrationPackageId_1) {
        this.registeredConferenceRegistrationPackageId_1 = registeredConferenceRegistrationPackageId_1;
    }

    public int getRegisteredConferenceRegistrationPackageId_2() {
        return registeredConferenceRegistrationPackageId_2;
    }

    public void setRegisteredConferenceRegistrationPackageId_2(int registeredConferenceRegistrationPackageId_2) {
        this.registeredConferenceRegistrationPackageId_2 = registeredConferenceRegistrationPackageId_2;
    }

    public int getRegisteredConferenceRegistrationPackageId_3() {
        return registeredConferenceRegistrationPackageId_3;
    }

    public void setRegisteredConferenceRegistrationPackageId_3(int registeredConferenceRegistrationPackageId_3) {
        this.registeredConferenceRegistrationPackageId_3 = registeredConferenceRegistrationPackageId_3;
    }

    public int getRegisteredConferenceRegistrationPackageId_4() {
        return registeredConferenceRegistrationPackageId_4;
    }

    public void setRegisteredConferenceRegistrationPackageId_4(int registeredConferenceRegistrationPackageId_4) {
        this.registeredConferenceRegistrationPackageId_4 = registeredConferenceRegistrationPackageId_4;
    }

    public int getRegisteredConferenceRegistrationPackageId_5() {
        return registeredConferenceRegistrationPackageId_5;
    }

    public void setRegisteredConferenceRegistrationPackageId_5(int registeredConferenceRegistrationPackageId_5) {
        this.registeredConferenceRegistrationPackageId_5 = registeredConferenceRegistrationPackageId_5;
    }

    public int getRegisteredConferenceRegistrationPackageId_6() {
        return registeredConferenceRegistrationPackageId_6;
    }

    public void setRegisteredConferenceRegistrationPackageId_6(int registeredConferenceRegistrationPackageId_6) {
        this.registeredConferenceRegistrationPackageId_6 = registeredConferenceRegistrationPackageId_6;
    }

    public int getRegisteredConferenceRegistrationPackageId_7() {
        return registeredConferenceRegistrationPackageId_7;
    }

    public void setRegisteredConferenceRegistrationPackageId_7(int registeredConferenceRegistrationPackageId_7) {
        this.registeredConferenceRegistrationPackageId_7 = registeredConferenceRegistrationPackageId_7;
    }

    public int getRegisteredConferenceRegistrationPackageId_8() {
        return registeredConferenceRegistrationPackageId_8;
    }

    public void setRegisteredConferenceRegistrationPackageId_8(int registeredConferenceRegistrationPackageId_8) {
        this.registeredConferenceRegistrationPackageId_8 = registeredConferenceRegistrationPackageId_8;
    }

    public int getRegisteredConferenceRegistrationPackageId_9() {
        return registeredConferenceRegistrationPackageId_9;
    }

    public void setRegisteredConferenceRegistrationPackageId_9(int registeredConferenceRegistrationPackageId_9) {
        this.registeredConferenceRegistrationPackageId_9 = registeredConferenceRegistrationPackageId_9;
    }

    public int getRegisteredConferenceRegistrationPackageId_10() {
        return registeredConferenceRegistrationPackageId_10;
    }

    public void setRegisteredConferenceRegistrationPackageId_10(int registeredConferenceRegistrationPackageId_10) {
        this.registeredConferenceRegistrationPackageId_10 = registeredConferenceRegistrationPackageId_10;
    }
    public String getCurrentFullName() {
        return currentLastName + currentMiddleName + currentFirstName;
    }

    public boolean isConferenceAdminRight() {
        return conferenceAdminRight;
    }

    public void setConferenceAdminRight(boolean conferenceAdminRight) {
        this.conferenceAdminRight = conferenceAdminRight;
    }

    public boolean isReviewerRight() {
        return reviewerRight;
    }

    public void setReviewerRifht(boolean reviewerRight) {
        this.reviewerRight = reviewerRight;
    }

    public boolean isConferenceBoardOfReviewChairRight() {
        return conferenceBoardOfReviewChairRight;
    }

    public void setConferenceBoardOfReviewChairRight(boolean conferenceBoardOfReviewChairRight) {
        this.conferenceBoardOfReviewChairRight = conferenceBoardOfReviewChairRight;
    }

    public boolean isAuthorRight() {
        return authorRight;
    }

    public void setAuthorRight(boolean authorRight) {
        this.authorRight = authorRight;
    }

    public boolean isPresenterRight() {
        return presenterRight;
    }

    public void setPresenterRight(boolean presenterRight) {
        this.presenterRight = presenterRight;
    }

    public boolean isConferenceAttendeeRight() {
        return conferenceAttendeeRight;
    }

    public void setConferenceAttendeeRight(boolean conferenceAttendeeRight) {
        this.conferenceAttendeeRight = conferenceAttendeeRight;
    }

    public boolean isSupportStaffRight() {
        return supportStaffRight;
    }

    public void setSupportStaffRight(boolean supportStaffRight) {
        this.supportStaffRight = supportStaffRight;
    }
}
