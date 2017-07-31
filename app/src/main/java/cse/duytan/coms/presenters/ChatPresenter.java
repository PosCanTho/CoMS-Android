package cse.duytan.coms.presenters;

import android.content.Context;

import org.json.JSONObject;

import java.util.ArrayList;

import cse.duytan.coms.connections.DownloadAsyncTask;
import cse.duytan.coms.models.Message;
import cse.duytan.coms.views.ChatView;

/**
 * Created by Pham Van Thien on 7/29/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class ChatPresenter extends BasePresenter {
    private Context context;
    private ChatView chatView;

    public ChatPresenter(Context context, ChatView chatView) {
        this.context = context;
        this.chatView = chatView;
    }

    public void getListMessage(int personId) {
        DownloadAsyncTask.GET(context, ID_API_LIST_MESSAGE, API_LIST_MESSAGE, Message.class, false, this);
    }

    public void sendMessage(String msg, int personIdFrom, int personIdTo, String sound, String priority) {
        try {
            JSONObject postData = new JSONObject();
            postData.put("Body", msg);
            postData.put("Sound", sound);
            postData.put("Priority", priority);

            JSONObject data = new JSONObject();
            data.put("PersonIdFrom", personIdFrom);
            data.put("PersonIdTo", personIdTo);

            postData.put("data", data);
            DownloadAsyncTask.POST(context, ID_API_SEND_MESSAGE, API_SEND_MESSAGE, postData.toString(), null, true, this);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void downloadSuccess(int processId, Object data) {
        super.downloadSuccess(processId, data);
        if (processId == ID_API_LIST_MESSAGE) {
            chatView.listMessage((ArrayList<Message>) data);
        } else if (processId == ID_API_SEND_MESSAGE) {
            chatView.sendMessageSuccess((Message) data);
        }
    }

    @Override
    public void downloadError(int processId, String msg) {
        super.downloadError(processId, msg);
        chatView.error(msg);
    }
}
