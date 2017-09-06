package cse.duytan.coms.views;

import java.util.ArrayList;

import cse.duytan.coms.models.PresentationSlot;

/**
 * Created by iMac on 8/17/17.
 */

public interface PresentationSlotView {
    void listPresentationSlot(ArrayList<PresentationSlot> listPresentationSlot);
    void error(String msg);
}
