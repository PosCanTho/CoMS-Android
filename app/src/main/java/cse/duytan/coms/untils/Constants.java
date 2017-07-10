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
    /*End Config*/

    String MESSAGE = "message";
    String ERROR_CODE= "errorCode";
    String DATA= "data";

    int ID_MENU_POPUP = Utils.PROCESS++;

    /*Dialog*/
    int ID_DIALOG_CONFIRM_YES = Utils.PROCESS++;
    int ID_DIALOG_CONFIRM_CANCEL = Utils.PROCESS++;
    int ID_DIALOG_CONFIRM_OKE = Utils.PROCESS++;
}
