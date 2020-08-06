package thue_xe.model;

public class NhaCungCap {
    private String MaNCC;
    private String TenNCC;
    private String DiaChi;
    private String SoDT;
    private String MaSoThue;

    public NhaCungCap() {
    }

    public NhaCungCap(String maNCC, String tenNCC, String diaChi, String soDT, String maSoThue) {
        MaNCC = maNCC;
        TenNCC = tenNCC;
        DiaChi = diaChi;
        SoDT = soDT;
        MaSoThue = maSoThue;
    }

    public String getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(String maNCC) {
        MaNCC = maNCC;
    }

    public String getTenNCC() {
        return TenNCC;
    }

    public void setTenNCC(String tenNCC) {
        TenNCC = tenNCC;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getSoDT() {
        return SoDT;
    }

    public void setSoDT(String soDT) {
        SoDT = soDT;
    }

    public String getMaSoThue() {
        return MaSoThue;
    }

    public void setMaSoThue(String maSoThue) {
        MaSoThue = maSoThue;
    }

    @Override
    public String toString() {
        return "MaNCC:" + this.getMaNCC() + "||TenNCC:" + this.getTenNCC() + "||DiaChi:" + this.getDiaChi() + "||SoDT" + this.getSoDT() + "||MaSoThue" + this.getMaSoThue();
    }
}
