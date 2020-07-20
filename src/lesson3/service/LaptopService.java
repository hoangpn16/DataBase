package lesson3.service;

import lesson3.model.Counter;
import lesson3.model.LaptopModel;
import lesson3.model.Statistic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class LaptopService implements ServiceInterface {
    private Connection con;

    public LaptopService(Connection con) {
        this.con = con;
    }

    public LaptopService() {
    }

    @Override
    public List<LaptopModel> searchLaptop(String maker, String from_price, String to_price, String hard_drive, String cpu, String ram, String card, String sizeofdestop, String quantity_sold, String order) {
        String sql = "SELECT * FROM `laptop` WHERE TRUE ";
        if (from_price != null) {
            sql += " AND `price` >= " + from_price + "";
        }
        if (to_price != null) {
            sql += " AND `price` <= " + to_price + "";
        }
        if (maker != null) {
            sql += " AND `maker` LIKE '%" + maker + "%' ";
        }
        if (hard_drive != null) {
            sql += " AND `hard drive` LIKE '%" + hard_drive + "%' ";
        }
        if (cpu != null) {
            sql += " AND `cpu` LIKE '%" + cpu + "%'";
        }
        if (ram != null) {
            sql += " AND `ram` LIKE '%" + ram + "%'";
        }
        if (card != null) {
            sql += " AND `card` LIKE '%" + card + "%'";
        }
        if (sizeofdestop != null) {
            sql += " AND `sizeofdestop` LIKE '%" + sizeofdestop + "%' ";
        }
        if (quantity_sold != null) {
            sql += " AND `quantity sold` LIKE '%" + quantity_sold + "%' ";
        }
        if (order != null) {
            if (order.equals("DESC")) {
                sql += " ORDER BY `price` DESC";
            } else {
                sql += " ORDER BY `price` ASC";
            }
        }
        System.out.println(sql);
        List<LaptopModel> respone = querySql(sql);
        return respone;
    }

    @Override
    public List<LaptopModel> findBestSold() {
        String sql = "SELECT * FROM `laptop` ORDER BY `quantity sold` DESC LIMIT 2";
        List<LaptopModel> respone = querySql(sql);
        return respone;

    }

    public List<LaptopModel> querySql(String sql) {
        List<LaptopModel> laptopModels = new ArrayList<>();
        try {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                LaptopModel laptopModel = new LaptopModel(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getString(8), resultSet.getInt(9));
                laptopModels.add(laptopModel);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return laptopModels;
    }

    public List<Counter> getCounterByMaker() {
        List<Counter> counters = new ArrayList<>();
        try {
            Statement statement = con.createStatement();
            String sql = "SELECT maker , COUNT(*) AS quantity FROM laptop GROUP BY `maker` ORDER BY quantity DESC ";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Counter counter = new Counter(resultSet.getString(1), resultSet.getString(2));
                counters.add(counter);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return counters;
    }
    public List<Statistic> getStatisticByMaKer (){
        List<Statistic> statistics=new ArrayList<>();
        try {
            Statement statement = con.createStatement();
            String sql = "SELECT lap.maker,SUM(lap.`quantity sold`) AS totalSold, SUM( lap.price * lap.`quantity sold`) AS totalPrice " +
                         "FROM laptop AS lap GROUP BY maker ORDER BY totalPrice DESC";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Statistic statistic = new Statistic(resultSet.getString(1), resultSet.getString(2),resultSet.getString(3));
                statistics.add(statistic);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return statistics;

    }
    public void insertLaptop(String maker, String price, String hard_drive, String cpu, String ram,
                                          String card, String sizeofdestop, int quantity_sold){
        try{
            Statement statement=con.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT * FROM `laptop` WHERE `maker` LIKE '%"+maker+"%' AND `price`='"+price+"'");
            String tmp=null;
            while(resultSet.next()){
                tmp=resultSet.getString(2);
            }
            if(tmp != null){
                System.out.println(tmp);
                System.out.println("Dữ liệu đã tồn tại");
            }else {
                String sql = "INSERT IGNORE INTO `laptop`(`maker`,`price`,`hard drive`,`cpu`,`ram`,`card`,`sizeofdestop`,`quantity sold`) VaLUES('" + maker + "','" + price + "','" + hard_drive + "','" + cpu + "','" + ram + "','" + card + "','" + sizeofdestop + "','" + quantity_sold + "') ";
                statement.execute(sql);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void updateQuantitySold(int sold,int id_laptop){
        try{
            Statement statement=con.createStatement();
            String sql="UPDATE `laptop` SET `quantity sold`=`quantity sold`+"+sold+" WHERE `idlaptop`="+id_laptop+"";
            statement.execute(sql);

        }catch (Exception e){
            System.out.println(e);
        }
    }

}
