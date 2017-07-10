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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import cse.duytan.coms.R;

public class SendAbstractActivity extends AppCompatActivity {
    private Toolbar toolbar;
    Intent intent;
    Button btnChon_chude, btnChon_loaihinhnghiencuu, btnChon_loaihinhtrinhbay;
    TextView txtChude, txtLoaihinhtrinhbay, txtLoaihinhnghiencuu;
    EditText edTieude, edTieudeEng, edNoidung;
    TextView txterr_chude, txterr_loaihinhnghiencuu, txterr_loaihinhtrinhbay, txterr_Tieude;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_abstract);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        intent = this.getIntent();
        String type = intent.getStringExtra("type");
        String title = intent.getStringExtra("title");
        if(type.equals("1") && title.equals("0")){
            setTitle(R.string.title_update_abstract);
        }else{
            setTitle(R.string.title_abstarct);
        }

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
        btnChon_chude.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog_choose(1, "Chủ đề");
            }
        });

        btnChon_loaihinhnghiencuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog_choose(2, "Loại hình nghiên cứu");
            }
        });
        btnChon_loaihinhtrinhbay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog_choose(3, "Loại hình trình bày");
            }
        });
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


    private void dialog_choose(int type, String title){
        AlertDialog.Builder mBuilder  = new AlertDialog.Builder(SendAbstractActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.dialog_spinner_chude, null);
        switch (type){
            case 1:
                mBuilder.setTitle(title);
                final Spinner mSpinner = (Spinner) mView.findViewById(R.id.spinner);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(SendAbstractActivity.this, android.R.layout.simple_spinner_item,
                        getResources().getStringArray(R.array.dsChude));
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mSpinner.setAdapter(adapter);

                mBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(!mSpinner.getSelectedItem().toString().equalsIgnoreCase("Vui lòng chọn chủ đề …")){
                            txtChude.setText(mSpinner.getSelectedItem().toString());
                            txterr_chude.setVisibility(View.GONE);
                            txterr_chude.setText("");
                        }
                    }
                });

                mBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();
                break;
            case 2:
                mBuilder.setTitle(title);
                final Spinner mSpinner2 = (Spinner) mView.findViewById(R.id.spinner);
                ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(SendAbstractActivity.this, android.R.layout.simple_spinner_item,
                        getResources().getStringArray(R.array.dsLoaihinhnghiencuu));
                adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mSpinner2.setAdapter(adapter2);

                mBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(!mSpinner2.getSelectedItem().toString().equalsIgnoreCase("Vui lòng chọn loại hình nghiên cứu …")){
                            txtLoaihinhnghiencuu.setText(mSpinner2.getSelectedItem().toString());
                            txterr_loaihinhnghiencuu.setVisibility(View.GONE);
                            txterr_loaihinhnghiencuu.setText("");
                        }
                    }
                });

                mBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                mBuilder.setView(mView);
                AlertDialog dialog2 = mBuilder.create();
                dialog2.show();
                break;
            case 3:
                mBuilder.setTitle(title);
                final Spinner mSpinner3 = (Spinner) mView.findViewById(R.id.spinner);
                ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(SendAbstractActivity.this, android.R.layout.simple_spinner_item,
                        getResources().getStringArray(R.array.dsLoaihinhnghiencuu));
                adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mSpinner3.setAdapter(adapter3);

                mBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(!mSpinner3.getSelectedItem().toString().equalsIgnoreCase("Vui lòng chọn loại hình trình bày …")){
                            txtLoaihinhtrinhbay.setText(mSpinner3.getSelectedItem().toString());
                            txterr_loaihinhtrinhbay.setVisibility(View.GONE);
                            txterr_loaihinhtrinhbay.setText("");
                        }
                    }
                });

                mBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                mBuilder.setView(mView);
                AlertDialog dialog3 = mBuilder.create();
                dialog3.show();
                break;
        }
    }

    private void addControll(){

        btnChon_chude = (Button) findViewById(R.id.btnChonchude_see_abs);
        btnChon_loaihinhnghiencuu = (Button) findViewById(R.id.btnChonLoaihinhnghiencuu_send_abs);
        btnChon_loaihinhtrinhbay = (Button) findViewById(R.id.btnChonLoaihinhtrinhbay_send_abs);
        txtChude = (TextView) findViewById(R.id.txtChude_see_abs);
        edTieude = (EditText) findViewById(R.id.edTieude_see_abs);
        txtLoaihinhnghiencuu = (TextView) findViewById(R.id.txtLoaihinhnghiencuu_see_abs);
        txtLoaihinhtrinhbay = (TextView) findViewById(R.id.txtLoaihinhtrinhbay_see_abs);
        txterr_chude = (TextView) findViewById(R.id.txterr_chonchude_send_abs);
        txterr_loaihinhnghiencuu = (TextView) findViewById(R.id.txterr_chonloaihinhnghiencuu_send_abs);
        txterr_loaihinhtrinhbay = (TextView) findViewById(R.id.txterr_chonloaihinhtrinhbay_send_abs);
        txterr_Tieude = (TextView) findViewById(R.id.txterr_Tieude_see_abs);
        radioGroup = (RadioGroup) findViewById(R.id.myRadioGroup_quatrinh_send_abs);
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
                String choose_chude = txtChude.getText().toString();
                String choose_loaihinhtrinhbay = txtLoaihinhtrinhbay.getText().toString();
                String choose_loaihinhnghiencuu = txtLoaihinhnghiencuu.getText().toString();

                if(tieude.trim().equals("")){
                    txterr_Tieude.setVisibility(View.VISIBLE);
                    txterr_Tieude.setText("Vui lòng nhâp tiêu đề bài tóm tắt");
                    err++;
                }
                if(choose_chude.equals("")){
                    txterr_chude.setVisibility(View.VISIBLE);
                    txterr_chude.setText("Vui lòng chọn chủ đề");
                    err++;
                }
                if(choose_loaihinhnghiencuu.equals("")){
                    txterr_loaihinhnghiencuu.setVisibility(View.VISIBLE);
                    txterr_loaihinhnghiencuu.setText("Vui lòng chọn loại hình nghiên cứu");
                    err++;
                }
                if(choose_loaihinhtrinhbay.equals("")){
                    txterr_loaihinhtrinhbay.setVisibility(View.VISIBLE);
                    txterr_loaihinhtrinhbay.setText("Vui lòng chọn loại hình trình bày");
                    err++;
                }

                int selected = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = (RadioButton) findViewById(selected);

                if(err>0){
                    Toast.makeText(SendAbstractActivity.this, "lỗi", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(SendAbstractActivity.this, "Lưu", Toast.LENGTH_SHORT).show();
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
