package model;

public class BaiHoc {
    private int idBaiHoc;
    private String tieuDe;
    private int maLoaiBaiHoc;
    private int maDoKho;
    private int maModule;
    private int statusDelete;
    private String linkBaiHoc;

    public BaiHoc() {
    }

    public BaiHoc(int idBaiHoc, String tieuDe, int maLoaiBaiHoc, int maDoKho, int maModule, int statusDelete, String linkBaiHoc) {
        this.idBaiHoc = idBaiHoc;
        this.tieuDe = tieuDe;
        this.maLoaiBaiHoc = maLoaiBaiHoc;
        this.maDoKho = maDoKho;
        this.maModule = maModule;
        this.statusDelete = statusDelete;
        this.linkBaiHoc = linkBaiHoc;
    }

    public BaiHoc(String tieuDe, int maLoaiBaiHoc, int maDoKho, int maModule, int statusDelete, String linkBaiHoc) {
        this.tieuDe = tieuDe;
        this.maLoaiBaiHoc = maLoaiBaiHoc;
        this.maDoKho = maDoKho;
        this.maModule = maModule;
        this.statusDelete = statusDelete;
        this.linkBaiHoc = linkBaiHoc;
    }

    public BaiHoc(int idBaiHoc, String tieuDe, int maLoaiBaiHoc, int maDoKho, int maModule, String linkBaiHoc) {
        this.idBaiHoc = idBaiHoc;
        this.tieuDe = tieuDe;
        this.maLoaiBaiHoc = maLoaiBaiHoc;
        this.maDoKho = maDoKho;
        this.maModule = maModule;
        this.linkBaiHoc = linkBaiHoc;
    }

    public int getIdBaiHoc() {
        return idBaiHoc;
    }

    public void setIdBaiHoc(int idBaiHoc) {
        this.idBaiHoc = idBaiHoc;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public int getMaLoaiBaiHoc() {
        return maLoaiBaiHoc;
    }

    public void setMaLoaiBaiHoc(int maLoaiBaiHoc) {
        this.maLoaiBaiHoc = maLoaiBaiHoc;
    }

    public int getMaDoKho() {
        return maDoKho;
    }

    public void setMaDoKho(int maDoKho) {
        this.maDoKho = maDoKho;
    }

    public int getMaModule() {
        return maModule;
    }

    public void setMaModule(int maModule) {
        this.maModule = maModule;
    }

    public int getStatusDelete() {
        return statusDelete;
    }

    public void setStatusDelete(int statusDelete) {
        this.statusDelete = statusDelete;
    }

    public String getLinkBaiHoc() {
        return linkBaiHoc;
    }

    public void setLinkBaiHoc(String linkBaiHoc) {
        this.linkBaiHoc = linkBaiHoc;
    }
}
