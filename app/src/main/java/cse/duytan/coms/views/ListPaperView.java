package cse.duytan.coms.views;

import java.util.ArrayList;

import cse.duytan.coms.models.PaperText;

/**
 * Created by iMac on 8/15/17.
 */

public interface ListPaperView {
    void listPaper(ArrayList<PaperText> listPaper);
    void error(String msg);
}
