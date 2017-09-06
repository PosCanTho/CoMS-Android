package cse.duytan.coms.presenters;

import android.content.Context;

import java.util.ArrayList;

import cse.duytan.coms.connections.DownloadAsyncTask;
import cse.duytan.coms.models.PresentationSlot;
import cse.duytan.coms.views.PresentationSlotView;

/**
 * Created by iMac on 8/17/17.
 */

public class PresentationSlotPresenter extends BasePresenter {
    private Context context;
    private PresentationSlotView presentationSlotView;

    public PresentationSlotPresenter(Context context, PresentationSlotView presentationSlotView){
        this.context = context;
        this.presentationSlotView = presentationSlotView;
    }
    public void getListPresentationSlot(int conference_session_id){
        DownloadAsyncTask.POST(context, ID_API_LIST_PRESENTATION_SLOT, API_LIST_PRESENTATION_SLOT +"?conference_session_id="+conference_session_id,"", PresentationSlot.class, false, this);
    }

    @Override
    public void downloadSuccess(int processId, Object data) {
        super.downloadSuccess(processId, data);
        if(processId == ID_API_LIST_PRESENTATION_SLOT){
            presentationSlotView.listPresentationSlot((ArrayList<PresentationSlot>) data);
        }
    }

    @Override
    public void downloadError(int processId, String msg) {
        super.downloadError(processId, msg);
        presentationSlotView.error(msg);
    }
}
