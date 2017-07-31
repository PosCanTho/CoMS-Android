package cse.duytan.coms.presenters;

import android.content.Context;

import java.util.ArrayList;

import cse.duytan.coms.connections.DownloadAsyncTask;
import cse.duytan.coms.models.Account;
import cse.duytan.coms.views.NewMessageView;

/**
 * Created by Pham Van Thien on 7/28/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class NewMessagaPresenter extends BasePresenter {
    private Context context;
    private NewMessageView newMessageView;

    public NewMessagaPresenter(Context context, NewMessageView newMessageView) {
        this.context = context;
        this.newMessageView = newMessageView;
    }

    public void getListAccount() {
        DownloadAsyncTask.GET(context, ID_API_GET_LIST_ACCOUNT, API_GET_LIST_ACCOUNT, Account.class, true, this);
    }

    @Override
    public void downloadSuccess(int processId, Object data) {
        super.downloadSuccess(processId, data);
        ArrayList<Account> listAccount = (ArrayList<Account>)data;
        if(listAccount.isEmpty()){
            newMessageView.empty();
        }else{
            newMessageView.success((ArrayList<Account>)data);
        }
    }

    @Override
    public void downloadError(int processId, String msg) {
        super.downloadError(processId, msg);
        newMessageView.error(msg);
    }
}
