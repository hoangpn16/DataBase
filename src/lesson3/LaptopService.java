package lesson3;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LaptopService {
    private Connection con;

    public LaptopService(Connection con) {
        this.con = con;
    }

    public LaptopService() {
    }

    public void findbyMaker(String maker) {
        try {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from `student_cms_plusplus`.`laptop` where `hang` like '%" + maker + "%'");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(2) + "||" + resultSet.getInt(3) + "||" + resultSet.getString(4));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void findbyPrice(long a, long b) {
        try {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from `student_cms_plusplus`.`laptop` where `gia` between " + a + " and " + b + " ");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(2) + "||" + resultSet.getInt(3) + "||" + resultSet.getString(4));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void findbyMakerAndHardDrive(String maker, String hard_drive) {
        try {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from `student_cms_plusplus`.`laptop` where `hang` like '%" + maker + "' and `o cung` like '%" + hard_drive + "' ");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(2) + "||" + resultSet.getInt(3) + "||" + resultSet.getString(4));
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
