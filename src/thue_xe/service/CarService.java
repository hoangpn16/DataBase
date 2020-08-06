package thue_xe.service;

import thue_xe.model.CountNCC;
import thue_xe.model.DongXe;
import thue_xe.model.NhaCungCap;
import thue_xe.model.SelectFullNCC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CarService {
    private Connection con;

    public CarService(Connection con) {
        this.con = con;
    }

    public List<DongXe> searchBySoGheNgoi(int so_ghe) {
        List<DongXe> dongXeList = new ArrayList<>();

        try {
            Statement statement = con.createStatement();
            String sql = "SELECT * FROM thue_xe_cms.dongxe WHERE SoChoNgoi >=" + so_ghe + "";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                DongXe dongXe = new DongXe(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3));
                dongXeList.add(dongXe);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return dongXeList;
    }

    public List<NhaCungCap> doAct2() {
        List<NhaCungCap> nhaCungCapList = new ArrayList<>();
        try {
            Statement statement = con.createStatement();
            String sql = "SELECT NCC.* FROM nhacungcap NCC \n" +
                    "JOIN dangkycungcap DK ON NCC.MaNhaCC = DK.MaNhaCC\n" +
                    "JOIN mucphi MP ON MP.MaMp = DK.MaMp\n" +
                    "JOIN dongxe DX ON DX.DongXe = DK.DongXe\n" +
                    "WHERE (DX.HangXe = 'Toyota' AND MP.DonGia = 15000) OR (DX.HangXe = 'KIA' AND MP.DonGia = 20000);";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                NhaCungCap nhaCungCap = new NhaCungCap(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5));
                nhaCungCapList.add(nhaCungCap);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return nhaCungCapList;

    }

    //Liệt kê thông tin toàn bộ nhà cung cấp được sắp xếp tăng dần theo tên nhà cung cấp và giảm dần theo mã số thuế
    public List<NhaCungCap> doAct3() {
        List<NhaCungCap> nhaCungCapList = new ArrayList<>();
        try {
            Statement statement = con.createStatement();
            String sql = "SELECT * FROM `thue_xe_cms`.`nhacungcap` ncc ORDER BY ncc.TenNhaCC ASC,ncc.MaSoThue DESC";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                NhaCungCap nhaCungCap = new NhaCungCap(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5));
                nhaCungCapList.add(nhaCungCap);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return nhaCungCapList;
    }

    public List<CountNCC> doAct4() {
        List<CountNCC> countNCCList = new ArrayList<>();
        try {
            Statement statement = con.createStatement();
            String sql = "SELECT ncc.TenNhaCC , COUNT(TenNhaCC) AS 'SoLanDK' FROM `thue_xe_cms`.`nhacungcap` ncc\n" +
                    "JOIN  `thue_xe_cms`.`dangkycungcap` dkcc ON ncc.MaNhaCC=dkcc.MaNhaCC  WHERE dkcc.NgayBatDauCungCap LIKE '2015-11-20%' GROUP BY dkcc.MaNhaCC;";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                CountNCC countNCC = new CountNCC(resultSet.getString(1), resultSet.getInt(2));
                countNCCList.add(countNCC);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return countNCCList;
    }

    public List<DongXe> doAct5() {
        List<DongXe> dongXeList = new ArrayList<>();
        try {
            Statement statement = con.createStatement();
            String sql = "SELECT DISTINCT `HangXe` FROM `thue_xe_cms`.`dongxe` dx;";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                DongXe dongXe = new DongXe(resultSet.getString(1));
                dongXeList.add(dongXe);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return dongXeList;
    }

    public List<SelectFullNCC> doAct6() {
        List<SelectFullNCC> selectFullNCCList = new ArrayList<>();
        try {
            Statement statement = con.createStatement();
            String sql = "SELECT \n" +
                    "    dkcc.MaDKCC,\n" +
                    "    ncc.MaNhaCC,\n" +
                    "    ncc.TenNhaCC,\n" +
                    "    ncc.DiaChi,\n" +
                    "    ncc.MaSoThue,\n" +
                    "    ldv.TenLoaiDV,\n" +
                    "    mp.DonGia,\n" +
                    "    dx.HangXe,\n" +
                    "    dkcc.NgayBatDauCungCap,\n" +
                    "    dkcc.NgayKetThucCungCap\n" +
                    "FROM\n" +
                    "    nhacungcap ncc\n" +
                    "        LEFT JOIN\n" +
                    "    dangkycungcap dkcc ON ncc.MaNhaCC = dkcc.MaNhaCC\n" +
                    "        LEFT JOIN\n" +
                    "    mucphi mp ON dkcc.MaMP = mp.MaMP\n" +
                    "        LEFT JOIN\n" +
                    "    loaidichvu ldv ON dkcc.MaLoaiDV = ldv.MaLoaiDV\n" +
                    "        LEFT JOIN\n" +
                    "    dongxe dx ON dkcc.DongXe = dx.DongXe;";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                SelectFullNCC selectFullNCC = new SelectFullNCC(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getString(9),
                        resultSet.getString(10));
                selectFullNCCList.add(selectFullNCC);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return selectFullNCCList;
    }

    public List<NhaCungCap> doAct7() {
        List<NhaCungCap> nhaCungCapList = new ArrayList<>();
        try {
            Statement statement = con.createStatement();
            String sql = "SELECT DISTINCT ncc.* FROM `nhacungcap` ncc JOIN `dangkycungcap` dkcc ON ncc.MaNhaCC=dkcc.MaNhaCC WHERE dkcc.DongXe IN('Hiace','Cerato')";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                NhaCungCap nhaCungCap = new NhaCungCap(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5));
                nhaCungCapList.add(nhaCungCap);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return nhaCungCapList;
    }

    public List<NhaCungCap> doAct8() {
        List<NhaCungCap> nhaCungCapList = new ArrayList<>();
        try {
            Statement statement = con.createStatement();
            String sql = "SELECT * FROM nhacungcap WHERE MaNhaCC NOT IN(SELECT DISTINCT MaNhaCC FROM dangkycungcap GROUP BY MaNhaCC);";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                NhaCungCap nhaCungCap = new NhaCungCap(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5));
                nhaCungCapList.add(nhaCungCap);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return nhaCungCapList;
    }

}


