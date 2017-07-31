package cse.duytan.coms.presenters;

import android.content.Context;

import java.util.ArrayList;

import cse.duytan.coms.connections.DownloadAsyncTask;
import cse.duytan.coms.models.Bookmark;
import cse.duytan.coms.views.BookmarkView;

/**
 * Created by Pham Van Thien on 7/27/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class BookmarkPresenter extends BasePresenter {
    private Context context;
    private BookmarkView bookmarkView;

    public BookmarkPresenter(Context context, BookmarkView bookmarkView) {
        this.context = context;
        this.bookmarkView = bookmarkView;
    }

    public void getListBookmark(int personId) {
        DownloadAsyncTask.GET(context, ID_API_LIS_BOOKMARK, API_LIS_BOOKMARK + "?personId=" + personId, Bookmark.class, true, this);
    }

    @Override
    public void downloadSuccess(int processId, Object data) {
        super.downloadSuccess(processId, data);
        ArrayList<Bookmark> listBookmark = (ArrayList<Bookmark>)data;
        if(listBookmark.isEmpty()){
            bookmarkView.empty();
        }else{
            bookmarkView.success(listBookmark);
        }
    }

    @Override
    public void downloadError(int processId, String msg) {
        super.downloadError(processId, msg);
        bookmarkView.error(msg);
    }
}
