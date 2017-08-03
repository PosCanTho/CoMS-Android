package cse.duytan.coms.views;

import java.util.ArrayList;

import cse.duytan.coms.models.Conversation;
import cse.duytan.coms.models.Message;

/**
 * Created by Pham Van Thien on 7/7/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public interface MessageView {
    void onSuccess(ArrayList<Conversation> list);
    void error(String msg);
}
