package cse.duytan.coms.views;

import java.util.ArrayList;

import cse.duytan.coms.models.Attendee;

/**
 * Created by iMac on 8/9/17.
 */

public interface ListAttendeeView {
    void listAttendee(ArrayList<Attendee> listAttedee);
    void error(String msg);
}
