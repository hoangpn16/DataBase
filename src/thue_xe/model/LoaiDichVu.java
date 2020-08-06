package thue_xe.model;

public class LoaiDichVu {
    private String MaLoaiDV;
    private String TenLoaiDV;

    public LoaiDichVu() {
    }

    public LoaiDichVu(String maLoaiDV, String tenLoaiDV) {
        MaLoaiDV = maLoaiDV;
        TenLoaiDV = tenLoaiDV;
    }

    public String getMaLoaiDV() {
        return MaLoaiDV;
    }

    public void setMaLoaiDV(String maLoaiDV) {
        MaLoaiDV = maLoaiDV;
    }

    public String getTenLoaiDV() {
        return TenLoaiDV;
    }

    public void setTenLoaiDV(String tenLoaiDV) {
        TenLoaiDV = tenLoaiDV;
    }
}
