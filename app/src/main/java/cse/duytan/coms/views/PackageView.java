package cse.duytan.coms.views;

import java.util.ArrayList;

import cse.duytan.coms.models.Package;

/**
 * Created by Pham Van Thien on 8/15/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public interface PackageView {
    void success(ArrayList<Package> listPackage);
    void error(String msg);
    void empty();
}
