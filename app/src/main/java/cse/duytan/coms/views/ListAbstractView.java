package cse.duytan.coms.views;

import java.util.ArrayList;

import cse.duytan.coms.models.PaperAbstract;

/**
 * Created by iMac on 8/21/17.
 */

public interface ListAbstractView {
    void listAbstract(ArrayList<PaperAbstract> listAbstract);
    void error(String msg);
}
