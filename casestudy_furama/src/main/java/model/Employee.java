package model;

public class Employee {
    private int maNhanVien;
    private String hoTen;
    private String ngaySinh;
    private String soCMND;
    private Double luong;
    private String soDienThoai;
    private String email;
    private String diachi;
    private int maVitri;
    private int maTrinhDo;
    private int maBoPhan;
    private int statusDelete;

    public Employee() {
    }

    public Employee(int maNhanVien, String hoTen, String ngaySinh, String soCMND, Double luong, String soDienThoai,
                    String email, String diachi, int maVitri, int maTrinhDo, int maBoPhan, int statusDelete) {
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.soCMND = soCMND;
        this.luong = luong;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diachi = diachi;
        this.maVitri = maVitri;
        this.maTrinhDo = maTrinhDo;
        this.maBoPhan = maBoPhan;
        this.statusDelete = statusDelete;
    }

    public Employee(String hoTen, String ngaySinh, String soCMND, Double luong, String soDienThoai, String email,
                    String diachi, int maVitri, int maTrinhDo, int maBoPhan, int statusDelete) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.soCMND = soCMND;
        this.luong = luong;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diachi = diachi;
        this.maVitri = maVitri;
        this.maTrinhDo = maTrinhDo;
        this.maBoPhan = maBoPhan;
        this.statusDelete = statusDelete;
    }

    public Employee(String hoTen, String ngaySinh, String soCMND, Double luong, String soDienThoai, String email,
                    String diachi, int maVitri, int maTrinhDo, int maBoPhan) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.soCMND = soCMND;
        this.luong = luong;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diachi = diachi;
        this.maVitri = maVitri;
        this.maTrinhDo = maTrinhDo;
        this.maBoPhan = maBoPhan;
    }

    public Employee(int maNhanVien, String hoTen, String ngaySinh, String soCMND, Double luong, String soDienThoai,
                    String email, String diachi, int maVitri, int maTrinhDo, int maBoPhan) {
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.soCMND = soCMND;
        this.luong = luong;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diachi = diachi;
        this.maVitri = maVitri;
        this.maTrinhDo = maTrinhDo;
        this.maBoPhan = maBoPhan;
    }

    public int getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
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

    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public Double getLuong() {
        return luong;
    }

    public void setLuong(Double luong) {
        this.luong = luong;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public int getMaVitri() {
        return maVitri;
    }

    public void setMaVitri(int maVitri) {
        this.maVitri = maVitri;
    }

    public int getMaTrinhDo() {
        return maTrinhDo;
    }

    public void setMaTrinhDo(int maTrinhDo) {
        this.maTrinhDo = maTrinhDo;
    }

    public int getMaBoPhan() {
        return maBoPhan;
    }

    public void setMaBoPhan(int maBoPhan) {
        this.maBoPhan = maBoPhan;
    }

    public int getStatusDelete() {
        return statusDelete;
    }

    public void setStatusDelete(int statusDelete) {
        this.statusDelete = statusDelete;
    }
}
