package cse.duytan.coms.presenters;

import android.content.Context;

import java.util.ArrayList;

import cse.duytan.coms.connections.DownloadAsyncTask;
import cse.duytan.coms.models.Schedule;
import cse.duytan.coms.views.ScheduleView;

/**
 * Created by iMac on 8/31/17.
 */

public class SchedulePresenter extends BasePresenter {
    private Context context;
    private ScheduleView scheduleView;

    public SchedulePresenter(Context context, ScheduleView scheduleView){
        this.context = context;
        this.scheduleView = scheduleView;
    }
    public void getListSchedule(String username){
        DownloadAsyncTask.POST(context, ID_API_LIST_SCHEDULE, API_LIST_SCHEDULE +"?username="+username,"", Schedule.class, true, this);
    }

    @Override
    public void downloadSuccess(int processId, Object data) {
        super.downloadSuccess(processId, data);
        if(processId == ID_API_LIST_SCHEDULE){
            scheduleView.listSchedule((ArrayList<Schedule>) data);
        }
    }

    @Override
    public void downloadError(int processId, String msg) {
        super.downloadError(processId, msg);
        scheduleView.error(msg);
    }
}