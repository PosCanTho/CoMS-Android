package cse.duytan.coms.presenters;

import android.content.Context;

import java.util.ArrayList;

import cse.duytan.coms.connections.DownloadAsyncTask;
import cse.duytan.coms.models.Organization;
import cse.duytan.coms.views.OrganizationView;

/**
 * Created by iMac on 8/30/17.
 */

public class OrganizationPresenter extends BasePresenter {
    private Context context;
    private OrganizationView organizationView;

    public OrganizationPresenter(Context context, OrganizationView organizationView){
        this.context = context;
        this.organizationView = organizationView;
    }
    public void getOrganization(int organizing_organization_id){
        DownloadAsyncTask.POST(context, ID_API_ORGANIZATION, API_ORGANIZATION +"?organizing_organization_id="+organizing_organization_id,"", Organization.class, false, this);
    }

    @Override
    public void downloadSuccess(int processId, Object data) {
        super.downloadSuccess(processId, data);
        if(processId == ID_API_ORGANIZATION){
            organizationView.setListOrganization((ArrayList<Organization>) data);
        }
    }

    @Override
    public void downloadError(int processId, String msg) {
        super.downloadError(processId, msg);
        organizationView.error(msg);
    }
}

