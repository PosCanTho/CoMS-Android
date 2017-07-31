package cse.duytan.coms.views;

import java.util.ArrayList;

import cse.duytan.coms.models.Bookmark;

/**
 * Created by Pham Van Thien on 7/27/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public interface BookmarkView {
    void success(ArrayList<Bookmark> listBookmark);
    void error(String msg);
    void empty();
}
