package cse.duytan.coms.views;

import cse.duytan.coms.models.User;

/**
 * Created by Pham Van Thien on 8/17/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public interface MyProfileView {
    void getProfileSuccess(User user);
    void updateProfileSucess();
    void getProfileError(String msg);
    void updateProfileError(String msg);
}
