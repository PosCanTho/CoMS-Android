package cse.duytan.coms.models;

/**
 * Created by lehoangdung on 20/06/2017.
 */

public class Abstract {
    private String thongtin;
    private int trangthai;//0: từ chối, 1: đã duyệt, 2: chờ duyệt, 3: đang soạn
    private String ngay;
    private boolean visible_row = true;
    private boolean visible_func = false;// danh sách chức năng trên dòng abstract

    public Abstract() {
    }

    public Abstract(String thongtin, int trangthai, String ngay) {
        this.thongtin = thongtin;
        this.trangthai = trangthai;
        this.ngay = ngay;
    }

    public String getThongtin() {
        return thongtin;
    }

    public void setThongtin(String thongtin) {
        this.thongtin = thongtin;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
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
