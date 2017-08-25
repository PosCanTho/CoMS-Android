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
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

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
import cse.duytan.coms.helpers.Prefs;
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
    private int personIdTo = -1, personId = -1;
    private int page = 1, pageSize = 10;
    private String name, task;
    private ChatPresenter chatPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        ButterKnife.bind(this);
        initUI();
    }

    private void initUI() {
        personId = Prefs.getUser().getPersonId();
        getMyIntent();
        showHomeButton();

        listMessage = new ArrayList<>();
        setRvChatAdp();
        swipeRefresh.setOnRefreshListener(this);

        etTypeMessage.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    onSend();
                }
                return false;
            }
        });

    }

    private void getMyIntent() {
        Intent i = getIntent();
        if (i != null) {
            personIdTo = i.getIntExtra("personIdTo", -1);
            name = i.getStringExtra("name");
            task = i.getStringExtra("task");
            setTitle(name);

            Prefs.setIdCurrentRead(personIdTo);
            Toast.makeText(this, "personRead: "+personIdTo+" personPrefs: "+Prefs.getIdCurrentRead(), Toast.LENGTH_SHORT).show();

            chatPresenter = new ChatPresenter(this, this);
            chatPresenter.getListMessage(personId, personIdTo, page, pageSize);
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
                if(message.getPersonIdFrom() == personIdTo){
                    listMessage.add(message);
                    chatAdapter.notifyDataSetChanged();
                    rvChat.scrollToPosition(listMessage.size() - 1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    private void onSend() {
        String message = etTypeMessage.getText().toString();
        if (!TextUtils.isEmpty(message) && (personIdTo != -1)) {
            chatPresenter.sendMessage(message, personId, personIdTo, "default", "high");
            etTypeMessage.setText("");
        }
    }


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
        Prefs.setIdCurrentRead(-1);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Prefs.setIdCurrentRead(-1);
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
                Intent i = new Intent(ChatActivity.this, ProfileActivity.class);
                i.putExtra("PersonIdBookmark", personIdTo);
                startActivity(i);
                finish();
                break;
            case android.R.id.home:
                if (TextUtils.isEmpty(task)) {
                    postEvent(new EventBusInfo(ID_EVENT_REFRESH));
                    finish();
                } else {
                    startActivity(new Intent(this, MainActivity.class));
                    finish();
                }
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.ibtnSend)
    public void onViewClicked() {
        onSend();
    }


    @Override
    public void popupCalback(int processId, Object data) {
        super.popupCalback(processId, data);
        if (processId == ID_DIALOG_CONFIRM_YES) {
            chatPresenter.deleteAllMessage(personId, personId, personIdTo);
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
        if (listMessage.isEmpty()) {
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
        chatPresenter.getListMessage(personId, personIdTo, page, pageSize);
    }
}
