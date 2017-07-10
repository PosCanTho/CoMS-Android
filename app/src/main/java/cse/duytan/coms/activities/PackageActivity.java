package cse.duytan.coms.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.TextView;

import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.InfiniteScrollAdapter;
import com.yarolegovich.discretescrollview.Orientation;
import com.yarolegovich.discretescrollview.transform.ScaleTransformer;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cse.duytan.coms.R;
import cse.duytan.coms.adapters.PagePackageAdapter;
import cse.duytan.coms.models.Package;

public class PackageActivity extends BaseActivity implements DiscreteScrollView.OnItemChangedListener {

    @BindView(R.id.dsvPackage)
    DiscreteScrollView dsvPackage;
    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.tvPrice)
    TextView tvPrice;
    @BindView(R.id.fabCheckout)
    FloatingActionButton fabCheckout;

    private InfiniteScrollAdapter infiniteAdapter;
    private ArrayList<Package> listPackage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package);
        ButterKnife.bind(this);
        initUI();
    }

    private void initUI() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        setDsvPackageAdp();
    }

    private void setDsvPackageAdp() {
        listPackage = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            listPackage.add(new Package(i, "Package name " + i, 5000 * i + "$", R.drawable.ic_profile));
        }
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
        Package item = listPackage.get(infiniteAdapter.getRealPosition(adapterPosition));
        tvName.setText(item.getName());
        tvPrice.setText(item.getPrice());
    }

    @OnClick(R.id.fabCheckout)
    public void onViewClicked() {
        startActivity(new Intent(PackageActivity.this, CheckoutActivity.class));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
