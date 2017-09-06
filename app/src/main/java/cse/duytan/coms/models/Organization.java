package cse.duytan.coms.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by iMac on 8/30/17.
 */

public class Organization {
    @SerializedName("ORGANIZATION_ID")
    public int ORGANIZATION_ID;
    @SerializedName("ORGANIZATION_CODE")
    public String ORGANIZATION_CODE;
    @SerializedName("ORGANIZATION_NAME")
    public String ORGANIZATION_NAME;
    @SerializedName("ORGANIZATION_NAME_EN")
    public String ORGANIZATION_NAME_EN;
    @SerializedName("ADDRESS")
    public String ADDRESS;
    @SerializedName("WARD")
    public String WARD;
    @SerializedName("DISTRICT")
    public String DISTRICT;
    @SerializedName("CITY")
    public String CITY;
    @SerializedName("STATE")
    public String STATE;
    @SerializedName("COUNTRY")
    public String COUNTRY;
    @SerializedName("ORGANIZATION_TELEPHONE")
    public String ORGANIZATION_TELEPHONE;
    @SerializedName("ORGANIZATION_FAX")
    public String ORGANIZATION_FAX;
    @SerializedName("ORGANIZATION_EMAIL")
    public String ORGANIZATION_EMAIL;
    @SerializedName("ORGANIZATION_WEBSITE")
    public String ORGANIZATION_WEBSITE;
    @SerializedName("ZIPCODE")
    public String ZIPCODE;
    @SerializedName("POSTAL_CODE")
    public String POSTAL_CODE;
    @SerializedName("DESCRIPTION")
    public String DESCRIPTION;
    @SerializedName("DESCRIPTION_EN")
    public String DESCRIPTION_EN;
    @SerializedName("ESTABLISHED_DATE")
    public String ESTABLISHED_DATE;
    @SerializedName("ESTABLISHMENT_DOCUMENT_ID")
    public String ESTABLISHMENT_DOCUMENT_ID;
    @SerializedName("ORGANIZATION_LOGO")
    public String ORGANIZATION_LOGO;
    @SerializedName("ORGANIZATION_LOGO_FILE")
    public String ORGANIZATION_LOGO_FILE;
    @SerializedName("ROOT_ORGANIZATION_ID")
    public String ROOT_ORGANIZATION_ID;
    @SerializedName("ORGANIZATION_ORDER_NUMBER")
    public int ORGANIZATION_ORDER_NUMBER;
    @SerializedName("DELETED")
    public String DELETED;
    @SerializedName("DELETED_SCRIPT")
    public String DELETED_SCRIPT;

    public Organization() {
    }

    public Organization(int ORGANIZATION_ID, String ORGANIZATION_CODE, String ORGANIZATION_NAME, String ORGANIZATION_NAME_EN, String ADDRESS, String WARD, String DISTRICT, String CITY, String STATE, String COUNTRY, String ORGANIZATION_TELEPHONE, String ORGANIZATION_FAX, String ORGANIZATION_EMAIL, String ORGANIZATION_WEBSITE, String ZIPCODE, String POSTAL_CODE, String DESCRIPTION, String DESCRIPTION_EN, String ESTABLISHED_DATE, String ESTABLISHMENT_DOCUMENT_ID, String ORGANIZATION_LOGO, String ORGANIZATION_LOGO_FILE, String ROOT_ORGANIZATION_ID, int ORGANIZATION_ORDER_NUMBER, String DELETED, String DELETED_SCRIPT) {
        this.ORGANIZATION_ID = ORGANIZATION_ID;
        this.ORGANIZATION_CODE = ORGANIZATION_CODE;
        this.ORGANIZATION_NAME = ORGANIZATION_NAME;
        this.ORGANIZATION_NAME_EN = ORGANIZATION_NAME_EN;
        this.ADDRESS = ADDRESS;
        this.WARD = WARD;
        this.DISTRICT = DISTRICT;
        this.CITY = CITY;
        this.STATE = STATE;
        this.COUNTRY = COUNTRY;
        this.ORGANIZATION_TELEPHONE = ORGANIZATION_TELEPHONE;
        this.ORGANIZATION_FAX = ORGANIZATION_FAX;
        this.ORGANIZATION_EMAIL = ORGANIZATION_EMAIL;
        this.ORGANIZATION_WEBSITE = ORGANIZATION_WEBSITE;
        this.ZIPCODE = ZIPCODE;
        this.POSTAL_CODE = POSTAL_CODE;
        this.DESCRIPTION = DESCRIPTION;
        this.DESCRIPTION_EN = DESCRIPTION_EN;
        this.ESTABLISHED_DATE = ESTABLISHED_DATE;
        this.ESTABLISHMENT_DOCUMENT_ID = ESTABLISHMENT_DOCUMENT_ID;
        this.ORGANIZATION_LOGO = ORGANIZATION_LOGO;
        this.ORGANIZATION_LOGO_FILE = ORGANIZATION_LOGO_FILE;
        this.ROOT_ORGANIZATION_ID = ROOT_ORGANIZATION_ID;
        this.ORGANIZATION_ORDER_NUMBER = ORGANIZATION_ORDER_NUMBER;
        this.DELETED = DELETED;
        this.DELETED_SCRIPT = DELETED_SCRIPT;
    }

    public int getORGANIZATION_ID() {
        return ORGANIZATION_ID;
    }

    public void setORGANIZATION_ID(int ORGANIZATION_ID) {
        this.ORGANIZATION_ID = ORGANIZATION_ID;
    }

    public String getORGANIZATION_CODE() {
        return ORGANIZATION_CODE;
    }

    public void setORGANIZATION_CODE(String ORGANIZATION_CODE) {
        this.ORGANIZATION_CODE = ORGANIZATION_CODE;
    }

    public String getORGANIZATION_NAME() {
        return ORGANIZATION_NAME;
    }

    public void setORGANIZATION_NAME(String ORGANIZATION_NAME) {
        this.ORGANIZATION_NAME = ORGANIZATION_NAME;
    }

    public String getORGANIZATION_NAME_EN() {
        return ORGANIZATION_NAME_EN;
    }

    public void setORGANIZATION_NAME_EN(String ORGANIZATION_NAME_EN) {
        this.ORGANIZATION_NAME_EN = ORGANIZATION_NAME_EN;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public String getWARD() {
        return WARD;
    }

    public void setWARD(String WARD) {
        this.WARD = WARD;
    }

    public String getDISTRICT() {
        return DISTRICT;
    }

    public void setDISTRICT(String DISTRICT) {
        this.DISTRICT = DISTRICT;
    }

    public String getCITY() {
        return CITY;
    }

    public void setCITY(String CITY) {
        this.CITY = CITY;
    }

    public String getSTATE() {
        return STATE;
    }

    public void setSTATE(String STATE) {
        this.STATE = STATE;
    }

    public String getCOUNTRY() {
        return COUNTRY;
    }

    public void setCOUNTRY(String COUNTRY) {
        this.COUNTRY = COUNTRY;
    }

    public String getORGANIZATION_TELEPHONE() {
        return ORGANIZATION_TELEPHONE;
    }

    public void setORGANIZATION_TELEPHONE(String ORGANIZATION_TELEPHONE) {
        this.ORGANIZATION_TELEPHONE = ORGANIZATION_TELEPHONE;
    }

    public String getORGANIZATION_FAX() {
        return ORGANIZATION_FAX;
    }

    public void setORGANIZATION_FAX(String ORGANIZATION_FAX) {
        this.ORGANIZATION_FAX = ORGANIZATION_FAX;
    }

    public String getORGANIZATION_EMAIL() {
        return ORGANIZATION_EMAIL;
    }

    public void setORGANIZATION_EMAIL(String ORGANIZATION_EMAIL) {
        this.ORGANIZATION_EMAIL = ORGANIZATION_EMAIL;
    }

    public String getORGANIZATION_WEBSITE() {
        return ORGANIZATION_WEBSITE;
    }

    public void setORGANIZATION_WEBSITE(String ORGANIZATION_WEBSITE) {
        this.ORGANIZATION_WEBSITE = ORGANIZATION_WEBSITE;
    }

    public String getZIPCODE() {
        return ZIPCODE;
    }

    public void setZIPCODE(String ZIPCODE) {
        this.ZIPCODE = ZIPCODE;
    }

    public String getPOSTAL_CODE() {
        return POSTAL_CODE;
    }

    public void setPOSTAL_CODE(String POSTAL_CODE) {
        this.POSTAL_CODE = POSTAL_CODE;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public String getDESCRIPTION_EN() {
        return DESCRIPTION_EN;
    }

    public void setDESCRIPTION_EN(String DESCRIPTION_EN) {
        this.DESCRIPTION_EN = DESCRIPTION_EN;
    }

    public String getESTABLISHED_DATE() {
        return ESTABLISHED_DATE;
    }

    public void setESTABLISHED_DATE(String ESTABLISHED_DATE) {
        this.ESTABLISHED_DATE = ESTABLISHED_DATE;
    }

    public String getESTABLISHMENT_DOCUMENT_ID() {
        return ESTABLISHMENT_DOCUMENT_ID;
    }

    public void setESTABLISHMENT_DOCUMENT_ID(String ESTABLISHMENT_DOCUMENT_ID) {
        this.ESTABLISHMENT_DOCUMENT_ID = ESTABLISHMENT_DOCUMENT_ID;
    }

    public String getORGANIZATION_LOGO() {
        return ORGANIZATION_LOGO;
    }

    public void setORGANIZATION_LOGO(String ORGANIZATION_LOGO) {
        this.ORGANIZATION_LOGO = ORGANIZATION_LOGO;
    }

    public String getORGANIZATION_LOGO_FILE() {
        return ORGANIZATION_LOGO_FILE;
    }

    public void setORGANIZATION_LOGO_FILE(String ORGANIZATION_LOGO_FILE) {
        this.ORGANIZATION_LOGO_FILE = ORGANIZATION_LOGO_FILE;
    }

    public String getROOT_ORGANIZATION_ID() {
        return ROOT_ORGANIZATION_ID;
    }

    public void setROOT_ORGANIZATION_ID(String ROOT_ORGANIZATION_ID) {
        this.ROOT_ORGANIZATION_ID = ROOT_ORGANIZATION_ID;
    }

    public int getORGANIZATION_ORDER_NUMBER() {
        return ORGANIZATION_ORDER_NUMBER;
    }

    public void setORGANIZATION_ORDER_NUMBER(int ORGANIZATION_ORDER_NUMBER) {
        this.ORGANIZATION_ORDER_NUMBER = ORGANIZATION_ORDER_NUMBER;
    }

    public String getDELETED() {
        return DELETED;
    }

    public void setDELETED(String DELETED) {
        this.DELETED = DELETED;
    }

    public String getDELETED_SCRIPT() {
        return DELETED_SCRIPT;
    }

    public void setDELETED_SCRIPT(String DELETED_SCRIPT) {
        this.DELETED_SCRIPT = DELETED_SCRIPT;
    }
}
