package thue_xe.model;

public class DangKyCungCap {
    private String MaDKCC;
    private String DayStart;
    private String DayEnd;
    private int SoLuongXeDK;
    private String MaNhaCC;
    private String MaLoaiDV;
    private String DongXe;
    private String MaMP;

    public DangKyCungCap() {
    }

    public DangKyCungCap(String maDKCC, String dayStart, String dayEnd, int soLuongXeDK, String maNhaCC, String maLoaiDV, String dongXe, String maMP) {
        MaDKCC = maDKCC;
        DayStart = dayStart;
        DayEnd = dayEnd;
        SoLuongXeDK = soLuongXeDK;
        MaNhaCC = maNhaCC;
        MaLoaiDV = maLoaiDV;
        DongXe = dongXe;
        MaMP = maMP;
    }

    public String getMaDKCC() {
        return MaDKCC;
    }

    public void setMaDKCC(String maDKCC) {
        MaDKCC = maDKCC;
    }

    public String getDayStart() {
        return DayStart;
    }

    public void setDayStart(String dayStart) {
        DayStart = dayStart;
    }

    public String getDayEnd() {
        return DayEnd;
    }

    public void setDayEnd(String dayEnd) {
        DayEnd = dayEnd;
    }

    public int getSoLuongXeDK() {
        return SoLuongXeDK;
    }

    public void setSoLuongXeDK(int soLuongXeDK) {
        SoLuongXeDK = soLuongXeDK;
    }

    public String getMaNhaCC() {
        return MaNhaCC;
    }

    public void setMaNhaCC(String maNhaCC) {
        MaNhaCC = maNhaCC;
    }

    public String getMaLoaiDV() {
        return MaLoaiDV;
    }

    public void setMaLoaiDV(String maLoaiDV) {
        MaLoaiDV = maLoaiDV;
    }

    public String getDongXe() {
        return DongXe;
    }

    public void setDongXe(String dongXe) {
        DongXe = dongXe;
    }

    public String getMaMP() {
        return MaMP;
    }

    public void setMaMP(String maMP) {
        MaMP = maMP;
    }
}
