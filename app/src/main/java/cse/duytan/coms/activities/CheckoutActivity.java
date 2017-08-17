package cse.duytan.coms.activities;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cse.duytan.coms.R;
import cse.duytan.coms.adapters.ListPopupWindownAdapter;
import cse.duytan.coms.adapters.RecyclerPaymentAdapter;
import cse.duytan.coms.customviews.CustomTextView;
import cse.duytan.coms.models.PaymentMethod;
import cse.duytan.coms.untils.Utils;

public class CheckoutActivity extends BaseActivity {

    @BindView(R.id.clMain)
    ConstraintLayout clMain;
    @BindView(R.id.tvTotal)
    CustomTextView tvTotal;
    @BindView(R.id.rvPaymentMethod)
    RecyclerView rvPaymentMethod;
    @BindView(R.id.tvRole)
    CustomTextView tvRole;
    @BindView(R.id.tvMonth)
    CustomTextView tvMonth;
    @BindView(R.id.tvYear)
    CustomTextView tvYear;
    @BindView(R.id.etCCVCode)
    EditText etCCVCode;
    @BindView(R.id.clPaymentMethod)
    ConstraintLayout clPaymentMethod;
    @BindView(R.id.btnConfirm)
    Button btnConfirm;
    @BindView(R.id.etCard1)
    EditText etCard1;
    @BindView(R.id.etCard2)
    EditText etCard2;
    @BindView(R.id.etCard3)
    EditText etCard3;
    @BindView(R.id.etCard4)
    EditText etCard4;
    @BindView(R.id.tvName)
    CustomTextView tvName;

    private ListPopupWindownAdapter roleAdapter, monthAdapter, yearAdapter;
    private ListPopupWindow popupYear, popupRole, popupMonth;
    private String[] listRole, listMonth, listYear;

    private RecyclerPaymentAdapter paymentAdapter;
    private ArrayList<PaymentMethod> listPayment;

    /*Intent truyền qua*/
    private String name;
    private int packageId;
    private int price;
    private String uomName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        ButterKnife.bind(this);
        initUI();
    }

    private void initUI() {
        Utils.getChangeFont(this, clMain, R.string.font_nunito_regular);
        tvTotal.setTypeface(Utils.getFonts(this,R.string.font_nunito_bold));
        getMyIntent();

        etCard1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.toString().length() == 4) etCard2.requestFocus();
            }
        });
        etCard2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.toString().length() == 4) etCard3.requestFocus();
            }
        });
        etCard3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.toString().length() == 4) etCard4.requestFocus();
            }
        });

        setRvPaymentMethodAdp();
        setTvRoleAdp();
        setTvMonthAdp();
        setTvYearAdp();
    }

    private void getMyIntent() {
        Intent i = getIntent();
        if (i != null) {
            name = i.getStringExtra("name");
            packageId = i.getIntExtra("packageId", -1);
            price = i.getIntExtra("price", 0);
            uomName = i.getStringExtra("uomName");

            tvName.setText(getString(R.string.lbl_package_name) + ": " + name);
            tvTotal.setText(Utils.formatPrice(price) + " " + uomName);
        }
    }

    private void setRvPaymentMethodAdp() {
        listPayment = new ArrayList<>();
        listPayment.add(new PaymentMethod(getString(R.string.lbl_credit_card), BitmapFactory.decodeResource(getResources(), R.drawable.ic_credit_card), false));
        listPayment.add(new PaymentMethod(getString(R.string.lbl_paypal), BitmapFactory.decodeResource(getResources(), R.drawable.ic_paypal), false));
        listPayment.add(new PaymentMethod(getString(R.string.lbl_check), BitmapFactory.decodeResource(getResources(), R.drawable.ic_check), false));
        listPayment.add(new PaymentMethod(getString(R.string.lbl_check), BitmapFactory.decodeResource(getResources(), R.drawable.ic_credit_card), false));
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayout.HORIZONTAL, false);
        rvPaymentMethod.setLayoutManager(manager);
        paymentAdapter = new RecyclerPaymentAdapter(this, listPayment, this);
        rvPaymentMethod.setAdapter(paymentAdapter);
    }

    private void setTvMonthAdp() {
        listMonth = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        monthAdapter = new ListPopupWindownAdapter(this, listMonth);
        popupMonth = new ListPopupWindow(this);
        popupMonth.setAdapter(monthAdapter);
        popupMonth.setAnchorView(tvMonth);
        popupMonth.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                tvMonth.setText(listMonth[i]);
                popupMonth.dismiss();
            }
        });
    }

    private void setTvYearAdp() {
        listYear = new String[50];
        int year = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 0; i < 50; i++) {
            listYear[i] = year + "";
            year--;
        }
        yearAdapter = new ListPopupWindownAdapter(this, listYear);
        popupYear = new ListPopupWindow(this);
        popupYear.setAdapter(yearAdapter);
        popupYear.setAnchorView(tvYear);
        popupYear.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                tvYear.setText(listYear[i]);
                popupYear.dismiss();
            }
        });
    }

    private void setTvRoleAdp() {
        listRole = new String[]{"Author", "Presenter", "Reviewer",};
        roleAdapter = new ListPopupWindownAdapter(this, listRole);
        popupRole = new ListPopupWindow(this);
        popupRole.setAdapter(roleAdapter);
        popupRole.setAnchorView(tvRole);
        popupRole.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                tvRole.setText(listRole[i]);
                popupRole.dismiss();
            }
        });
    }

    @OnClick({R.id.tvRole, R.id.tvMonth, R.id.tvYear, R.id.btnConfirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvRole:
                popupRole.show();
                break;
            case R.id.tvMonth:
                popupMonth.show();
                break;
            case R.id.tvYear:
                popupYear.show();
                break;
            case R.id.btnConfirm:
                break;
        }
    }

    @Override
    public void adpaterCallback(Object data, int processId, int position) {
        super.adpaterCallback(data, processId, position);
        if (processId == R.id.clMain) {
            PaymentMethod item = (PaymentMethod) data;
            int size = listPayment.size();
            for (int i = 0; i < size; i++) {
                if (i != position) {
                    listPayment.get(i).setSelected(false);
                }
            }
            listPayment.get(position).setSelected(!item.isSelected());
            paymentAdapter.notifyDataSetChanged();
        }
    }
}
