package cse.duytan.coms.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by lehoangdung on 8/24/2017.
 */

public class ResultBoolean implements Serializable {
    @SerializedName("result")
    public boolean result;

    public ResultBoolean(){
    }

    public ResultBoolean(boolean result){
        this.result = result;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
