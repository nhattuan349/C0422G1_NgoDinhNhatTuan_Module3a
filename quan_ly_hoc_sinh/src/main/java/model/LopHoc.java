package model;

public class LopHoc {
    private int maLopHoc;
    private String tenLopHoc;

    public LopHoc() {
    }

    public LopHoc(int maLopHoc, String tenLopHoc) {
        this.maLopHoc = maLopHoc;
        this.tenLopHoc = tenLopHoc;
    }

    public int getMaLopHoc() {
        return maLopHoc;
    }

    public void setMaLopHoc(int maLopHoc) {
        this.maLopHoc = maLopHoc;
    }

    public String getTenLopHoc() {
        return tenLopHoc;
    }

    public void setTenLopHoc(String tenLopHoc) {
        this.tenLopHoc = tenLopHoc;
    }
}
