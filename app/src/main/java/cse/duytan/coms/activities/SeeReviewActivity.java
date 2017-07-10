package cse.duytan.coms.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import cse.duytan.coms.R;

public class SeeReviewActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private Intent intent;
    TextView txtStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_review);//activity_see_review
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        intent = this.getIntent();
        String type = intent.getStringExtra("type");
        String status = intent.getStringExtra("status");

        if(type.equals("1")){
            setTitle(R.string.title_see_review_abstract);
        }else {
            setTitle(R.string.title_see_review_paper);
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);// hiện nút back

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        addControllers();
        addEvents();
        if(status.equals("0")){// từ chối
            txtStatus.setText("Từ chối");
            txtStatus.setBackgroundResource(R.drawable.shape_red);
            txtStatus.setTextColor(Color.RED);
        }else{
            txtStatus.setText("Đã duyệt");
            txtStatus.setBackgroundResource(R.drawable.shape_green);
            txtStatus.setTextColor(Color.GREEN);
        }
    }

    private void addControllers(){
        txtStatus = (TextView) findViewById(R.id.txtStatus_see_review);

    }

    private void addEvents(){

    }
}
