package thue_xe;

import thue_xe.model.CountNCC;
import thue_xe.model.DongXe;
import thue_xe.model.NhaCungCap;
import thue_xe.model.SelectFullNCC;
import thue_xe.service.CarService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    /* 1. Liệt kê những dòng xe có số chỗ ngồi trên 5 chỗ
2. Liệt kê thông tin của các nhà cung cấp ĐÃ TỪNG đăng ký cung cấp những dòng xe
thuộc hãng xe “Toyota” với mức phí có đơn giá là 15.000 VNĐ/km hoặc những dòng xe
thuộc hãng xe “KIA” với mức phí có đơn giá là 20.000 VNĐ/km
3. Liệt kê thông tin toàn bộ nhà cung cấp được sắp xếp tăng dần theo tên nhà cung
cấp và giảm dần theo mã số thuế
4. Đếm số lần đăng ký cung cấp phương tiện tương ứng cho từng nhà cung cấp với
yêu cầu chỉ đếm cho những nhà cung cấp thực hiện đăng ký cung cấp có ngày bắt đầu
cung cấp là “20/11/2015”
5. Liệt kê tên của toàn bộ các hãng xe có trong cơ sở dữ liệu với yêu cầu mỗi hãng xe
chỉ được liệt kê một lần
6. Liệt kê MaDKCC, MaNhaCC, TenNhaCC, DiaChi, MaSoThue, TenLoaiDV, DonGia,
HangXe, NgayBatDauCC, NgayKetThucCC của tất cả các lần đăng ký cung cấp phương
tiện với yêu cầu những nhà cung cấp nào chưa từng thực hiện đăng ký cung cấp phương
tiện thì cũng liệt kê thông tin những nhà cung cấp đó ra
7. Liệt kê thông tin của các nhà cung cấp đã từng đăng ký cung cấp phương tiện
thuộc dòng xe “Hiace” hoặc từng đăng ký cung cấp phương tiện thuộc dòng xe “Cerato”
8. Liệt kê thông tin của các nhà cung cấp chưa từng thực hiện đăng ký cung cấp
phương tiện lần nào cả.
*/
    public static void main(String[] args) {
        System.out.println("-------- MySQL JDBC Connection Demo ------------");
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found !!");
            return;
        }
        System.out.println("MySQL JDBC Driver Registered!");
        Connection connection = null;
        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://127.0.0.1:3306/thue_xe_cms?characterEncoding=UTF-8&autoReconnect=true&connectTimeout=30000&socketTimeout=30000&serverTimezone=UTC", "root", "phanhoang1602");
            System.out.println("SQL Connection to database established!");

        } catch (
                SQLException e) {
            System.out.println("Connection Failed! Check output console");
            System.out.println(e);
            return;
        }
        Scanner scanner = new Scanner(System.in);
        CarService carService = new CarService(connection);
        while (true) {
            System.out.print("Enter your choose:");
            String n = scanner.nextLine();
            switch (n) {
                case "1":
                    List<DongXe> dongXeList = carService.searchBySoGheNgoi(5);
                    for (DongXe dongXe : dongXeList) {
                        dongXe.toString();
                    }
                    break;
                case "2":
                    List<NhaCungCap> nhaCungCapList = carService.doAct2();
                    for (NhaCungCap nhacungcap : nhaCungCapList) {
                        System.out.println(nhacungcap.toString());
                    }
                    break;
                case "3":
                    List<NhaCungCap> nhaCungCapList2 = carService.doAct3();
                    for (NhaCungCap nhacungcap : nhaCungCapList2) {
                        System.out.println(nhacungcap.toString());
                    }
                    break;
                case "4":
                    List<CountNCC> countNCCList = carService.doAct4();
                    System.out.println("     TenNCC     " + "         SoLanDK");
                    for (CountNCC counter : countNCCList) {
                        System.out.println(counter.toString());
                    }
                    break;
                case "5":
                    List<DongXe> dongXeList1 = carService.doAct5();
                    System.out.println("HANG XE");
                    System.out.println("-----------");
                    for (DongXe dongxe1 : dongXeList1) {
                        System.out.println(dongxe1.getHangXe());
                    }
                    break;
                case "6":
                    List<SelectFullNCC> selectFullNCCList = carService.doAct6();
                    System.out.println("-------------------------------------------------");
                    for (SelectFullNCC select : selectFullNCCList) {
                        System.out.println(select.toString());
                    }
                    break;
                case "7":
                    List<NhaCungCap> nhaCungCapList1 = carService.doAct7();
                    for (NhaCungCap nhacc : nhaCungCapList1) {
                        System.out.println(nhacc.toString());
                    }
                    break;
                case "8":
                    List<NhaCungCap> nhaCungCapList3 = carService.doAct8();
                    for (NhaCungCap ncc : nhaCungCapList3) {
                        System.out.println(ncc.toString());
                    }
                    break;
                default:
                    System.out.println("Say goodbye");
                    return;
            }
        }
    }
}
