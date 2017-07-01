package cse.duytan.coms.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cse.duytan.coms.R;
import cse.duytan.coms.adapters.ListChatAdapter;
import cse.duytan.coms.customviews.CustomEditText;
import cse.duytan.coms.models.Message;

public class ChatActivity extends BaseActivity {

    @BindView(R.id.rvChat)
    RecyclerView rvChat;
    @BindView(R.id.etTypeMessage)
    CustomEditText etTypeMessage;
    @BindView(R.id.ibtnSend)
    ImageButton ibtnSend;

    private ListChatAdapter chatAdapter;
    private ArrayList<Message> listMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        ButterKnife.bind(this);
        initUI();
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
                listMessage.clear();
                chatAdapter.notifyDataSetChanged();
                rvChat.scrollToPosition(listMessage.size() - 1);
                break;
            case R.id.actionProfile:
                startActivity(new Intent(ChatActivity.this, ProfileActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initUI() {
        setRvChatAdp();
    }

    private void setRvChatAdp() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setStackFromEnd(true);
        rvChat.setHasFixedSize(true);
        rvChat.setLayoutManager(manager);
        listMessage = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            listMessage.add(new Message("Pham Van Thien", (i + 1) + ". Hello everybody, My name's Thien, I'm developer.", ""));
        }
        chatAdapter = new ListChatAdapter(this, listMessage);
        rvChat.setAdapter(chatAdapter);
    }

    @OnClick(R.id.ibtnSend)
    public void onViewClicked() {
        String message = etTypeMessage.getText().toString();
        etTypeMessage.setText("");
        listMessage.add(new Message("", message, ""));
        chatAdapter.notifyDataSetChanged();
        rvChat.scrollToPosition(listMessage.size() - 1);
    }
}
