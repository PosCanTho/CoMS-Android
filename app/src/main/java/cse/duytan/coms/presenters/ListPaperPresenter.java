package cse.duytan.coms.presenters;

import android.content.Context;

import java.util.ArrayList;

import cse.duytan.coms.activities.ListPaperActivity;
import cse.duytan.coms.connections.DownloadAsyncTask;
import cse.duytan.coms.models.PaperText;
import cse.duytan.coms.untils.Constants;
import cse.duytan.coms.views.ListPaperView;

/**
 * Created by iMac on 8/15/17.
 */

public class ListPaperPresenter extends BasePresenter {
    private Context context;
    private ListPaperView listPaperView;

    public ListPaperPresenter(Context context, ListPaperActivity listPaperView){
        this.context = context;
        this.listPaperView = listPaperView;
    }
    public void getListPaper(int conference_session_id){
        DownloadAsyncTask.POST(context, Constants.ID_API_LIST_PAPER, API_LIST_PAPER +"?conference_session_id="+conference_session_id,"", PaperText.class, false, this);
    }

    @Override
    public void downloadSuccess(int processId, Object data) {
        super.downloadSuccess(processId, data);
        if(processId == ID_API_LIST_PAPER){
            listPaperView.listPaper((ArrayList<PaperText>) data);
        }
    }

    @Override
    public void downloadError(int processId, String msg) {
        super.downloadError(processId, msg);
        listPaperView.error(msg);
    }
}
