package cse.duytan.coms.views;

import java.util.ArrayList;

import cse.duytan.coms.models.Conference;

/**
 * Created by iMac on 8/11/17.
 */

public interface ConferenceView {
    void listConference(ArrayList<Conference> listConference);
    void error(String msg);
}
