package cse.duytan.coms.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

import cse.duytan.coms.R;
import cse.duytan.coms.activities.XemThongtinActivity;
import cse.duytan.coms.adapters.ReviewAdapter1;
import cse.duytan.coms.models.Review;

/**
 * Created by DungTrungCut on 7/11/2017.
 */

public class RejectPaperFragment extends ListFragment {
    private ListView listView;
    private ArrayList<Review> arrReject;
    private ReviewAdapter1 adapter1;
    private Animation animation, animation_abs;
    private LinearLayout ln, ln_func, ln_row_reject;

    public RejectPaperFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_reject, container, false);
        loadListReview();
        return rootView;
    }

    private void loadListReview(){
        arrReject = new ArrayList<>();
        addArrNotYetEvaluat();
        adapter1 = new ReviewAdapter1(this.getActivity(), android.R.id.list, arrReject);
        setListAdapter(adapter1);
//        listView.setAdapter(adapter1);
    }


    private void addArrNotYetEvaluat(){
        arrReject.add(new Review("Bài báo 10", 1, "Ngày gửi: 7/7/2017","207 Nguyễn Văn Linh, Phòng 01"));
        arrReject.add(new Review("Bài báo 11", 1, "Ngày gửi: 8/7/2017","207 Nguyễn Văn Linh, Phòng 02"));
        arrReject.add(new Review("Bài báo 12", 1, "Ngày gửi: 9/7/2017","207 Nguyễn Văn Linh, Phòng 03"));
        arrReject.add(new Review("Bài báo 13", 1, "Ngày gửi: 10/7/2017","207 Nguyễn Văn Linh, Phòng 04"));
        arrReject.add(new Review("Bài báo 14", 1, "Ngày gửi: 11/7/2017","207 Nguyễn Văn Linh, Phòng 05"));
        arrReject.add(new Review("Bài báo 15", 1, "Ngày gửi: 12/7/2017","207 Nguyễn Văn Linh, Phòng 06"));
        arrReject.add(new Review("Bài báo 16", 1, "Ngày gửi: 13/7/2017","207 Nguyễn Văn Linh, Phòng 07"));
        arrReject.add(new Review("Bài báo 17", 1, "Ngày gửi: 14/7/2017","207 Nguyễn Văn Linh, Phòng 08"));
        arrReject.add(new Review("Bài báo 18", 1, "Ngày gửi: 15/7/2017","207 Nguyễn Văn Linh, Phòng 09"));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent = new Intent(getActivity(), XemThongtinActivity.class);
        intent.putExtra("type","2");// tiêu đề bài báo
        startActivity(intent);
    }
}
