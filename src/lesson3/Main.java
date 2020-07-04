package lesson3;

import model.LaptopModel;
import service.LaptopService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
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
                    .getConnection("jdbc:mysql://127.0.0.1:3306/laptop_cms_plusplus?characterEncoding=UTF-8&autoReconnect=true&connectTimeout=30000&socketTimeout=30000&serverTimezone=UTC", "root", "phanhoang1602");
            System.out.println("SQL Connection to database established!");

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            System.out.println(e);
            return;
        }
        Scanner scanner = new Scanner(System.in);
        LaptopService laptopService = new LaptopService(connection);
        while (true) {
            System.out.println("-------------MENU---------");
            System.out.println("1.Tìm kiếm theo hãng");
            System.out.println("2.Tìm kiếm theo mức giá");
            System.out.println("3.Tìm kiếm theo hãng và ổ cứng");
            System.out.println("4.Loại máy bán chạy nhất");
            System.out.println("5.Tìm kiếm theo CPU");
            System.out.println("6.Tìm kiếm theo Ram");
            System.out.println("7.Hiển thị tất cả laptop theo mức bán từ cao đến thấp");
            System.out.println("Nhập lựa chọn của bạn ");
            String n = scanner.nextLine();
            switch (n) {
                case "1":
                    System.out.println("Nhập vào hãng ");
                    String makers = scanner.nextLine();
                    List<LaptopModel> laptopModels = laptopService.findbyMaker(makers.trim().toUpperCase());
                    for (LaptopModel laptopModel : laptopModels) {
                        laptopModel.toString();
                    }
                    break;
                case "2":
                    System.out.println("Nhập vào mức giá");
                    System.out.print("từ: ");
                    String a = scanner.nextLine();
                    System.out.print("đến: ");
                    String b = scanner.nextLine();
                    List<LaptopModel> laptopModelss = laptopService.findbyPrice(a,b);
                    for (LaptopModel laptopModel : laptopModelss) {
                        laptopModel.toString();
                    }
                    break;
                case "3":
                    System.out.println("Nhập vào hãng");
                    String maker = scanner.nextLine();
                    System.out.println("Nhập vào loại ổ cứng");
                    String hard_driver = scanner.nextLine();
                    List<LaptopModel> laptopModelsss = laptopService.findbyMakerAndHardDrive(maker.trim().toUpperCase(),hard_driver.trim().toUpperCase());
                    for (LaptopModel laptopModel : laptopModelsss) {
                        laptopModel.toString();
                    }
                    break;
                case "4":
                    List<LaptopModel> laptopModels4=  laptopService.findBestSeller();
                    for (LaptopModel laptopModel : laptopModels4) {
                        laptopModel.toString();
                    }
                    break;
                case "5":
                    System.out.println("Nhập vào cpu ");
                    String cpu = scanner.nextLine();
                    List<LaptopModel> laptopModels5 = laptopService.findbyCPU(cpu.trim().toUpperCase());
                    for (LaptopModel laptopModel : laptopModels5) {
                        laptopModel.toString();
                    }
                    break;
                case "6":
                    System.out.println("Nhập vào ram ");
                    String ram = scanner.nextLine();
                    List<LaptopModel> laptopModels6 = laptopService.findbyRam(ram.trim().toUpperCase());
                    for (LaptopModel laptopModel : laptopModels6) {
                        laptopModel.toString();
                    }
                    break;
                case "7":
                    List<LaptopModel> laptopModels7 = laptopService.printAllListLaptop();
                    for (LaptopModel laptopModel : laptopModels7) {
                        laptopModel.toString();
                    }
                    break;
                default:
                    return;
            }
        }

    }
}
