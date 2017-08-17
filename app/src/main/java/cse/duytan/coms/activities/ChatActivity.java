package cse.duytan.coms.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;

import com.google.gson.Gson;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cse.duytan.coms.R;
import cse.duytan.coms.adapters.ListChatAdapter;
import cse.duytan.coms.customviews.CustomEditText;
import cse.duytan.coms.dialogs.ConfirmDialog;
import cse.duytan.coms.dialogs.ConfirmOkDialog;
import cse.duytan.coms.models.EventBusInfo;
import cse.duytan.coms.models.Message;
import cse.duytan.coms.presenters.ChatPresenter;
import cse.duytan.coms.views.ChatView;

public class ChatActivity extends BaseActivity implements ChatView, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.rvChat)
    RecyclerView rvChat;
    @BindView(R.id.etTypeMessage)
    CustomEditText etTypeMessage;
    @BindView(R.id.ibtnSend)
    ImageButton ibtnSend;
    @BindView(R.id.swipeRefresh)
    SwipeRefreshLayout swipeRefresh;

    private ListChatAdapter chatAdapter;
    private ArrayList<Message> listMessage;
    private int personIdFrom, personIdTo, personId;
    private int page = 1, pageSize = 10;
    private String name;
    private ChatPresenter chatPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        ButterKnife.bind(this);
        initUI();
    }

    private void initUI() {
        getMyIntent();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        chatPresenter = new ChatPresenter(this, this);
        chatPresenter.getListMessage(personIdFrom, personIdTo, page, pageSize);
        listMessage = new ArrayList<>();
        setRvChatAdp();

        swipeRefresh.setOnRefreshListener(this);

    }

    private void getMyIntent() {
        Intent i = getIntent();
        if (i != null) {
            personIdFrom = i.getIntExtra("personIdFrom", -1);
            personIdTo = i.getIntExtra("personIdTo", -1);
            name = i.getStringExtra("name");
            personId = 1;
            setTitle(name);
        }
    }

    private void setRvChatAdp() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setStackFromEnd(true);
        rvChat.setHasFixedSize(true);
        rvChat.setLayoutManager(manager);
        chatAdapter = new ListChatAdapter(this, listMessage);
        rvChat.setAdapter(chatAdapter);
        chatAdapter.notifyDataSetChanged();
    }

    private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            try {
                String data = intent.getStringExtra("message");
                Message message = new Gson().fromJson(data, Message.class);
                listMessage.add(message);
                chatAdapter.notifyDataSetChanged();
                rvChat.scrollToPosition(listMessage.size() - 1);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    };


    @Override
    protected void onStart() {
        super.onStart();
        LocalBroadcastManager.getInstance(this).registerReceiver((mMessageReceiver),
                new IntentFilter("Message")
        );
    }

    @Override
    protected void onStop() {
        super.onStop();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mMessageReceiver);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.chat_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.actionClear:
                new ConfirmDialog(this, getString(R.string.msg_are_you_sure_you_want_to_delete_all_message), this).show();
                break;
            case R.id.actionProfile:
                startActivity(new Intent(ChatActivity.this, ProfileActivity.class));
                break;
            case android.R.id.home:
                postEvent(new EventBusInfo(ID_EVENT_REFRESH));
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.ibtnSend)
    public void onViewClicked() {
        String message = etTypeMessage.getText().toString();
        if (!TextUtils.isEmpty(message) && (personIdFrom != -1) && (personIdTo != -1)) {
            chatPresenter.sendMessage(message, personIdFrom, personIdTo, "default", "high");
            etTypeMessage.setText("");
        }
    }

    @Override
    public void popupCalback(int processId, Object data) {
        super.popupCalback(processId, data);
        if (processId == ID_DIALOG_CONFIRM_YES) {
            chatPresenter.deleteAllMessage(personId, personIdFrom, personIdTo);
        }
    }

    @Override
    public void sendMessageSuccess(Message message) {
        listMessage.add(message);
        chatAdapter.notifyDataSetChanged();
        rvChat.scrollToPosition(listMessage.size() - 1);
    }

    @Override
    public void listMessage(ArrayList<Message> listMessage) {
        if (listMessage.isEmpty()){
            swipeRefresh.setEnabled(false);
        }
        ArrayList<Message> list = new ArrayList<>();
        int size = listMessage.size();
        for (int i = 0; i < size; i++) {
            list.add(0, listMessage.get(i));
        }
        this.listMessage.addAll(0, list);
        chatAdapter.notifyDataSetChanged();
        swipeRefresh.setRefreshing(false);
    }

    @Override
    public void deleteAllSuccess() {
        listMessage.clear();
        chatAdapter.notifyDataSetChanged();
        rvChat.scrollToPosition(listMessage.size() - 1);
    }

    @Override
    public void error(String msg) {
        new ConfirmOkDialog(this, msg, this).show();
        swipeRefresh.setRefreshing(false);
        page--;
    }

    @Override
    public void onRefresh() {
        page++;
        chatPresenter.getListMessage(personIdFrom, personIdTo, page, pageSize);
    }
}
