package lesson3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLOutput;
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
                    .getConnection("jdbc:mysql://127.0.0.1:3306/student_cms_plusplus?characterEncoding=UTF-8&autoReconnect=true&connectTimeout=30000&socketTimeout=30000&serverTimezone=UTC", "root", "phanhoang1602");
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
            System.out.println("4.Thoát ra");
            System.out.println("Nhập lựa chọn của bạn ");
            String n = scanner.nextLine();
            switch (n) {
                case "1":
                    System.out.println("Nhập vào hãng ");
                    String makers = scanner.nextLine();
                    laptopService.findbyMaker(makers);
                    break;
                case "2":
                    System.out.println("Nhập vào mức giá");
                    System.out.print("từ: ");
                    String a = scanner.nextLine();
                    System.out.print("đến: ");
                    String b = scanner.nextLine();
                    laptopService.findbyPrice(a, b);
                    break;
                case "3":
                    System.out.println("Nhập vào hãng");
                    String maker = scanner.nextLine();
                    System.out.println("Nhập vào loại ổ cứng");
                    String hard_driver = scanner.nextLine();
                    laptopService.findbyMakerAndHardDrive(maker, hard_driver);
                    break;
                default:
                    return;
            }
        }

    }
}
