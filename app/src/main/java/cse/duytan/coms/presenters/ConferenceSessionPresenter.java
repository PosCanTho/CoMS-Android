package cse.duytan.coms.presenters;

import android.content.Context;

import java.util.ArrayList;

import cse.duytan.coms.connections.DownloadAsyncTask;
import cse.duytan.coms.models.ConferenceSession;
import cse.duytan.coms.views.ConferenceSessionView;

/**
 * Created by iMac on 8/4/17.
 */

public class ConferenceSessionPresenter extends BasePresenter {
    private Context context;
    private ConferenceSessionView conferenceSessionView;

    public ConferenceSessionPresenter(Context context, ConferenceSessionView conferenceView){
        this.context = context;
        this.conferenceSessionView = conferenceView;
    }
    public void getListConferenceSession(int conference_id){
        DownloadAsyncTask.POST(context, ID_API_LIST_CONFERENCE_SESSION, API_LIST_CONFERENCE_SESSION +"?conference_id="+conference_id,"", ConferenceSession.class, false, this);
    }

    @Override
    public void downloadSuccess(int processId, Object data) {
        super.downloadSuccess(processId, data);
        if(processId == ID_API_LIST_CONFERENCE_SESSION){
            conferenceSessionView.listSession((ArrayList<ConferenceSession>) data);
        }
    }

    @Override
    public void downloadError(int processId, String msg) {
        super.downloadError(processId, msg);
        conferenceSessionView.error(msg);
    }
}
