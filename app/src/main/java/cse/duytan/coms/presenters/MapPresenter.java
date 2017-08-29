package cse.duytan.coms.presenters;

import android.content.Context;
import android.telecom.Conference;

import java.util.ArrayList;

import cse.duytan.coms.connections.DownloadAsyncTask;
import cse.duytan.coms.models.ConferenceLocation;
import cse.duytan.coms.views.MapView;

/**
 * Created by Pham Van Thien on 8/28/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class MapPresenter extends BasePresenter {
    private Context context;
    private MapView mapView;

    public MapPresenter(Context context, MapView mapView) {
        this.context = context;
        this.mapView = mapView;
    }

    public void getListConferenceLocation(int conferenceMapId) {
        DownloadAsyncTask.GET(context, ID_API_LIST_CONFERENCE_LOCATION, API_LIST_CONFERENCE_LOCATION + "?conferenceMapId=" + conferenceMapId, ConferenceLocation.class, true, this);
    }

    @Override
    public void downloadSuccess(int processId, Object data) {
        super.downloadSuccess(processId, data);
        ArrayList<ConferenceLocation> listLocation = (ArrayList<ConferenceLocation>) data;
        if (listLocation.isEmpty()) {
            mapView.empty();
        } else {
            mapView.success(listLocation);
        }
    }

    @Override
    public void downloadError(int processId, String msg) {
        super.downloadError(processId, msg);
        mapView.error(msg);
    }
}
