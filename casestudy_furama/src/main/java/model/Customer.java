package model;

public class Customer {
    private int maKhachHang;
    private int maLoaiKhachHang;
    private String hoTen;
    private String ngaySinh;
    private int gioiTinh;
    private String soCMND;
    private int soDienThoai;
    private String email;
    private String diaChi;
    private int statusDelete;

    public Customer() {
    }

    public Customer(int maKhachHang, int maLoaiKhachHang, String hoTen, String ngaySinh, int gioiTinh,
                    String soCMND, int soDienThoai, String email, String diaChi, int statusDelete) {
        this.maKhachHang = maKhachHang;
        this.maLoaiKhachHang = maLoaiKhachHang;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.soCMND = soCMND;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diaChi = diaChi;
        this.statusDelete = statusDelete;
    }

    public Customer(int maLoaiKhachHang, String hoTen, String ngaySinh, int gioiTinh, String soCMND,
                    int soDienThoai, String email, String diaChi) {
        this.maLoaiKhachHang = maLoaiKhachHang;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.soCMND = soCMND;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diaChi = diaChi;
    }

    public Customer(int maKhachHang, int maLoaiKhachHang, String hoTen, String ngaySinh, int gioiTinh,
                    String soCMND, int soDienThoai, String email, String diaChi) {
        this.maKhachHang = maKhachHang;
        this.maLoaiKhachHang = maLoaiKhachHang;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.soCMND = soCMND;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diaChi = diaChi;
    }

    public Customer(int maLoaiKhachHang, String hoTen, String ngaySinh, int gioiTinh, String soCMND,
                    int soDienThoai, String email, String diaChi, int statusDelete) {
        this.maLoaiKhachHang = maLoaiKhachHang;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.soCMND = soCMND;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diaChi = diaChi;
        this.statusDelete = statusDelete;
    }

    public int getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public int getMaLoaiKhachHang() {
        return maLoaiKhachHang;
    }

    public void setMaLoaiKhachHang(int maLoaiKhachHang) {
        this.maLoaiKhachHang = maLoaiKhachHang;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public int getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(int soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getStatusDelete() {
        return statusDelete;
    }

    public void setStatusDelete(int statusDelete) {
        this.statusDelete = statusDelete;
    }
}


