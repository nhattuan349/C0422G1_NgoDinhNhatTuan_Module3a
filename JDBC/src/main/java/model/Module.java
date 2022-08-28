package model;

public class Module {
    private int maModule;
    private String tenModule;

    public Module() {
    }

    public Module(int maModule, String tenModule) {
        this.maModule = maModule;
        this.tenModule = tenModule;
    }

    public int getMaModule() {
        return maModule;
    }

    public void setMaModule(int maModule) {
        this.maModule = maModule;
    }

    public String getTenModule() {
        return tenModule;
    }

    public void setTenModule(String tenModule) {
        this.tenModule = tenModule;
    }
}
