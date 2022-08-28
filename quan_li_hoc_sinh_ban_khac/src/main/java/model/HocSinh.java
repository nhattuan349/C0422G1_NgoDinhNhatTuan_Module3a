package model;

public class HocSinh {
    private int idHocSinh;
    private String tenHocSinh;
    private int tuoiHocSinh;
    private String diaChi;
    private int maLopHoc;
    private int statusDelete;

    public HocSinh() {
    }

    public HocSinh(int idHocSinh, String tenHocSinh, int tuoiHocSinh, String diaChi, int maLopHoc, int statusDelete) {
        this.idHocSinh = idHocSinh;
        this.tenHocSinh = tenHocSinh;
        this.tuoiHocSinh = tuoiHocSinh;
        this.diaChi = diaChi;
        this.maLopHoc = maLopHoc;
        this.statusDelete = statusDelete;
    }

    public HocSinh(String tenHocSinh, int tuoiHocSinh, String diaChi, int maLopHoc, int statusDelete) {
        this.tenHocSinh = tenHocSinh;
        this.tuoiHocSinh = tuoiHocSinh;
        this.diaChi = diaChi;
        this.maLopHoc = maLopHoc;
        this.statusDelete = statusDelete;
    }

    public HocSinh(int idHocSinh, String tenHocSinh, int tuoiHocSinh, String diaChi, int maLopHoc) {
        this.idHocSinh = idHocSinh;
        this.tenHocSinh = tenHocSinh;
        this.tuoiHocSinh = tuoiHocSinh;
        this.diaChi = diaChi;
        this.maLopHoc = maLopHoc;
    }

    public HocSinh(String tenHocSinh, int tuoiHocSinh, String diaChi, int maLopHoc) {
        this.tenHocSinh = tenHocSinh;
        this.tuoiHocSinh = tuoiHocSinh;
        this.diaChi = diaChi;
        this.maLopHoc = maLopHoc;
    }

    public int getIdHocSinh() {
        return idHocSinh;
    }

    public void setIdHocSinh(int idHocSinh) {
        this.idHocSinh = idHocSinh;
    }

    public String getTenHocSinh() {
        return tenHocSinh;
    }

    public void setTenHocSinh(String tenHocSinh) {
        this.tenHocSinh = tenHocSinh;
    }

    public int getTuoiHocSinh() {
        return tuoiHocSinh;
    }

    public void setTuoiHocSinh(int tuoiHocSinh) {
        this.tuoiHocSinh = tuoiHocSinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getMaLopHoc() {
        return maLopHoc;
    }

    public void setMaLopHoc(int maLopHoc) {
        this.maLopHoc = maLopHoc;
    }

    public int getStatusDelete() {
        return statusDelete;
    }

    public void setStatusDelete(int statusDelete) {
        this.statusDelete = statusDelete;
    }
}
