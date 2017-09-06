package cse.duytan.coms.fragments;


import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;
import com.prolificinteractive.materialcalendarview.OnMonthChangedListener;
import com.prolificinteractive.materialcalendarview.spans.DotSpan;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Executors;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cse.duytan.coms.R;
import cse.duytan.coms.adapters.ScheduleAdapter;
import cse.duytan.coms.customviews.CustomTextView;
import cse.duytan.coms.models.Schedule;
import cse.duytan.coms.presenters.SchedulePresenter;
import cse.duytan.coms.untils.AdapterCallback;
import cse.duytan.coms.untils.DateTimeFormater;
import cse.duytan.coms.untils.Utils;
import cse.duytan.coms.views.ScheduleView;

/**
 * A simple {@link Fragment} subclass.
 */
public class OnScheduleFragment extends android.app.Fragment implements OnDateSelectedListener, OnMonthChangedListener, ScheduleView, AdapterCallback {


    @BindView(R.id.calendarView)
    MaterialCalendarView widget;
    Unbinder unbinder;
    @BindView(R.id.rvSchedule)
    RecyclerView rvSchedule;
    @BindView(R.id.tvdate)
    CustomTextView tvdate;
    @BindView(R.id.tvRule)
    CustomTextView tvRule;
    private SchedulePresenter schedulePresenter;
    private ScheduleAdapter adapter;
    private ArrayList<Schedule> listSchedule;
    private ArrayList<Schedule> newSchedule = new ArrayList<>();
    private ArrayList<Date> listDay = new ArrayList<>();
    private static final DateFormat FORMATTER = SimpleDateFormat.getDateInstance();

    public OnScheduleFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_on_schedule, container, false);
        unbinder = ButterKnife.bind(this, v);
        widget.setOnDateChangedListener(this);
        Calendar instance = Calendar.getInstance();
        widget.setSelectedDate(instance.getTime());
        getData();
        setUp();
        return v;
    }

    private void getData() {
        listSchedule = new ArrayList<>();
        schedulePresenter = new SchedulePresenter(getActivity(), this);
        schedulePresenter.getListSchedule("pvthien");
    }

    private void setUp() {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(), manager.getOrientation());
        rvSchedule.setHasFixedSize(true);
        rvSchedule.setLayoutManager(manager);
        //rvSchedule.addItemDecoration(dividerItemDecoration);
        adapter = new ScheduleAdapter(getActivity(), newSchedule, this);
        rvSchedule.setAdapter(adapter);
    }

    private String getSelectedDates(){
        CalendarDay date = widget.getSelectedDate();
        if (date == null){
            return "No Selection";
        }
        return  FORMATTER.format(date.getDate());
    }
    private ArrayList<Schedule> returnSchedule(Date date){
        ArrayList<Schedule> newSchedule = new ArrayList<>();
        for (int i = 0; i < listSchedule.size(); i++) {
            ArrayList<Date> dates = new ArrayList<>();
            dates = Utils.getDaysBetweenDates(DateTimeFormater.stringToDate(listSchedule.get(i).getFROM_DATE(), DateTimeFormater.YYYY_MM_DD_T_HH_MM_SS_SS),
                    DateTimeFormater.stringToDate(listSchedule.get(i).getTHRU_DATE(), DateTimeFormater.YYYY_MM_DD_T_HH_MM_SS_SS));
            Log.d("", "i "+i+" --- "+dates.toString());
                for (int k = 0; k < dates.size(); k++){
                    if (date.equals(dates.get(k))){
                        Log.d("", "returnSchedule: "+dates.get(k));
                        Log.d("", "returnScheduled: "+listSchedule.get(i).getCONFERENCE_NAME());
                        newSchedule.add(listSchedule.get(i));
                    }
                }
        }
        Log.d("", "returnSchedule: "+newSchedule.size());
        return newSchedule;
    }
    @Override
    public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
        newSchedule = returnSchedule(widget.getSelectedDate().getDate());
        if (!newSchedule.isEmpty()){
            rvSchedule.setVisibility(View.VISIBLE);
            tvRule.setVisibility(View.VISIBLE);
            tvdate.setVisibility(View.GONE);
            setUp();
            adapter.notifyDataSetChanged();
        } else {
            tvRule.setVisibility(View.GONE);
            tvdate.setVisibility(View.VISIBLE);
            rvSchedule.setVisibility(View.GONE);
            tvdate.setText(getSelectedDates());
        }
    }

    @Override
    public void onMonthChanged(MaterialCalendarView widget, CalendarDay date) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void listSchedule(ArrayList<Schedule> listSchedule) {
        this.listSchedule.addAll(listSchedule);
        adapter.notifyDataSetChanged();
        new ApiSimulator().executeOnExecutor(Executors.newSingleThreadExecutor());

    }

    @Override
    public void error(String msg) {

    }

    @Override
    public void adpaterCallback(Object data, int processId, int position) {

    }

    public class EventDecorator implements DayViewDecorator {
        private int color;
        private HashSet<CalendarDay> dates;

        public EventDecorator(int color, Collection<CalendarDay> dates) {
            this.color = color;
            this.dates = new HashSet<>(dates);
        }

        @Override
        public boolean shouldDecorate(CalendarDay day) {
            return dates.contains(day);
        }

        @Override
        public void decorate(DayViewFacade view) {
            view.addSpan(new DotSpan(5, color));
        }
    }

    private class ApiSimulator extends AsyncTask<Void, Void, List<CalendarDay>> {

        @Override
        protected List<CalendarDay> doInBackground(@NonNull Void... voids) {
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            listDay = createListDate(listSchedule);

            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.MONTH, -2);
            ArrayList<CalendarDay> dates = new ArrayList<>();
            for (int i = 0; i < listDay.size(); i++) {
                CalendarDay day = CalendarDay.from(listDay.get(i));
                dates.add(day);
                calendar.add(Calendar.DATE, 5);
            }
            return dates;
        }

        @Override
        protected void onPostExecute(@NonNull List<CalendarDay> calendarDays) {
            super.onPostExecute(calendarDays);

            if (getActivity().isFinishing()) {
                return;
            }

            widget.addDecorator(new EventDecorator(Color.RED, calendarDays));
        }

        protected ArrayList<Date> createListDate(ArrayList<Schedule> schedules) {
            ArrayList<Date> Dates = new ArrayList<>();
            for (int i = 0; i < schedules.size(); i++) {
                ArrayList<Date> dates = new ArrayList<>();
                dates = Utils.getDaysBetweenDates(DateTimeFormater.stringToDate(schedules.get(i).getFROM_DATE(), DateTimeFormater.YYYY_MM_DD_T_HH_MM_SS_SS),
                        DateTimeFormater.stringToDate(schedules.get(i).getTHRU_DATE(), DateTimeFormater.YYYY_MM_DD_T_HH_MM_SS_SS));
                Dates.addAll(dates);
            }
            return Dates;
        }
    }

}
