package cse.duytan.coms.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.InfiniteScrollAdapter;
import com.yarolegovich.discretescrollview.Orientation;
import com.yarolegovich.discretescrollview.transform.ScaleTransformer;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cse.duytan.coms.R;
import cse.duytan.coms.adapters.PagePackageAdapter;
import cse.duytan.coms.customviews.CustomTextView;
import cse.duytan.coms.dialogs.ConfirmDialog;
import cse.duytan.coms.dialogs.ConfirmOkDialog;
import cse.duytan.coms.models.Package;
import cse.duytan.coms.presenters.PackagePresenter;
import cse.duytan.coms.untils.Utils;
import cse.duytan.coms.views.PackageView;

public class PackageActivity extends BaseActivity implements DiscreteScrollView.OnItemChangedListener, PackageView {

    @BindView(R.id.dsvPackage)
    DiscreteScrollView dsvPackage;
    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.tvPrice)
    TextView tvPrice;
    @BindView(R.id.fabCheckout)
    FloatingActionButton fabCheckout;
    @BindView(R.id.ivEmpty)
    ImageView ivEmpty;
    @BindView(R.id.tvEmpty)
    CustomTextView tvEmpty;
    @BindView(R.id.llEmpty)
    LinearLayout llEmpty;
    @BindView(R.id.rlContent)
    RelativeLayout rlContent;

    private InfiniteScrollAdapter infiniteAdapter;
    private ArrayList<Package> listPackage;
    private PackagePresenter packagePresenter;
    private int conferenceId = 1;
    private Package item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package);
        ButterKnife.bind(this);
        initUI();
    }

    private void initUI() {
        listPackage = new ArrayList<>();
        showHomeButton();
        setDsvPackageAdp();
        empty(false, "", llEmpty, rlContent, tvEmpty);
        packagePresenter = new PackagePresenter(this, this);
        packagePresenter.getListPackage(conferenceId);
    }

    private void setDsvPackageAdp() {
        dsvPackage.setOrientation(Orientation.HORIZONTAL);
        dsvPackage.addOnItemChangedListener(this);
        infiniteAdapter = InfiniteScrollAdapter.wrap(new PagePackageAdapter(PackageActivity.this, listPackage));
        dsvPackage.setAdapter(infiniteAdapter);
        dsvPackage.setItemTransitionTimeMillis(150);
        dsvPackage.setItemTransformer(new ScaleTransformer.Builder()
                .setMinScale(0.8f)
                .build());

    }


    @Override
    public void onCurrentItemChanged(@Nullable RecyclerView.ViewHolder viewHolder, int adapterPosition) {
        item = listPackage.get(infiniteAdapter.getRealPosition(adapterPosition));
        tvName.setText(item.getCONFERENCE_REGISTRATION_PACKAGE_NAME());
        tvPrice.setText(Utils.formatPrice(item.getCONFERENCE_REGISTRATION_PACKAGE_PRICE()) + " " + item.getCONFERENCE_REGISTRATION_PACKAGE_PRICE_CURRENCY_UOM_NAME());
    }

    @OnClick(R.id.fabCheckout)
    public void onViewClicked() {
        Intent i = new Intent(PackageActivity.this, CheckoutActivity.class);
        i.putExtra("packageId",item.getCONFERENCE_REGISTRATION_PACKAGE_ID());
        i.putExtra("name",item.getCONFERENCE_REGISTRATION_PACKAGE_NAME());
        i.putExtra("price",item.getCONFERENCE_REGISTRATION_PACKAGE_PRICE());
        i.putExtra("uomName",item.getCONFERENCE_REGISTRATION_PACKAGE_PRICE_CURRENCY_UOM_NAME());
        startActivity(i);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void success(ArrayList<Package> listPackage) {
        this.listPackage.addAll(listPackage);
        infiniteAdapter.notifyDataSetChanged();
        empty(false, "", llEmpty, rlContent, tvEmpty);
    }

    @Override
    public void error(String msg) {
        new ConfirmOkDialog(this, msg, null).show();
        empty(true, msg, llEmpty, rlContent, tvEmpty);
    }

    @Override
    public void empty() {
        empty(true, getString(R.string.msg_no_data_package), llEmpty, rlContent, tvEmpty);
    }
}
