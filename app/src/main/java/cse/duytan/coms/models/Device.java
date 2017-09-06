package cse.duytan.coms.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Pham Van Thien on 8/31/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class Device {

    @SerializedName("MANAGE_DEVICE_ID")
    private int MANAGE_DEVICE_ID;
    @SerializedName("PERSON_ID")
    private int PERSON_ID;
    @SerializedName("DEVICE_TOKEN")
    private String DEVICE_TOKEN;
    @SerializedName("CREATE_DATE")
    private String CREATE_DATE;
    @SerializedName("UPDATE_DATE")
    private String UPDATE_DATE;

    public Device() {
    }

    public Device(int MANAGE_DEVICE_ID, int PERSON_ID, String DEVICE_TOKEN, String CREATE_DATE, String UPDATE_DATE) {
        this.MANAGE_DEVICE_ID = MANAGE_DEVICE_ID;
        this.PERSON_ID = PERSON_ID;
        this.DEVICE_TOKEN = DEVICE_TOKEN;
        this.CREATE_DATE = CREATE_DATE;
        this.UPDATE_DATE = UPDATE_DATE;
    }

    public int getMANAGE_DEVICE_ID() {
        return MANAGE_DEVICE_ID;
    }

    public void setMANAGE_DEVICE_ID(int MANAGE_DEVICE_ID) {
        this.MANAGE_DEVICE_ID = MANAGE_DEVICE_ID;
    }

    public int getPERSON_ID() {
        return PERSON_ID;
    }

    public void setPERSON_ID(int PERSON_ID) {
        this.PERSON_ID = PERSON_ID;
    }

    public String getDEVICE_TOKEN() {
        return DEVICE_TOKEN;
    }

    public void setDEVICE_TOKEN(String DEVICE_TOKEN) {
        this.DEVICE_TOKEN = DEVICE_TOKEN;
    }

    public String getCREATE_DATE() {
        return CREATE_DATE;
    }

    public void setCREATE_DATE(String CREATE_DATE) {
        this.CREATE_DATE = CREATE_DATE;
    }

    public String getUPDATE_DATE() {
        return UPDATE_DATE;
    }

    public void setUPDATE_DATE(String UPDATE_DATE) {
        this.UPDATE_DATE = UPDATE_DATE;
    }
}
