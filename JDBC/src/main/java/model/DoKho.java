package model;

public class DoKho {
    private int maDoKho;
    private String tenDoKho;

    public DoKho() {
    }

    public DoKho(int maDoKho, String tenDoKho) {
        this.maDoKho = maDoKho;
        this.tenDoKho = tenDoKho;
    }

    public int getMaDoKho() {
        return maDoKho;
    }

    public void setMaDoKho(int maDoKho) {
        this.maDoKho = maDoKho;
    }

    public String getTenDoKho() {
        return tenDoKho;
    }

    public void setTenDoKho(String tenDoKho) {
        this.tenDoKho = tenDoKho;
    }
}
