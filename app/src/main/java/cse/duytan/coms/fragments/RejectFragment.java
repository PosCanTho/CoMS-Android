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
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import cse.duytan.coms.R;
import cse.duytan.coms.activities.XemThongtinActivity;
import cse.duytan.coms.adapters.ReviewAdapter1;
import cse.duytan.coms.connections.DownloadAsyncTask;
import cse.duytan.coms.connections.DownloadCallback;
import cse.duytan.coms.models.AbstractApprovedModel;
import cse.duytan.coms.models.AbstractModel;
import cse.duytan.coms.models.Review;
import cse.duytan.coms.untils.Constants;


public class RejectFragment extends ListFragment implements DownloadCallback {
    private ListView listView;
    private ArrayList<Review> arrReject;
    private ReviewAdapter1 adapter1;
    private Animation animation, animation_abs;
    private LinearLayout ln, ln_func, ln_row_reject;

    public RejectFragment() {
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
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("Id", 1);//id person
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String json = jsonObject.toString();
        DownloadAsyncTask.POST(getActivity(), Constants.ID_API_LIST_REVIEW_REJECT_ABSTRACT, Constants.API_LIST_REVIEW_REJECT_ABSTRACT,
                json, AbstractApprovedModel.class, true, RejectFragment.this);


        arrReject = new ArrayList<>();
        addArrNotYetEvaluat();
        adapter1 = new ReviewAdapter1(this.getActivity(), android.R.id.list, arrReject);
        setListAdapter(adapter1);
    }


    private void addArrNotYetEvaluat(){
//        arrReject.add(new Review("Bài tóm tăt 10", 1, "Ngày gửi: 7/7/2017","207 Nguyễn Văn Linh, Phòng 01"));
//        arrReject.add(new Review("Bài tóm tăt 11", 1, "Ngày gửi: 8/7/2017","207 Nguyễn Văn Linh, Phòng 02"));
//        arrReject.add(new Review("Bài tóm tăt 12", 1, "Ngày gửi: 9/7/2017","207 Nguyễn Văn Linh, Phòng 03"));
//        arrReject.add(new Review("Bài tóm tăt 13", 1, "Ngày gửi: 10/7/2017","207 Nguyễn Văn Linh, Phòng 04"));
//        arrReject.add(new Review("Bài tóm tăt 14", 1, "Ngày gửi: 11/7/2017","207 Nguyễn Văn Linh, Phòng 05"));
//        arrReject.add(new Review("Bài tóm tăt 15", 1, "Ngày gửi: 12/7/2017","207 Nguyễn Văn Linh, Phòng 06"));
//        arrReject.add(new Review("Bài tóm tăt 16", 1, "Ngày gửi: 13/7/2017","207 Nguyễn Văn Linh, Phòng 07"));
//        arrReject.add(new Review("Bài tóm tăt 17", 1, "Ngày gửi: 14/7/2017","207 Nguyễn Văn Linh, Phòng 08"));
//        arrReject.add(new Review("Bài tóm tăt 18", 1, "Ngày gửi: 15/7/2017","207 Nguyễn Văn Linh, Phòng 09"));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Review review = (Review) l.getAdapter().getItem(position);
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("idPaper", review.getIdpaper());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String json = jsonObject.toString();
        DownloadAsyncTask.POST(this.getActivity(), Constants.ID_API_GETITEM_ABSTRACT_FORREVIEW, Constants.API_GETITEM_ABSTRACT_FORREVIEW, json,
                AbstractModel.class, true, RejectFragment.this);

    }

    @Override
    public void downloadSuccess(int processId, Object data) {
        if(processId == Constants.ID_API_LIST_REVIEW_REJECT_ABSTRACT){
            ArrayList<AbstractApprovedModel> ds = new ArrayList<>();
            ds = (ArrayList<AbstractApprovedModel>) data;

            if(ds.isEmpty()){
                Toast.makeText(getActivity(), "Chưa có bài bị từ chối.", Toast.LENGTH_LONG).show();
            }else {
                for (int i = 0; i < ds.size(); i++) {
                    String formattedDate = "";
                    Date date_deadline = null;
                    try {
                        date_deadline = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(ds.get(i).getLAST_REVISED_DATE());
                        formattedDate = new SimpleDateFormat("dd/MM/yyyy").format(date_deadline);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }


                    arrReject.add(new Review(
                            ds.get(i).getCONFERENCE_NAME(),
                            2,
                            "Ngày gửi: " + formattedDate,
                            "Địa chỉ: ",
                            ds.get(i).getPERSON_ID(),
                            ds.get(i).getPAPER_ID()
                    ));
                }
                adapter1 = new ReviewAdapter1(this.getActivity(), android.R.id.list, arrReject);// android.R.id.list android.R.layout.simple_list_item_multiple_choice
                setListAdapter(adapter1);
                adapter1.notifyDataSetChanged();
            }
        }else if(processId == Constants.ID_API_GETITEM_ABSTRACT_FORREVIEW){
            ArrayList<AbstractModel> ds = (ArrayList<AbstractModel>) data;
            if(ds.isEmpty()){
                Toast.makeText(getActivity(), getString(R.string.msg_sory_data_is_empty), Toast.LENGTH_SHORT).show();
            }else{
                Intent intent = new Intent(getActivity(), XemThongtinActivity.class);
                intent.putExtra("type", "1");// tiêu đề bài tóm tắt
                intent.putExtra("object", ds.get(0));
                startActivity(intent);
            }
        }
    }

    @Override
    public void downloadError(int processId, String msg) {
        if(processId == Constants.ID_API_LIST_REVIEW_REJECT_ABSTRACT){
            Toast.makeText(this.getActivity(), "lỗi", Toast.LENGTH_LONG).show();
        }
    }

//    @Override
//    public void onListItemClick(ListView l, View v, int position, long id) {
//        super.onListItemClick(l, v, position, id);
//        Intent intent = new Intent(getActivity(), XemThongtinActivity.class);
//        intent.putExtra("type","1");// tiêu đề bài tóm tắt
//        startActivity(intent);
//    }
}
