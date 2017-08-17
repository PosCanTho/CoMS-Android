package cse.duytan.coms.presenters;

import android.content.Context;

import java.util.ArrayList;

import cse.duytan.coms.connections.DownloadAsyncTask;
import cse.duytan.coms.models.Conversation;
import cse.duytan.coms.models.Message;
import cse.duytan.coms.views.MessageView;

/**
 * Created by Pham Van Thien on 7/7/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class MessagePresenter extends BasePresenter {
    private Context context;
    private MessageView messageView;

    public MessagePresenter(Context context, MessageView messageView) {
        this.context = context;
        this.messageView = messageView;
    }

    public void getListConversation(int personId) {
        DownloadAsyncTask.GET(context, ID_API_LIST_CONVERSATION, API_LIST_CONVERSATION + "?personId=" + personId, Conversation.class, true, this);
    }

    @Override
    public void downloadSuccess(int processId, Object data) {
        super.downloadSuccess(processId, data);
        ArrayList<Conversation> list = (ArrayList<Conversation>)data;
        if(list.isEmpty()){
            messageView.empty();
        }else{
            messageView.onSuccess(list);
        }
    }

    @Override
    public void downloadError(int processId, String msg) {
        super.downloadError(processId, msg);
        messageView.error(msg);
    }
}
