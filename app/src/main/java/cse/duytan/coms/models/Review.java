package cse.duytan.coms.models;

import java.io.Serializable;

/**
 * Created by DungTrungCut on 7/7/2017.
 */

public class Review implements Serializable {
    private String name;
    private int imgTrangthai;//0: chưa đánh giá, 1: phản hồi, 2: từ chối, Chấp nhận
    private String time;
    private String infomation;
    private boolean visible_row = true;
    private boolean visible_func = false;// danh sách chức năng trên dòng abstract
    private int idperson;
    private int idpaper;

    public Review() {
    }

    public Review(String name, int imgTrangthai, String time, String infomation, int idperson, int idpaper) {
        this.name = name;
        this.imgTrangthai = imgTrangthai;
        this.time = time;
        this.infomation = infomation;
        this.idperson = idperson;
        this.idpaper = idpaper;
    }

    public int getIdpaper() {
        return idpaper;
    }

    public void setIdpaper(int idpaper) {
        this.idpaper = idpaper;
    }

    public int getIdperson() {
        return idperson;
    }

    public void setIdperson(int idperson) {
        this.idperson = idperson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImgTrangthai() {
        return imgTrangthai;
    }

    public void setImgTrangthai(int imgTrangthai) {
        this.imgTrangthai = imgTrangthai;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getInfomation() {
        return infomation;
    }

    public void setInfomation(String infomation) {
        this.infomation = infomation;
    }

    public boolean isVisible_row() {
        return visible_row;
    }

    public void setVisible_row(boolean visible_row) {
        this.visible_row = visible_row;
    }

    public boolean isVisible_func() {
        return visible_func;
    }

    public void setVisible_func(boolean visible_func) {
        this.visible_func = visible_func;
    }
}
