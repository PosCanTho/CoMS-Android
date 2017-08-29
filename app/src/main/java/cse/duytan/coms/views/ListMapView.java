package cse.duytan.coms.views;

import java.util.ArrayList;

import cse.duytan.coms.models.ConferenceMap;

/**
 * Created by Pham Van Thien on 8/26/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public interface ListMapView {
    void success(ArrayList<ConferenceMap> listMap);
    void error(String msg);
    void empty();
}
