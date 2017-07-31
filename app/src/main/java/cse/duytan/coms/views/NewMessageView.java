package cse.duytan.coms.views;

import java.util.ArrayList;

import cse.duytan.coms.models.Account;

/**
 * Created by Pham Van Thien on 7/28/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public interface NewMessageView {
    void success(ArrayList<Account> listAccount);
    void error(String msg);
    void empty();
}
