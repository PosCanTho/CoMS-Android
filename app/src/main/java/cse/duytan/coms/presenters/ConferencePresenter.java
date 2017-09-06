package cse.duytan.coms.presenters;

import android.content.Context;

import java.util.ArrayList;

import cse.duytan.coms.connections.DownloadAsyncTask;
import cse.duytan.coms.models.Conference;
import cse.duytan.coms.views.ConferenceView;

/**
 * Created by iMac on 8/11/17.
 */

public class ConferencePresenter extends BasePresenter {
    private Context context;
    private ConferenceView conferenceView;

    public ConferencePresenter(Context context, ConferenceView conferenceView){
        this.context = context;
        this.conferenceView = conferenceView;
    }
    public void getListConference(int page, int pageSize){
        DownloadAsyncTask.POST(context, ID_API_LIST_CONFERENCE, API_LIST_CONFERENCE +"?page="+page+"&pageSize="+pageSize,"", Conference.class, false, this);
    }

    @Override
    public void downloadSuccess(int processId, Object data) {
        super.downloadSuccess(processId, data);
        if(processId == ID_API_LIST_CONFERENCE){
            conferenceView.listConference((ArrayList<Conference>) data);
        }
    }

    @Override
    public void downloadError(int processId, String msg) {
        super.downloadError(processId, msg);
        conferenceView.error(msg);
    }
}