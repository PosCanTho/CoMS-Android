package cse.duytan.coms.views;

import cse.duytan.coms.models.Profile;

/**
 * Created by Pham Van Thien on 7/27/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public interface ProfileView {
    void success(Profile profile);
    void error(String msg);
    void invalidMenu();
}
