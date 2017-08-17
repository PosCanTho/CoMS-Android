package cse.duytan.coms.presenters;

import android.content.Context;

import java.util.ArrayList;

import cse.duytan.coms.connections.DownloadAsyncTask;
import cse.duytan.coms.connections.DownloadCallback;
import cse.duytan.coms.models.Package;
import cse.duytan.coms.views.PackageView;

/**
 * Created by Pham Van Thien on 8/15/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class PackagePresenter extends BasePresenter {
    private Context context;
    private PackageView packageView;

    public PackagePresenter(Context context, PackageView packageView) {
        this.context = context;
        this.packageView = packageView;
    }

    public void getListPackage(int conferenceId) {
        DownloadAsyncTask.GET(context, ID_API_LIST_PACKAGE, API_LIST_PACKAGE + "?conferenceId=" + conferenceId, Package.class, true, this);
    }

    @Override
    public void downloadSuccess(int processId, Object data) {
        super.downloadSuccess(processId, data);
        ArrayList<Package> list = (ArrayList<Package>) data;
        if (list.isEmpty()) {
            packageView.empty();
        } else {
            packageView.success(list);
        }
    }

    @Override
    public void downloadError(int processId, String msg) {
        super.downloadError(processId, msg);
        packageView.error(msg);
    }
}
