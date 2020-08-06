package thue_xe.model;

public class SelectFullNCC {
    private String MaDKCC;
    private String MaNCC;
    private String TenNCC;
    private String DiaChi;
    private String MaSoThue;
    private String TenLoaiDV;
    private String DonGia;
    private String HangXe;
    private String NgayBatDauCC;
    private String NgayKetThucCC;

    public SelectFullNCC() {
    }

    public SelectFullNCC(String maDKCC, String maNCC, String tenNCC, String diaChi, String maSoThue, String tenLoaiDV, String donGia, String hangXe, String ngayBatDauCC, String ngayKetThucCC) {
        MaDKCC = maDKCC;
        MaNCC = maNCC;
        TenNCC = tenNCC;
        DiaChi = diaChi;
        MaSoThue = maSoThue;
        TenLoaiDV = tenLoaiDV;
        DonGia = donGia;
        HangXe = hangXe;
        NgayBatDauCC = ngayBatDauCC;
        NgayKetThucCC = ngayKetThucCC;
    }

    public String getMaDKCC() {
        return MaDKCC;
    }

    public void setMaDKCC(String maDKCC) {
        MaDKCC = maDKCC;
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

    public String getMaSoThue() {
        return MaSoThue;
    }

    public void setMaSoThue(String maSoThue) {
        MaSoThue = maSoThue;
    }

    public String getTenLoaiDV() {
        return TenLoaiDV;
    }

    public void setTenLoaiDV(String tenLoaiDV) {
        TenLoaiDV = tenLoaiDV;
    }

    public String getDonGia() {
        return DonGia;
    }

    public void setDonGia(String donGia) {
        DonGia = donGia;
    }

    public String getHangXe() {
        return HangXe;
    }

    public void setHangXe(String hangXe) {
        HangXe = hangXe;
    }

    public String getNgayBatDauCC() {
        return NgayBatDauCC;
    }

    public void setNgayBatDauCC(String ngayBatDauCC) {
        NgayBatDauCC = ngayBatDauCC;
    }

    public String getNgayKetThucCC() {
        return NgayKetThucCC;
    }

    public void setNgayKetThucCC(String ngayKetThucCC) {
        NgayKetThucCC = ngayKetThucCC;
    }

    @Override
    public String toString() {
        return "MaDKCC:" + this.getMaDKCC() + "||MaNCC:" + this.getMaNCC() + "||TenNCC:" + this.getTenNCC()
                + "||DiaChi:" + this.getDiaChi() + "||MaSoThue:" + this.getMaSoThue()
                + "||TenLoaiDV:" + this.getTenLoaiDV() + "||DonGia:" + this.getDonGia()
                + "||HangXe:" + this.getHangXe() + "||NgayBatDauCC:" + this.getNgayBatDauCC()
                + "||NgayKetThucCC:" + this.getNgayKetThucCC();
    }
}
