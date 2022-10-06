package model;

public class HoKhau {
    private int sttHoKhau;
    private int maThanhVien;
    private String tenChuHo;
    private int soLuongThanhVien;
    private String ngayLapHoKhau;
    private String diaChiNha;

    public HoKhau() {
    }

    public HoKhau(int sttHoKhau, int maThanhVien, String tenChuHo,
                  int soLuongThanhVien, String ngayLapHoKhau, String diaChiNha) {
        this.sttHoKhau = sttHoKhau;
        this.maThanhVien = maThanhVien;
        this.tenChuHo = tenChuHo;
        this.soLuongThanhVien = soLuongThanhVien;
        this.ngayLapHoKhau = ngayLapHoKhau;
        this.diaChiNha = diaChiNha;
    }

    public HoKhau(int maThanhVien, String tenChuHo, int soLuongThanhVien,
                  String ngayLapHoKhau, String diaChiNha) {
        this.maThanhVien = maThanhVien;
        this.tenChuHo = tenChuHo;
        this.soLuongThanhVien = soLuongThanhVien;
        this.ngayLapHoKhau = ngayLapHoKhau;
        this.diaChiNha = diaChiNha;
    }

    public int getSttHoKhau() {
        return sttHoKhau;
    }

    public void setSttHoKhau(int sttHoKhau) {
        this.sttHoKhau = sttHoKhau;
    }

    public int getMaThanhVien() {
        return maThanhVien;
    }

    public void setMaThanhVien(int maThanhVien) {
        this.maThanhVien = maThanhVien;
    }

    public String getTenChuHo() {
        return tenChuHo;
    }

    public void setTenChuHo(String tenChuHo) {
        this.tenChuHo = tenChuHo;
    }

    public int getSoLuongThanhVien() {
        return soLuongThanhVien;
    }

    public void setSoLuongThanhVien(int soLuongThanhVien) {
        this.soLuongThanhVien = soLuongThanhVien;
    }

    public String getNgayLapHoKhau() {
        return ngayLapHoKhau;
    }

    public void setNgayLapHoKhau(String ngayLapHoKhau) {
        this.ngayLapHoKhau = ngayLapHoKhau;
    }

    public String getDiaChiNha() {
        return diaChiNha;
    }

    public void setDiaChiNha(String diaChiNha) {
        this.diaChiNha = diaChiNha;
    }
}
