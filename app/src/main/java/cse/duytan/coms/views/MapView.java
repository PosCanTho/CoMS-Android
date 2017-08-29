package cse.duytan.coms.views;

import java.util.ArrayList;

import cse.duytan.coms.models.ConferenceLocation;

/**
 * Created by Pham Van Thien on 8/28/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public interface MapView {
    void success(ArrayList<ConferenceLocation> listLocation);
    void error(String msg);
    void empty();
}
