package cse.duytan.coms.presenters;

import android.content.Context;

import java.util.ArrayList;

import cse.duytan.coms.connections.DownloadAsyncTask;
import cse.duytan.coms.models.ConferenceMap;
import cse.duytan.coms.views.ListMapView;

/**
 * Created by Pham Van Thien on 8/26/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class ListMapPresenter extends BasePresenter {
    private Context context;
    private ListMapView mapView;

    public ListMapPresenter(Context context, ListMapView mapView) {
        this.context = context;
        this.mapView = mapView;
    }

    public void getListConfereceMap(int conferenceId) {
        DownloadAsyncTask.GET(context, ID_API_LIST_CONFERENCE_MAP, API_LIST_CONFERENCE_MAP + "?conferenceId=" + conferenceId, ConferenceMap.class, true, this);
    }

    @Override
    public void downloadSuccess(int processId, Object data) {
        super.downloadSuccess(processId, data);
        ArrayList<ConferenceMap> list = (ArrayList<ConferenceMap>)data;
        if(list.isEmpty()){
            mapView.empty();
        }else{
            mapView.success(list);
        }
    }

    @Override
    public void downloadError(int processId, String msg) {
        super.downloadError(processId, msg);
        mapView.error(msg);
    }

}
