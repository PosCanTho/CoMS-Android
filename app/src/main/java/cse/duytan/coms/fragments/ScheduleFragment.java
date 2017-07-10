package cse.duytan.coms.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import cse.duytan.coms.R;
import cse.duytan.coms.adapters.ScheduleInHomeAdapter;
import cse.duytan.coms.helpers.OnSwipeTouchListener;
import cse.duytan.coms.helpers.SlideAnimationUtil;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScheduleFragment extends android.app.Fragment {
    private ListView listView;
    private TextView CurrentDate;
    private LinearLayout scheduleLayout;
    private Date currentDate = new Date();
    private int page = 0;
    public ScheduleFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);
        setUpListView(view);
        setUpDateTime(view);
        addEvents(view);
        return view;
    }

    public void setUpListView(View view) {
        listView = (ListView) view.findViewById(R.id.lsSchedule);
        ArrayList<String> list = new ArrayList<>();
        list.add("1");list.add("2");list.add("3");list.add("4");list.add("5");list.add("6");
        ScheduleInHomeAdapter adapter = new ScheduleInHomeAdapter(getActivity(), list);
        listView.setAdapter(adapter);
    }

    public void setUpDateTime(View view) {
        CurrentDate = (TextView) view.findViewById(R.id.txtCurrentDate);
        currentDate = new Date(currentDate.getTime());

        CurrentDate.setText(setTitle(currentDate));
    }
    public static String setTitle(Date date) {
        DateFormat df = new SimpleDateFormat("EEEE, d/MM/yyyy");
        String title = df.format(date);
        return title;
    }
    private void addEvents(final View view){
        scheduleLayout = (LinearLayout)view.findViewById(R.id.layoutSchedule);

        scheduleLayout.setOnTouchListener(new OnSwipeTouchListener(getActivity()){

            public void onSwipeRight() {
                // previous day, week, month
                page = -1;
                Toast.makeText(getActivity(), "hihi Right nè", Toast.LENGTH_SHORT).show();
                //SlideAnimationUtil.slideOutToRight(getActivity(), view);
            }

            public void onSwipeLeft() {
                // next day, week, month
                page = 1;
                Toast.makeText(getActivity(), "hihi Left ồi nè", Toast.LENGTH_SHORT).show();
                //SlideAnimationUtil.slideOutToLeft(getActivity(), view);
            }
        });

        listView.setOnTouchListener(new OnSwipeTouchListener(getActivity()){

            public void onSwipeRight() {
                // previous day, week, month
                page = -1;
                Toast.makeText(getActivity(), "hihi Right nè", Toast.LENGTH_SHORT).show();
                SlideAnimationUtil.slideOutToRight(getActivity(), scheduleLayout);
            }

            public void onSwipeLeft() {
                // next day, week, month
                page = 1;
                Toast.makeText(getActivity(), "hihi Left ồi nè", Toast.LENGTH_SHORT).show();
                SlideAnimationUtil.slideOutToLeft(getActivity(), scheduleLayout);
            }
        });
    }
}
