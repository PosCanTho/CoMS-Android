package cse.duytan.coms.untils;

/**
 * Created by Pham Van Thien on 6/15/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */
/*Giao diện dùng để chứa các biến dùng chung cho dự án*/
public interface Constants {

    /*Config*/
    boolean IS_DEBUG = true;
    String TAG = "OKE";
    String URL_SERVER = "http://192.168.1.15:8888/api/";
    /*End Config*/

    String MESSAGE = "message";
    String ERROR_CODE = "errorCode";
    String DATA = "data";

    int ID_MENU_POPUP = Utils.PROCESS++;

    /*Dialog*/
    int ID_DIALOG_CONFIRM_YES = Utils.PROCESS++;
    int ID_DIALOG_CONFIRM_CANCEL = Utils.PROCESS++;
    int ID_DIALOG_CONFIRM_OKE = Utils.PROCESS++;

    /*EventBus ID*/
    int ID_EVENT_REFRESH = Utils.PROCESS++;

    /*ID API*/
    int ID_API_LOGIN = Utils.PROCESS++;
    int ID_API_REGISTER = Utils.PROCESS++;
    int ID_API_LIS_BOOKMARK = Utils.PROCESS++;
    int ID_API_GET_PROFILE = Utils.PROCESS++;
    int ID_API_ADD_BOOKMARK = Utils.PROCESS++;
    int ID_API_DELETE_BOOKMARK = Utils.PROCESS++;
    int ID_API_GET_LIST_ACCOUNT = Utils.PROCESS++;
    int ID_API_SEND_MESSAGE = Utils.PROCESS++;
    int ID_API_LIST_MESSAGE = Utils.PROCESS++;
    int ID_API_DELETE_ALL_MESSAGE = Utils.PROCESS++;
    int ID_API_LIST_CONVERSATION = Utils.PROCESS++;
    int ID_API_LIST_PACKAGE = Utils.PROCESS++;
    int ID_API_GET_TOKEN = Utils.PROCESS++;
    int ID_API_GET_MY_PROFILE = Utils.PROCESS++;
    int ID_API_EDIT_PROFILE = Utils.PROCESS++;
    int ID_API_FORGOT_PASSWORD = Utils.PROCESS++;
    int ID_API_CHANGE_PASSWORD = Utils.PROCESS++;
    int ID_API_LIST_CONFERENCE_MAP = Utils.PROCESS++;
    int ID_API_LIST_CONFERENCE_LOCATION = Utils.PROCESS++;
    int ID_API_LIST_NOTIFICATION = Utils.PROCESS++;
    int ID_API_UPDATE_READED = Utils.PROCESS++;
    int ID_API_DELETE_NOTIFICATION = Utils.PROCESS++;
    int ID_API_ADD_TOKEN = Utils.PROCESS++;
    int ID_API_LIST_CONFERENCE = Utils.PROCESS++;
    int ID_API_LIST_CONFERENCE_SESSION = Utils.PROCESS++;
    int ID_API_LIST_PRESENTATION_SLOT = Utils.PROCESS++;
    int ID_API_LIST_ATTENDEE = Utils.PROCESS++;
    int ID_API_LIST_PAPER = Utils.PROCESS++;
    int ID_API_LIST_ABSTRACT = Utils.PROCESS++;
    int ID_API_ORGANIZATION = Utils.PROCESS++;
    int ID_API_LIST_SCHEDULE = Utils.PROCESS++;
    /* ID API of trứng cút */
    int ID_API_LISTABSTRACT = Utils.PROCESS++;
    int ID_API_WITHDRAWNABSTRACT = Utils.PROCESS++;
    int ID_API_SESSIONTOPIC = Utils.PROCESS++;
    int ID_API_TYPE_OF_STUDY = Utils.PROCESS++;
    int ID_API_PRESENTATION = Utils.PROCESS++;
    int ID_API_UPDATE_ABSTRACT = Utils.PROCESS++;
    int ID_API_SEE_ABSTRACT = Utils.PROCESS++;
    int ID_API_REGISTER_PAPERTEXT = Utils.PROCESS++;
    int ID_API_SEE_REVIEW = Utils.PROCESS++;
    int ID_API_BOARDOFREVIEW = Utils.PROCESS++;
    int ID_API_INFOMATION_REVIEWER = Utils.PROCESS++;
    int ID_API_LIST_REVIEW_ACCEP_ABSTRACT = Utils.PROCESS++;
    int ID_API_GETITEM_ABSTRACT_FORREVIEW = Utils.PROCESS++;
    int ID_API_LIST_REVIEW_REJECT_ABSTRACT = Utils.PROCESS++;
    int ID_API_LIST_REVIEW_PENDING_ABSTRACT = Utils.PROCESS++;
    int ID_API_RATINGSCALE = Utils.PROCESS++;
    int ID_API_REVIEW_ABSTRACT = Utils.PROCESS++;
    int ID_API_UPDATE_REVIEW_ABSTRACT = Utils.PROCESS++;
    int ID_API_LIST_PAPERTEXT = Utils.PROCESS++;
    int ID_API_WITHDRAWN_PAPERTEXT = Utils.PROCESS++;
    int ID_API_UPDATE_PAPERTEXT = Utils.PROCESS++;
    int ID_API_SEE_ITEM_PAPERTEXT = Utils.PROCESS++;
    /*end*/


    /*URL STRING*/
    String API_LOGIN = URL_SERVER + "Login";
    String API_REGISTER = URL_SERVER + "Register";
    String API_LIS_BOOKMARK = URL_SERVER + "ListBookmark";
    String API_GET_PROFILE = URL_SERVER + "GetProfile";
    String API_ADD_BOOKMARK = URL_SERVER + "AddBookmark";
    String API_DELETE_BOOKMARK = URL_SERVER + "DeleteBookmark";
    String API_GET_LIST_ACCOUNT = URL_SERVER + "ListAccount";
    String API_SEND_MESSAGE = URL_SERVER + "SendMessage";
    String API_LIST_MESSAGE = URL_SERVER + "ListMessage";
    String API_DELETE_ALL_MESSAGE = URL_SERVER + "DeleteAllMessage";
    String API_LIST_CONVERSATION = URL_SERVER + "ListConversation";
    String API_LIST_PACKAGE = URL_SERVER + "ListPackage";
    String API_GET_TOKEN = URL_SERVER + "token";
    String API_GET_MY_PROFILE = URL_SERVER + "MyProfile";
    String API_EDIT_PROFILE = URL_SERVER + "EditProfile";
    String API_FORGOT_PASSWORD = URL_SERVER + "ForgotPassword";
    String API_CHANGE_PASSWORD = URL_SERVER + "ChangePassword";
    String API_LIST_CONFERENCE_MAP = URL_SERVER + "ListConferenceMap";
    String API_LIST_CONFERENCE_LOCATION = URL_SERVER + "ListConferenceLocation";
    String API_LIST_NOTIFICATION = URL_SERVER + "ListNotification";
    String API_UPDATE_READED = URL_SERVER + "UpdateReaded";
    String API_DELETE_NOTIFICATION = URL_SERVER + "DeleteNotification";
    String API_ADD_TOKEN = URL_SERVER + "AddDevice";
    String API_LIST_CONFERENCE = URL_SERVER + "ListConference";
    String API_LIST_CONFERENCE_SESSION = URL_SERVER + "ListConferenceSession";
    String API_LIST_PRESENTATION_SLOT = URL_SERVER + "ListConferenceSessionPaperPresentationSlot";
    String API_LIST_ATTENDEE = URL_SERVER + "ListAttendee";
    String API_LIST_PAPER = URL_SERVER + "ListPaperText";
    String API_LIST_ABSTRACT = URL_SERVER + "ListPaperAbastract";
    String API_ORGANIZATION = URL_SERVER + "ListOrganization";
    String API_LIST_SCHEDULE = URL_SERVER + "ListSchedule";
    /*DŨNG*/
    String API_LISTABSTRACT = URL_SERVER + "ListPaperAbstract";
    String API_WITHDRAWNABSTRACT = URL_SERVER + "WithDrawnAbstract";
    String API_SESSIONTOPIC = URL_SERVER + "Session_topic";
    String API_TYPE_OF_STUDY = URL_SERVER + "Type_of_study";
    String API_PRESENTATION = URL_SERVER + "Conference_presentation_type";
    String API_UPDATE_ABSTRACT = URL_SERVER + "UpdateAbstract";
    String API_SEE_ABSTRACT = URL_SERVER + "SeeAbstract";
    String API_REGISTER_PAPERTEXT = URL_SERVER + "RegisterPaperText";
    String API_SEE_REVIEW = URL_SERVER + "Review/SeeReviewPaperAbstract";
    String API_BOARDOFREVIEW = URL_SERVER + "Review/PaperAbstractRatingScale_BoardOfReview";
    String API_INFOMATION_REVIEWER = URL_SERVER + "Review/InfomationReview";
    String API_GETITEM_ABSTRACT_FORREVIEW = URL_SERVER + "getItemAbstractforReview";
    String API_LIST_REVIEW_ACCEP_ABSTRACT = URL_SERVER + "Review/ListAbstractApproved";//ĐỒNG Ý
    String API_LIST_REVIEW_REJECT_ABSTRACT = URL_SERVER + "Review/ListAbstractReject";//TỪ CHỐI
    String API_LIST_REVIEW_PENDING_ABSTRACT = URL_SERVER + "Review/ListAbstractPebding";// chờ duyệt
    String API_RATINGSCALE = URL_SERVER + "Review/PaperAbstractRatingScale_BoardOfReview";
    String API_REVIEW_ABSTRACT = URL_SERVER + "Review/ReviewPaperAbstract";
    String API_UPDATE_REVIEW_ABSTRACT = URL_SERVER + "Review/UpdateReviewPaperAbstract";
    String API_LIST_PAPERTEXT = URL_SERVER + "List_PaperText";
    String API_WITHDRAWN_PAPERTEXT = URL_SERVER + "WithDrawnPaperText";
    String API_UPDATE_PAPERTEXT = URL_SERVER + "Update_PaperText";
    String API_SEE_ITEM_PAPERTEXT = URL_SERVER + "See_PaperText";
    //END

    /*DATABASE*/
    String DATABASE_NAME = "DB_COMS";
    int DATABASE_VERSION = 1;

    /*Presentation Slot*/
    String TABLE_PRESENTATION_SLOT = "WR_PRESENTATION_SLOT";
    String PERSON_ID = "PERSON_ID";
    String PAPER_ID = "PAPER_ID";
    String CONFERENCE_ID = "CONFERENCE_ID";
    String CONFERENCE_SESSION_ID = "CONFERENCE_SESSION_ID";
    String PRESENTATION_SLOT_NUMBER = "PRESENTATION_SLOT_NUMBER";
    String ACTUAL_PRESENTATION_SLOT_NUMBER = "ACTUAL_PRESENTATION_SLOT_NUMBER";
    String ACTUAL_PRESENTATION_SLOT_START_DATETIME = "ACTUAL_PRESENTATION_SLOT_START_DATETIME";
    String ACTUAL_PRESENTATION_SLOT_END_DATETIME = "ACTUAL_PRESENTATION_SLOT_END_DATETIME";
    String ABSENT = "ABSENT";
    String CURRENT_LAST_NAME = "CURRENT_LAST_NAME";
    String CURRENT_FIRST_NAME = "CURRENT_FIRST_NAME";
    String CURRENT_MIDDLE_NAME = "CURRENT_MIDDLE_NAME";
    String PAPER_TEXT_TITLE_1 = "PAPER_TEXT_TITLE_1";
    String PAPER_TEXT_TITLE_EN_1 = "PAPER_TEXT_TITLE_EN_1";
    String PAPER_TEXT_TITLE_2 = "PAPER_TEXT_TITLE_2";
    String PAPER_TEXT_TITLE_EN_2 = "PAPER_TEXT_TITLE_EN_2";
    String PAPER_TEXT_TITLE_3 = "PAPER_TEXT_TITLE_3";
    String PAPER_TEXT_TITLE_EN_3 = "PAPER_TEXT_TITLE_EN_3";
    String PAPER_TEXT_TITLE_4 = "PAPER_TEXT_TITLE_4";
    String PAPER_TEXT_TITLE_EN_4 = "PAPER_TEXT_TITLE_EN_4";
    String PAPER_TEXT_TITLE_5 = "PAPER_TEXT_TITLE_5";
    String PAPER_TEXT_TITLE_EN_5 = "PAPER_TEXT_TITLE_EN_5";
    String PAPER_TEXT_WITHDRAWN = "PAPER_TEXT_WITHDRAWN";
    String FINAL_APPROVAL_OR_REJECTION_OF_PAPER_TEXT = "FINAL_APPROVAL_OR_REJECTION_OF_PAPER_TEXT";
    String FINAL_APPROVED_FULL_PAPER_OR_WORK_IN_PROGRESS = "FINAL_APPROVED_FULL_PAPER_OR_WORK_IN_PROGRESS";
    String CONFERENCE_NAME = "CONFERENCE_NAME";
    String CONFERENCE_NAME_EN = "CONFERENCE_NAME_EN";
    String CONFERENCE_SESSION_NAME = "CONFERENCE_SESSION_NAME";
    String CONFERENCE_SESSION_NAME_EN = "CONFERENCE_SESSION_NAME_EN";
    String FACILITY_NAME = "FACILITY_NAME";
    String FACILITY_NAME_EN = "FACILITY_NAME_EN";

}
