package cse.duytan.coms.presenters;

import android.content.Context;

import java.util.ArrayList;

import cse.duytan.coms.connections.DownloadAsyncTask;
import cse.duytan.coms.models.Attendee;
import cse.duytan.coms.untils.Constants;
import cse.duytan.coms.views.ListAttendeeView;

/**
 * Created by iMac on 8/9/17.
 */

public class ListAttendeePresenter extends BasePresenter {
    private Context context;
    private ListAttendeeView listAttendeeView;

    public ListAttendeePresenter(Context context, ListAttendeeView listAttendeeView){
        this.context = context;
        this.listAttendeeView = listAttendeeView;
    }
    public void getListAttendee(int conference_id){
        DownloadAsyncTask.POST(context, Constants.ID_API_LIST_ATTENDEE, Constants.API_LIST_ATTENDEE +"?conference_id="+conference_id,"", Attendee.class, false, this);
    }

    @Override
    public void downloadSuccess(int processId, Object data) {
        super.downloadSuccess(processId, data);
        if(processId == ID_API_LIST_ATTENDEE){
            listAttendeeView.listAttendee((ArrayList<Attendee>) data);
        }
    }

    @Override
    public void downloadError(int processId, String msg) {
        super.downloadError(processId, msg);
        listAttendeeView.error(msg);
    }
}
