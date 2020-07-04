package service;

import model.LaptopModel;

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
    public List<LaptopModel> findbyMaker(String maker) {
        List<LaptopModel> laptopModels = new ArrayList<>();
        try {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from `laptop_cms_plusplus`.`laptop` where `maker` like '%" + maker + "%'");
            while (resultSet.next()) {
                LaptopModel laptopModel = new LaptopModel(
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getInt(9)
                );
                laptopModels.add(laptopModel);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return laptopModels;
    }

    @Override
    public List<LaptopModel> findbyPrice(String a, String b) {
        List<LaptopModel> laptopModels = new ArrayList<>();
        try {
            String sql = "";
            Statement statement = con.createStatement();
            if (a == null) {
                sql = "select * from `laptop_cms_plusplus`.`laptop` where `price` <= " + b + "";
            } else if (b == null) {
                sql = "select * from `laptop_cms_plusplus`.`laptop` where `price` >= " + a + "  ";

            } else if (a == null && b == null) {
                System.out.println("Chưa nhập thông tin ");

            } else {
                sql = "select * from `laptop_cms_plusplus`.`laptop` where `price` between " + a + " and " + b + " ";
            }
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                LaptopModel laptopModel = new LaptopModel(
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getInt(9));
                laptopModels.add(laptopModel);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return laptopModels;
    }

    @Override
    public List<LaptopModel> findbyMakerAndHardDrive(String maker, String hard_drive) {
        List<LaptopModel> laptopModels = new ArrayList<>();
        try {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from `laptop_cms_plusplus`.`laptop` where `maker` like '%" + maker + "' and `hard drive` like '%" + hard_drive + "' ");
            while (resultSet.next()) {
                LaptopModel laptopModel = new LaptopModel(
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getInt(9)
                );
                laptopModels.add(laptopModel);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return laptopModels;
    }

    @Override
    public List<LaptopModel> findBestSeller() {
        List<LaptopModel> laptopModels = new ArrayList<>();
        try {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("Select MAX(`quantity sold`) from `laptop_cms_plusplus`.`laptop`");
            int max = 0;
            while ((resultSet.next())) {
                max = resultSet.getInt(1);
            }
            Statement statement1 = con.createStatement();
            ResultSet resultSet1 = statement1.executeQuery("select *from `laptop_cms_plusplus`.`laptop` where `quantity sold`=" + max + "");
            while (resultSet1.next()) {
                LaptopModel laptopModel = new LaptopModel(
                        resultSet1.getString(2),
                        resultSet1.getString(3),
                        resultSet1.getString(4),
                        resultSet1.getString(5),
                        resultSet1.getString(6),
                        resultSet1.getString(7),
                        resultSet1.getString(8),
                        resultSet1.getInt(9)
                );
                laptopModels.add(laptopModel);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return laptopModels;
    }

    @Override
    public List<LaptopModel> findbyCPU(String cpu) {
        List<LaptopModel> laptopModels = new ArrayList<>();
        try {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from `laptop_cms_plusplus`.`laptop` where `cpu` like '%" + cpu + "%'");
            while (resultSet.next()) {
                LaptopModel laptopModel = new LaptopModel(
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getInt(9)
                );
                laptopModels.add(laptopModel);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return laptopModels;

    }

    @Override
    public List<LaptopModel> findbyRam(String ram) {
        List<LaptopModel> laptopModels = new ArrayList<>();
        try {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from `laptop_cms_plusplus`.`laptop` where `ram` like '%" + ram + "%'");
            while (resultSet.next()) {
                LaptopModel laptopModel = new LaptopModel(
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getInt(9)
                );
                laptopModels.add(laptopModel);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return laptopModels;
    }
    @Override
    public List<LaptopModel> printAllListLaptop() {
        List<LaptopModel> laptopModels = new ArrayList<>();
        try {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from `laptop_cms_plusplus`.`laptop` order by `quantity sold` DESC");
            while (resultSet.next()) {
                LaptopModel laptopModel = new LaptopModel(
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getInt(9)
                );
                laptopModels.add(laptopModel);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return laptopModels;
    }
}
