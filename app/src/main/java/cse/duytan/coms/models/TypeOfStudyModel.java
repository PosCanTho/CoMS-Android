package cse.duytan.coms.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by lehoangdung on 8/30/2017.
 */

public class TypeOfStudyModel implements Serializable {
    @SerializedName("TYPE_OF_STUDY_ID")
    public int TYPE_OF_STUDY_ID;

    @SerializedName("TYPE_OF_STUDY_NAME")
    public String TYPE_OF_STUDY_NAME;

    @SerializedName("TYPE_OF_STUDY_NAME_EN")
    public String TYPE_OF_STUDY_NAME_EN;

    public TypeOfStudyModel() {
    }

    public TypeOfStudyModel(int TYPE_OF_STUDY_ID, String TYPE_OF_STUDY_NAME, String TYPE_OF_STUDY_NAME_EN) {
        this.TYPE_OF_STUDY_ID = TYPE_OF_STUDY_ID;
        this.TYPE_OF_STUDY_NAME = TYPE_OF_STUDY_NAME;
        this.TYPE_OF_STUDY_NAME_EN = TYPE_OF_STUDY_NAME_EN;
    }

    public int getTYPE_OF_STUDY_ID() {
        return TYPE_OF_STUDY_ID;
    }

    public void setTYPE_OF_STUDY_ID(int TYPE_OF_STUDY_ID) {
        this.TYPE_OF_STUDY_ID = TYPE_OF_STUDY_ID;
    }

    public String getTYPE_OF_STUDY_NAME() {
        return TYPE_OF_STUDY_NAME;
    }

    public void setTYPE_OF_STUDY_NAME(String TYPE_OF_STUDY_NAME) {
        this.TYPE_OF_STUDY_NAME = TYPE_OF_STUDY_NAME;
    }

    public String getTYPE_OF_STUDY_NAME_EN() {
        return TYPE_OF_STUDY_NAME_EN;
    }

    public void setTYPE_OF_STUDY_NAME_EN(String TYPE_OF_STUDY_NAME_EN) {
        this.TYPE_OF_STUDY_NAME_EN = TYPE_OF_STUDY_NAME_EN;
    }
}
