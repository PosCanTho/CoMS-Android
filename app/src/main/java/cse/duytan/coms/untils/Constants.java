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
    String URL_SERVER = "http://192.168.1.11:8888/api/";
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

}
