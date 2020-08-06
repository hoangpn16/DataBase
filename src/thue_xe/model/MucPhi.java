package thue_xe.model;

public class MucPhi {
    private String MaMP;
    private String DonGia;
    private String MoTa;

    public MucPhi() {
    }

    public MucPhi(String maMP, String donGia, String moTa) {
        MaMP = maMP;
        DonGia = donGia;
        MoTa = moTa;
    }

    public String getMaMP() {
        return MaMP;
    }

    public void setMaMP(String maMP) {
        MaMP = maMP;
    }

    public String getDonGia() {
        return DonGia;
    }

    public void setDonGia(String donGia) {
        DonGia = donGia;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String moTa) {
        MoTa = moTa;
    }
}
