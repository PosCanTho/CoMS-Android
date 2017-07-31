package cse.duytan.coms.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import cse.duytan.coms.R;
import cse.duytan.coms.models.PastSession;
import cse.duytan.coms.untils.AdapterCallback;

/**
 * Created by Pham Van Thien on 6/27/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class ListPastSessionAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<PastSession> list;
    private AdapterCallback adapterCallback;

    public ListPastSessionAdapter(Context context, ArrayList<PastSession> list, AdapterCallback adapterCallback) {
        this.context = context;
        this.list = list;
        this.adapterCallback = adapterCallback;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        OneItem oneItem;
        View v = view;
        if (v == null) {
            v = LayoutInflater.from(context).inflate(R.layout.item_list_past_session, viewGroup, false);
            oneItem = new OneItem(v);
            v.setTag(oneItem);
        } else {
            oneItem = (OneItem) v.getTag();
        }
        final PastSession pastSession = list.get(i);
        oneItem.checkSavePast(pastSession);
        oneItem.loadData(pastSession);
        oneItem.flSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapterCallback.adpaterCallback(pastSession, R.id.flSave, i);
            }
        });
        return v;
    }

    class OneItem {
        TextView tvName;
        TextView tvTime;
        TextView tvLocation;
        ImageView ivSave;
        FrameLayout flSave;

        public OneItem(View v) {
            tvName = (TextView) v.findViewById(R.id.tvName);
            tvTime = (TextView) v.findViewById(R.id.tvTime);
            tvLocation = (TextView) v.findViewById(R.id.tvLocation);
            ivSave = (ImageView) v.findViewById(R.id.ivSave);
            flSave = (FrameLayout) v.findViewById(R.id.flSave);
        }

        public void checkSavePast(PastSession pastSession) {
            if (pastSession.isSelected()) {
                ivSave.setImageResource(R.drawable.ic_calendar_plus);
            } else {
                ivSave.setImageResource(R.drawable.ic_calendar);
            }
        }

        public void loadData(PastSession pastSession) {
           // tvName.setText(pastSession.getName());
           // tvTime.setText(pastSession.getTime());
           // tvLocation.setText(pastSession.getLocation());
        }
    }
}
