package cse.duytan.coms.fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cse.duytan.coms.R;

/**
 * Created by lehoangdung on 18/06/2017.
 */

public class SettingsFragment extends Fragment {
    private View v;
    private Context context;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.settings_fragment, container, false);
        context = getActivity();
        initUI();
        return v;
    }

    private void initUI(){
        getActivity().setTitle(R.string.title_settings);
    }
}
