package thue_xe.model;

public class CountNCC {
    private String TenNCC;
    private int SoLanDK;

    public CountNCC() {
    }

    public CountNCC(String tenNCC, int soLanDK) {
        TenNCC = tenNCC;
        SoLanDK = soLanDK;
    }

    public String getTenNCC() {
        return TenNCC;
    }

    public void setTenNCC(String tenNCC) {
        TenNCC = tenNCC;
    }

    public int getSoLanDK() {
        return SoLanDK;
    }

    public void setSoLanDK(int soLanDK) {
        SoLanDK = soLanDK;
    }

    @Override
    public String toString() {
        return this.getTenNCC() + "       " + this.getSoLanDK();
    }
}
