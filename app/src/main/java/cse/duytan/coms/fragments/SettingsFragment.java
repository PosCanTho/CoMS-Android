package cse.duytan.coms.fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cse.duytan.coms.R;
import cse.duytan.coms.helpers.Prefs;

/**
 * Created by lehoangdung on 18/06/2017.
 */

public class SettingsFragment extends Fragment implements SwitchCompat.OnCheckedChangeListener {
    @BindView(R.id.swFreshAppData)
    SwitchCompat swFreshAppData;
    @BindView(R.id.swNotification)
    SwitchCompat swNotification;
    @BindView(R.id.swEnglish)
    SwitchCompat swEnglish;
    Unbinder unbinder;
    private View v;
    private Context context;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.settings_fragment, container, false);
        context = getActivity();
        unbinder = ButterKnife.bind(this, v);
        initUI();
        return v;
    }

    private void initUI() {
        getActivity().setTitle(R.string.title_settings);

        swFreshAppData.setOnCheckedChangeListener(this);
        swNotification.setOnCheckedChangeListener(this);
        swEnglish.setOnCheckedChangeListener(this);

        swFreshAppData.setChecked(Prefs.getFreshAppData());
        swNotification.setChecked(Prefs.getNotification());
        swEnglish.setChecked(Prefs.getEnglish());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        int id = buttonView.getId();
        switch (id) {
            case R.id.swFreshAppData:
                Prefs.setFreshAppData(isChecked);
                break;
            case R.id.swNotification:
                Prefs.setNotification(isChecked);
                break;
            case R.id.swEnglish:
                Prefs.setEnglish(isChecked);
                break;
            default:
                break;
        }
    }
}
