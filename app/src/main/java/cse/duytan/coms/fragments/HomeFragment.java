package cse.duytan.coms.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cse.duytan.coms.R;
import cse.duytan.coms.activities.MainActivity;

/**
 * Created by lehoangdung on 16/06/2017.
 */

public class HomeFragment extends Fragment {
    public static final int LAYOUT_HOME = 0;
    public static final int LAYOUT_ABSTRACT = 1;
    public static final int LAYOUT_LIST_ABSTRACT = 2;
    private int currentLayout = LAYOUT_HOME;

    // get current layout
    public int getCurrentLayout() {
        return currentLayout;
    }
    // set current layout
    public void setCurrentLayout(int currentLayout) {
        this.currentLayout = currentLayout;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

    public void switchLayout(int id) {
        switch (id) {
            case LAYOUT_HOME:
                setCurrentLayout(LAYOUT_HOME);
                ((MainActivity) getActivity()).setShadowToolbar(0);
                ((MainActivity) getActivity()).hideBackArrow();
                break;
            case LAYOUT_LIST_ABSTRACT:
                setCurrentLayout(LAYOUT_LIST_ABSTRACT);
                ((MainActivity) getActivity()).setShadowToolbar(0);
                ((MainActivity) getActivity()).displayBackArrow();
                break;

            default:
                break;
        }

    }
}
