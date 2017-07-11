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
import cse.duytan.coms.adapters.ReviewAdapter;
import cse.duytan.coms.models.Review;

/**
 * Created by DungTrungCut on 7/11/2017.
 */

public class AcceptPaperFragment extends ListFragment {
    private ListView listView;
    private ArrayList<Review> arrAccept;
    private ReviewAdapter adapter;
    private Animation animation, animation_abs;
    private LinearLayout ln, ln_func, ln_row_abstract;

    public AcceptPaperFragment() {
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
        View rootView = inflater.inflate(R.layout.fragment_accept, container, false);
        loadListReview();
        return rootView;
    }


    private void loadListReview(){
        arrAccept = new ArrayList<>();
        addArrAccept();
        adapter = new ReviewAdapter(this.getActivity(), android.R.id.list, arrAccept);// android.R.id.list android.R.layout.simple_list_item_multiple_choice
        setListAdapter(adapter);
    }

    private void addArrAccept(){
        arrAccept.add(new Review("Bài báo 19", 2, "Ngày gửi: 7/7/2017","207 Nguyễn Văn Linh, Phòng 01"));
        arrAccept.add(new Review("Bài báo 20", 2, "Ngày gửi: 8/7/2017","207 Nguyễn Văn Linh, Phòng 02"));
        arrAccept.add(new Review("Bài báo 21", 2, "Ngày gửi: 9/7/2017","207 Nguyễn Văn Linh, Phòng 03"));
        arrAccept.add(new Review("Bài báo 22", 2, "Ngày gửi: 10/7/2017","207 Nguyễn Văn Linh, Phòng 04"));
        arrAccept.add(new Review("Bài báo 23", 2, "Ngày gửi: 11/7/2017","207 Nguyễn Văn Linh, Phòng 05"));
        arrAccept.add(new Review("Bài báo 24", 2, "Ngày gửi: 12/7/2017","207 Nguyễn Văn Linh, Phòng 06"));
        arrAccept.add(new Review("Bài báo 25", 2, "Ngày gửi: 13/7/2017","207 Nguyễn Văn Linh, Phòng 07"));
        arrAccept.add(new Review("Bài báo 26", 2, "Ngày gửi: 14/7/2017","207 Nguyễn Văn Linh, Phòng 08"));
        arrAccept.add(new Review("Bài báo 27", 2, "Ngày gửi: 15/7/2017","207 Nguyễn Văn Linh, Phòng 09"));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent = new Intent(getActivity(), XemThongtinActivity.class);
        intent.putExtra("type","2");// tiêu đề bài báo
        startActivity(intent);
    }
}
