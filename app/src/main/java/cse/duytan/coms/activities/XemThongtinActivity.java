package cse.duytan.coms.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import cse.duytan.coms.R;

public class XemThongtinActivity extends AppCompatActivity {
    private Toolbar toolbar;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xem_thongtin);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        intent = this.getIntent();
        String type = intent.getStringExtra("type");
        if(type.equals("1")){
            setTitle(R.string.title_see_abstract);
        }else{//2
            setTitle(R.string.title_see_paper);
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);// hiện nút back

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                intent.putExtra("status",0);//0 đang soạn, chưa gửi
//                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
}
