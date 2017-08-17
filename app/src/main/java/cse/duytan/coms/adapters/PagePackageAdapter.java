package cse.duytan.coms.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import cse.duytan.coms.R;
import cse.duytan.coms.models.DescriptionPackage;
import cse.duytan.coms.models.Package;
import cse.duytan.coms.untils.DateTimeFormater;
import cse.duytan.coms.untils.Utils;

/**
 * Created by Pham Van Thien on 6/28/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class PagePackageAdapter extends RecyclerView.Adapter<PagePackageAdapter.ViewHolder> {

    private ArrayList<Package> listPackage;
    private ArrayList<DescriptionPackage> listDescription;
    private Context context;

    public PagePackageAdapter(Context context, ArrayList<Package> listPackage) {
        this.listPackage = listPackage;
        this.context = context;
        listDescription = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_page_package, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Package item = listPackage.get(position);
        holder.tvDescription.setText(item.getDESCRIPTION());
        holder.lvDescriptionPackage.setAdapter(new ListDescriptionPackageAdapter(context, holder.listPackage(item)));
    }

    @Override
    public int getItemCount() {
        return listPackage.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ListView lvDescriptionPackage;
        TextView tvDescription;

        public ViewHolder(View itemView) {
            super(itemView);
            lvDescriptionPackage = (ListView) itemView.findViewById(R.id.lvDescriptionPackage);
            lvDescriptionPackage.setDivider(null);
            tvDescription = (TextView) itemView.findViewById(R.id.tvDescription);
        }

        public ArrayList<DescriptionPackage> listPackage(Package item) {
            ArrayList<DescriptionPackage> list = new ArrayList<>();
            list.add(new DescriptionPackage(item.getCONFERENCE_REGISTRATION_PACKAGE_ID(), context.getString(R.string.lbl_from_date) + ": " + DateTimeFormater.stringToTime(item.getEFFECTIVE_FROM_DATE(), DateTimeFormater.YYYY_MM_DD_T_HH_MM_SS_SS, DateTimeFormater.DD_MM_YY)));
            list.add(new DescriptionPackage(item.getCONFERENCE_REGISTRATION_PACKAGE_ID(), context.getString(R.string.lbl_thru_date) + ": " + DateTimeFormater.stringToTime(item.getEFFECTIVE_THRU_DATE(), DateTimeFormater.YYYY_MM_DD_T_HH_MM_SS_SS, DateTimeFormater.DD_MM_YY)));
            if (!TextUtils.isEmpty(item.getCONFERENCE_REGISTRATION_PACKAGE_OFFERING_NAME_1())) {
                list.add(new DescriptionPackage(item.getCONFERENCE_REGISTRATION_PACKAGE_OFFERING_ID_1(), item.getCONFERENCE_REGISTRATION_PACKAGE_OFFERING_NAME_1() + "\n" + Utils.formatPrice(item.getCONFERENCE_REGISTRATION_PACKAGE_OFFERING_VALUE_1()) + " " + item.getCONFERENCE_REGISTRATION_PACKAGE_OFFERING_VALUE_CURRENCY_UOM_NAME_1()));
            }
            if (!TextUtils.isEmpty(item.getCONFERENCE_REGISTRATION_PACKAGE_OFFERING_NAME_2())) {
                list.add(new DescriptionPackage(item.getCONFERENCE_REGISTRATION_PACKAGE_OFFERING_ID_2(), item.getCONFERENCE_REGISTRATION_PACKAGE_OFFERING_NAME_2() + "\n" + Utils.formatPrice(item.getCONFERENCE_REGISTRATION_PACKAGE_OFFERING_VALUE_2()) + " " + item.getCONFERENCE_REGISTRATION_PACKAGE_OFFERING_VALUE_CURRENCY_UOM_NAME_2()));
            }
            if (!TextUtils.isEmpty(item.getCONFERENCE_REGISTRATION_PACKAGE_OFFERING_NAME_3())) {
                list.add(new DescriptionPackage(item.getCONFERENCE_REGISTRATION_PACKAGE_OFFERING_ID_3(), item.getCONFERENCE_REGISTRATION_PACKAGE_OFFERING_NAME_3() + "\n" + Utils.formatPrice(item.getCONFERENCE_REGISTRATION_PACKAGE_OFFERING_VALUE_3()) + " " + item.getCONFERENCE_REGISTRATION_PACKAGE_OFFERING_VALUE_CURRENCY_UOM_NAME_3()));
            }
            if (!TextUtils.isEmpty(item.getCONFERENCE_REGISTRATION_PACKAGE_OFFERING_NAME_4())) {
                list.add(new DescriptionPackage(item.getCONFERENCE_REGISTRATION_PACKAGE_OFFERING_ID_4(), item.getCONFERENCE_REGISTRATION_PACKAGE_OFFERING_NAME_4() + "\n" + Utils.formatPrice(item.getCONFERENCE_REGISTRATION_PACKAGE_OFFERING_VALUE_4()) + " " + item.getCONFERENCE_REGISTRATION_PACKAGE_OFFERING_VALUE_CURRENCY_UOM_NAME_4()));
            }
            if (!TextUtils.isEmpty(item.getCONFERENCE_REGISTRATION_PACKAGE_OFFERING_NAME_5())) {
                list.add(new DescriptionPackage(item.getCONFERENCE_REGISTRATION_PACKAGE_OFFERING_ID_5(), item.getCONFERENCE_REGISTRATION_PACKAGE_OFFERING_NAME_5() + "\n" + Utils.formatPrice(item.getCONFERENCE_REGISTRATION_PACKAGE_OFFERING_VALUE_5()) + " " + item.getCONFERENCE_REGISTRATION_PACKAGE_OFFERING_VALUE_CURRENCY_UOM_NAME_5()));
            }
            if (!TextUtils.isEmpty(item.getCONFERENCE_REGISTRATION_PACKAGE_OFFERING_NAME_6())) {
                list.add(new DescriptionPackage(item.getCONFERENCE_REGISTRATION_PACKAGE_OFFERING_ID_6(), item.getCONFERENCE_REGISTRATION_PACKAGE_OFFERING_NAME_6() + "\n" + Utils.formatPrice(item.getCONFERENCE_REGISTRATION_PACKAGE_OFFERING_VALUE_6()) + " " + item.getCONFERENCE_REGISTRATION_PACKAGE_OFFERING_VALUE_CURRENCY_UOM_NAME_6()));
            }
            if (!TextUtils.isEmpty(item.getCONFERENCE_REGISTRATION_PACKAGE_OFFERING_NAME_7())) {
                list.add(new DescriptionPackage(item.getCONFERENCE_REGISTRATION_PACKAGE_OFFERING_ID_7(), item.getCONFERENCE_REGISTRATION_PACKAGE_OFFERING_NAME_7() + "\n" + Utils.formatPrice(item.getCONFERENCE_REGISTRATION_PACKAGE_OFFERING_VALUE_7()) + " " + item.getCONFERENCE_REGISTRATION_PACKAGE_OFFERING_VALUE_CURRENCY_UOM_NAME_7()));
            }
            if (!TextUtils.isEmpty(item.getCONFERENCE_REGISTRATION_PACKAGE_OFFERING_NAME_8())) {
                list.add(new DescriptionPackage(item.getCONFERENCE_REGISTRATION_PACKAGE_OFFERING_ID_8(), item.getCONFERENCE_REGISTRATION_PACKAGE_OFFERING_NAME_8() + "\n" + Utils.formatPrice(item.getCONFERENCE_REGISTRATION_PACKAGE_OFFERING_VALUE_8()) + " " + item.getCONFERENCE_REGISTRATION_PACKAGE_OFFERING_VALUE_CURRENCY_UOM_NAME_8()));
            }
            if (!TextUtils.isEmpty(item.getCONFERENCE_REGISTRATION_PACKAGE_OFFERING_NAME_9())) {
                list.add(new DescriptionPackage(item.getCONFERENCE_REGISTRATION_PACKAGE_OFFERING_ID_9(), item.getCONFERENCE_REGISTRATION_PACKAGE_OFFERING_NAME_9() + "\n" + Utils.formatPrice(item.getCONFERENCE_REGISTRATION_PACKAGE_OFFERING_VALUE_9()) + " " + item.getCONFERENCE_REGISTRATION_PACKAGE_OFFERING_VALUE_CURRENCY_UOM_NAME_9()));
            }
            if (!TextUtils.isEmpty(item.getCONFERENCE_REGISTRATION_PACKAGE_OFFERING_NAME_10())) {
                list.add(new DescriptionPackage(item.getCONFERENCE_REGISTRATION_PACKAGE_OFFERING_ID_10(), item.getCONFERENCE_REGISTRATION_PACKAGE_OFFERING_NAME_10() + "\n" + Utils.formatPrice(item.getCONFERENCE_REGISTRATION_PACKAGE_OFFERING_VALUE_10()) + " " + item.getCONFERENCE_REGISTRATION_PACKAGE_OFFERING_VALUE_CURRENCY_UOM_NAME_10()));
            }
            return list;
        }
    }
}
