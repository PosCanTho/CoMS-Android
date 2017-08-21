package cse.duytan.coms.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cse.duytan.coms.R;
import cse.duytan.coms.activities.ChatActivity;
import cse.duytan.coms.adapters.RecyclerMessageAdapter;
import cse.duytan.coms.customviews.CustomTextView;
import cse.duytan.coms.dialogs.ConfirmOkDialog;
import cse.duytan.coms.helpers.Prefs;
import cse.duytan.coms.models.Conversation;
import cse.duytan.coms.models.EventBusInfo;
import cse.duytan.coms.presenters.MessagePresenter;
import cse.duytan.coms.views.MessageView;

/**
 * Created by Pham Van Thien on 6/27/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class MessageFragment extends BaseFragment implements MessageView {
    @BindView(R.id.rvMessage)
    RecyclerView rvMessage;
    Unbinder unbinder;
    @BindView(R.id.tvEmpty)
    CustomTextView tvEmpty;
    @BindView(R.id.llEmpty)
    LinearLayout llEmpty;
    @BindView(R.id.rlContent)
    RelativeLayout rlContent;

    private View v;
    private RecyclerMessageAdapter messageAdapter;
    private ArrayList<Conversation> listMessage;
    private MessagePresenter messagePresenter;
    private int personId = -1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_message, container, false);
        unbinder = ButterKnife.bind(this, v);
        registerEvent();
        initUI();
        return v;
    }

    private void initUI() {
        personId = Prefs.getUser().getPersonId();
        getActivity().setTitle(R.string.title_message);
        empty(false, "", llEmpty, rlContent, tvEmpty);
        messagePresenter = new MessagePresenter(getActivity(), this);
        messagePresenter.getListConversation(personId);
        setRvMessageAdp();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        unregisterEvent();
    }

    private void setRvMessageAdp() {
        listMessage = new ArrayList<>();
        messageAdapter = new RecyclerMessageAdapter(listMessage, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rvMessage.setLayoutManager(mLayoutManager);
        rvMessage.setItemAnimator(new DefaultItemAnimator());
        rvMessage.setAdapter(messageAdapter);
    }

    @Override
    public void onEvent(EventBusInfo eventBusInfo) {
        super.onEvent(eventBusInfo);
        if (eventBusInfo.getProcessId() == ID_EVENT_REFRESH) {
            messagePresenter.getListConversation(personId);
        }
    }

    @Override
    public void adpaterCallback(Object data, int processId, int position) {
        if (processId == R.id.clMain) {
            Conversation conversation = (Conversation) data;
            Intent i = new Intent(getActivity(), ChatActivity.class);
            i.putExtra("personIdTo", conversation.getPersonId());
            i.putExtra("name", conversation.getName());
            startActivity(i);
        }
    }

    @Override
    public void onSuccess(ArrayList<Conversation> list) {
        listMessage.clear();
        listMessage.addAll(list);
        messageAdapter.notifyDataSetChanged();
        empty(false, "", llEmpty, rlContent, tvEmpty);
    }

    @Override
    public void error(String msg) {
        new ConfirmOkDialog(getActivity(), msg, null).show();
        empty(true, msg, llEmpty, rlContent, tvEmpty);
    }

    @Override
    public void empty() {
        empty(true, getString(R.string.msg_no_data_message), llEmpty, rlContent, tvEmpty);
    }
}
