package cse.duytan.coms.fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import cse.duytan.coms.R;
import cse.duytan.coms.adapters.ScheduleInHomeAdapter;
import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.HorizontalCalendarListener;
import devs.mulham.horizontalcalendar.HorizontalCalendarView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScheduleInSessionFragment extends android.app.Fragment {
    private ListView listView;
    private Calendar startDate, endDate;

    public ScheduleInSessionFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_schedule_in_session, container, false);
        setUpListView(view);
        onCreate(view);
        initUI();
        return view;
    }

    private void initUI() {
        getActivity().setTitle(R.string.title_schedule_in_session);
    }
    public void setUpListView(View view) {
        listView = (ListView) view.findViewById(R.id.ls_schedule_in_session);
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("4");
        list.add("4");
        list.add("4");
        list.add("4");
        list.add("4");
        list.add("4");
        list.add("4");
        list.add("4");
        list.add("4");
        list.add("4");
        ScheduleInHomeAdapter adapter = new ScheduleInHomeAdapter(getActivity(), list);
        listView.setAdapter(adapter);
        endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 1);
        startDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH, -1);
    }
public void onCreate(View view) {

    HorizontalCalendar horizontalCalendar = new HorizontalCalendar.Builder(view, R.id.calendarView1)
            .startDate(startDate.getTime())
            .endDate(endDate.getTime())
            .textColor(Color.parseColor("#F5F5F5"), Color.WHITE)
            .selectorColor(Color.parseColor("#F5F5F5"))
            .build();


    horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
        @Override
        public void onDateSelected(Date date, int position) {
            //do something
            Toast.makeText(getActivity(), "CC", Toast.LENGTH_SHORT).show();
        }
    });

    horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
        @Override
        public void onDateSelected(Date date, int position) {
            Toast.makeText(getActivity(), "" + date, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCalendarScroll(HorizontalCalendarView calendarView,
                                     int dx, int dy) {
        }

        @Override
        public boolean onDateLongClicked(Date date, int position) {
            return true;
        }
    });

    }
}
