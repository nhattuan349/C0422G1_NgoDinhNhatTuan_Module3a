package model;

public class ThanhVien {
    private int maThanhVien;
    private String tenThanhVien;

    public ThanhVien() {
    }

    public ThanhVien(int maThanhVien, String tenThanhVien) {
        this.maThanhVien = maThanhVien;
        this.tenThanhVien = tenThanhVien;
    }

    public int getMaThanhVien() {
        return maThanhVien;
    }

    public void setMaThanhVien(int maThanhVien) {
        this.maThanhVien = maThanhVien;
    }

    public String getTenThanhVien() {
        return tenThanhVien;
    }

    public void setTenThanhVien(String tenThanhVien) {
        this.tenThanhVien = tenThanhVien;
    }
}
