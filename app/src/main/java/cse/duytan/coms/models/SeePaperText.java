package cse.duytan.coms.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by lehoangdung on 9/19/2017.
 */

public class SeePaperText implements Serializable {

    @SerializedName("PAPER_TEXT_TITLE")
    public String PAPER_TEXT_TITLE;
    @SerializedName("PAPER_TEXT_TITLE_EN")
    public String PAPER_TEXT_TITLE_EN;

    public SeePaperText() {
    }

    public SeePaperText(String PAPER_TEXT_TITLE, String PAPER_TEXT_TITLE_EN) {
        this.PAPER_TEXT_TITLE = PAPER_TEXT_TITLE;
        this.PAPER_TEXT_TITLE_EN = PAPER_TEXT_TITLE_EN;
    }

    public String getPAPER_TEXT_TITLE() {
        return PAPER_TEXT_TITLE;
    }

    public void setPAPER_TEXT_TITLE(String PAPER_TEXT_TITLE) {
        this.PAPER_TEXT_TITLE = PAPER_TEXT_TITLE;
    }

    public String getPAPER_TEXT_TITLE_EN() {
        return PAPER_TEXT_TITLE_EN;
    }

    public void setPAPER_TEXT_TITLE_EN(String PAPER_TEXT_TITLE_EN) {
        this.PAPER_TEXT_TITLE_EN = PAPER_TEXT_TITLE_EN;
    }
}
