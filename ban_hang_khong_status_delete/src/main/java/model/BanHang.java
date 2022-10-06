package model;

public class BanHang {
    private int maKhachHang;
    private String tenKhachHang;
    private int soDienThoai;
    private String thoiGianGiaoDich;
    private int maKhuyenMai;


    public BanHang() {
    }

    public BanHang(int maKhachHang, String tenKhachHang, int soDienThoai, String thoiGianGiaoDich,
                   int maKhuyenMai) {
        this.maKhachHang = maKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.soDienThoai = soDienThoai;
        this.thoiGianGiaoDich = thoiGianGiaoDich;
        this.maKhuyenMai = maKhuyenMai;
    }

    public BanHang(String tenKhachHang, int soDienThoai, String thoiGianGiaoDich, int maKhuyenMai) {
        this.tenKhachHang = tenKhachHang;
        this.soDienThoai = soDienThoai;
        this.thoiGianGiaoDich = thoiGianGiaoDich;
        this.maKhuyenMai = maKhuyenMai;
    }

    public int getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public int getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(int soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getThoiGianGiaoDich() {
        return thoiGianGiaoDich;
    }

    public void setThoiGianGiaoDich(String thoiGianGiaoDich) {
        this.thoiGianGiaoDich
                = thoiGianGiaoDich;
    }

    public int getMaKhuyenMai() {
        return maKhuyenMai;
    }

    public void setMaKhuyenMai(int maKhuyenMai) {
        this.maKhuyenMai = maKhuyenMai;
    }
}
