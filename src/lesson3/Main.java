package lesson3;

import lesson3.model.Counter;
import lesson3.model.LaptopModel;
import lesson3.model.Statistic;
import lesson3.service.LaptopService;

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
        List<LaptopModel> results= laptopService.searchLaptop("Dell","15000000","20000000",null,null
        ,null,null,null,null,"DESC");
        for(LaptopModel laptopModel:results){
           laptopModel.toString();
        }
        System.out.println("-------------------------------------------------------------------");
        List<LaptopModel> result=laptopService.findBestSold();
        for(LaptopModel laptopModel:result){
            laptopModel.toString();
        }
        System.out.println("-------------------------------------------------------------------");
        List<Counter> counters=laptopService.getCounterByMaker();
        for(Counter counter:counters){
            System.out.println(counter.getMakers()+"\t"+counter.getQuantity());
        }
        System.out.println("-------------------------------------------------------------------");
        List<Statistic> statistics=laptopService.getStatisticByMaKer();
        for(Statistic statistic:statistics){
            System.out.println(statistic.getMaker()+"\t"+statistic.getSold()+"\t"+statistic.getTotalMoney());
        }

    }
}
