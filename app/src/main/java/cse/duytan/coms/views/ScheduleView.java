package cse.duytan.coms.views;

import java.util.ArrayList;

import cse.duytan.coms.models.Schedule;

/**
 * Created by iMac on 8/31/17.
 */

public interface ScheduleView {
    void listSchedule(ArrayList<Schedule> listSchedule);
    void error(String msg);
}
