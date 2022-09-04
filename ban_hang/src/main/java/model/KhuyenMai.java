package model;

public class KhuyenMai {
    private int maKhuyenMai;
    private int tenKhuyenMai;

    public KhuyenMai() {
    }

    public KhuyenMai(int maKhuyenMai, int tenKhuyenMai) {
        this.maKhuyenMai = maKhuyenMai;
        this.tenKhuyenMai = tenKhuyenMai;
    }

    public int getMaKhuyenMai() {
        return maKhuyenMai;
    }

    public void setMaKhuyenMai(int maKhuyenMai) {
        this.maKhuyenMai = maKhuyenMai;
    }

    public int getTenKhuyenMai() {
        return tenKhuyenMai;
    }

    public void setTenKhuyenMai(int tenKhuyenMai) {
        this.tenKhuyenMai = tenKhuyenMai;
    }
}
