package cse.duytan.coms.presenters;

import android.content.Context;

import java.util.ArrayList;

import cse.duytan.coms.connections.DownloadAsyncTask;
import cse.duytan.coms.models.PaperAbstract;
import cse.duytan.coms.views.ListAbstractView;

/**
 * Created by iMac on 8/21/17.
 */

public class ListAbstractPresenter extends BasePresenter {
    private Context context;
    private ListAbstractView listAbstractView;

    public ListAbstractPresenter(Context context, ListAbstractView listAbstractView){
        this.context = context;
        this.listAbstractView = listAbstractView;
    }
    public void getListAbstract(int paper_id){
        DownloadAsyncTask.POST(context, ID_API_LIST_ABSTRACT, API_LIST_ABSTRACT +"?paper_id="+paper_id,"", PaperAbstract.class, false, this);
    }

    @Override
    public void downloadSuccess(int processId, Object data) {
        super.downloadSuccess(processId, data);
        if(processId == ID_API_LIST_ABSTRACT){
            listAbstractView.listAbstract((ArrayList<PaperAbstract>) data);
        }
    }

    @Override
    public void downloadError(int processId, String msg) {
        super.downloadError(processId, msg);
        listAbstractView.error(msg);
    }
}
