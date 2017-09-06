package cse.duytan.coms.views;

import java.util.ArrayList;

import cse.duytan.coms.models.ConferenceSession;

/**
 * Created by iMac on 8/4/17.
 */

public interface ConferenceSessionView {
    void listSession(ArrayList<ConferenceSession> listSession);
    void error(String msg);
}
