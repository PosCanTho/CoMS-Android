package cse.duytan.coms.activities;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import cse.duytan.coms.R;

public class SendPaperActivity extends AppCompatActivity {
    private Toolbar toolbar;
    Intent intent = new Intent();
    Button btnChon_taptin;
    TextView txtTieude;
    EditText edTieude;
    TextView txterr_file_paper,txterr_Tieude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_paper);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(R.string.title_papertext);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);// hiện nút back

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("status",0);//0 đang soạn, chưa gửi
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

        addControll();
        addEvents();


    }

    private void addEvents() {

        edTieude.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.toString().trim().equals("") || charSequence.equals(null)){
                    txterr_Tieude.setVisibility(View.VISIBLE);
                    txterr_Tieude.setText("Vui lòng nhâp tiêu đề bài tóm tắt");
                }else{
                    txterr_Tieude.setVisibility(View.GONE);
                    txterr_Tieude.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
    }

    private void addControll(){
        edTieude = (EditText) findViewById(R.id.edTieude_send_paper);
        txterr_Tieude = (TextView) findViewById(R.id.txterr_Tieude_send_paper);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.send, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_send:
                int err = 0;
                String tieude = edTieude.getText().toString();


                if(tieude.trim().equals("")){
                    txterr_Tieude.setVisibility(View.VISIBLE);
                    txterr_Tieude.setText("Vui lòng nhâp tiêu đề bài tóm tắt");
                    err++;
                }


                if(err>0){
//                    Toast.makeText(SendPaperActivity.this, "lỗi", Toast.LENGTH_SHORT).show();
                }else{
//                    Toast.makeText(SendPaperActivity.this, "Lưu", Toast.LENGTH_SHORT).show();
                    AlertDialog.Builder mBuilder = new AlertDialog.Builder(SendPaperActivity.this);
                    View mView = getLayoutInflater().inflate(R.layout.information_dialog, null);
                    TextView txtTieude = (TextView)mView.findViewById(R.id.txtTieudeThongbao);
                    TextView txtTrangthai = (TextView)mView.findViewById(R.id.txtTrangthaithongbao);
                    txtTieude.setText("GỬI BÀI BÁO THÀNH CÔNG");
                    txtTrangthai.setText("Bài báo đang chờ đánh giá");
                    mBuilder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            intent.putExtra("status",0);//0 đang soạn, chưa gửi
                            setResult(Activity.RESULT_OK, intent);
                            finish();
                        }
                    });
                    mBuilder.setView(mView);
                    AlertDialog dialog = mBuilder.create();
                    dialog.show();
                }



//                Toast.makeText(getApplication(), "Hiện thị dialog xác nhận", Toast.LENGTH_LONG).show();
//                intent.putExtra("status",0);//0 đang soạn, chưa gửi
//                setResult(Activity.RESULT_OK, intent);
//                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
