package cse.duytan.coms.views;

import java.util.ArrayList;

import cse.duytan.coms.models.Organization;

/**
 * Created by iMac on 8/30/17.
 */

public interface OrganizationView {
    void setListOrganization(ArrayList<Organization> listOrganization);
    void error(String msg);
}
