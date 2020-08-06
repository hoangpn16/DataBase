package thue_xe.model;

public class DongXe {
    private String DongXe;
    private String HangXe;
    private int SoChoNgoi;

    public DongXe() {
    }

    public DongXe(String dongXe, String hangXe, int soChoNgoi) {
        DongXe = dongXe;
        HangXe = hangXe;
        SoChoNgoi = soChoNgoi;
    }

    public DongXe(String hangXe) {
        HangXe = hangXe;
    }

    public String getDongXe() {
        return DongXe;
    }

    public void setDongXe(String dongXe) {
        DongXe = dongXe;
    }

    public String getHangXe() {
        return HangXe;
    }

    public void setHangXe(String hangXa) {
        HangXe = hangXa;
    }

    public int getSoChoNgoi() {
        return SoChoNgoi;
    }

    public void setSoChoNgoi(int soChoNgoi) {
        SoChoNgoi = soChoNgoi;
    }

    @Override
    public String toString() {
        System.out.println("DongXe:"+this.getDongXe()+"||HangXe:"+this.getHangXe()+"||SoGheNgoi:"+this.getSoChoNgoi());
        return null;
    }
}
