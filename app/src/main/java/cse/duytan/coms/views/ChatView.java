package cse.duytan.coms.views;

import java.util.ArrayList;

import cse.duytan.coms.models.Message;

/**
 * Created by Pham Van Thien on 7/29/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public interface ChatView {
    void sendMessageSuccess(Message message);
    void listMessage(ArrayList<Message> listMessage);
    void error(String msg);
}
