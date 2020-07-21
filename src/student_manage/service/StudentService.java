package student_manage.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentService {
    private Connection con;

    public StudentService(Connection con) {
        this.con = con;
    }

    public void updateNoOfStudent(){
        try{
            Statement statement=con.createStatement();
            String update_noofstudent="UPDATE `departments` SET NoOfStudents = (SELECT COUNT(`DeptID`) FROM `students` WHERE `DeptID` = departments.DeptID)";
            statement.execute(update_noofstudent);

        }catch (Exception e){
            System.out.println("Error: "+e);
        }
    }
    public void updateAverageScore(){
        try{
            String getstudentID="SELECT distinct StudentID FROM manage_student.results";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(getstudentID);
            List<String> studentID = new ArrayList<>();
            while (resultSet.next()){
                studentID.add(resultSet.getString(1));
            }

            String getCourseCredit="SELECT `CourseID`,`Credits` FROM `manage_student`.`courses`";
            Statement statement1=con.createStatement();
            ResultSet resultSet1=statement1.executeQuery(getCourseCredit);
            Map<String,Integer> mapcredits= new HashMap<>();
            while (resultSet1.next()){
                mapcredits.put(resultSet1.getString(1),resultSet1.getInt(2));
            }

            for (String stdID:studentID) {
                String getCourseMark = "SELECT `CourseID`,`Mark` FROM `results` WHERE `StudentID` = '" + stdID + "'";
                Statement statement2 = con.createStatement();
                ResultSet resultSet2 = statement2.executeQuery(getCourseMark);
                Map<String, Float> mapMark = new HashMap<>();
                while (resultSet2.next()) {
                    String courseid = resultSet2.getString(1);
                    Float mark = resultSet2.getFloat(2);

                    Float value = mapMark.get(courseid);
                    if (value == null) {
                        mapMark.put(courseid, mark);
                    } else {
                        if (value < mark) {
                            mapMark.put(courseid, mark);
                        }
                    }
                }
                Float total = 0.0f;
                Integer totalCredit = 0;

                for (String courseid : mapMark.keySet()){
                    Float mark=mapMark.get(courseid);
                    Integer credit=mapcredits.get(courseid);

                    total=total+mark*credit;
                    totalCredit=totalCredit+credit;
                }
                Float averageScore=total/totalCredit;
                String updateAverageScore="UPDATE `students` SET `AverageScore`= "+averageScore+" WHERE `StudentID`='"+stdID+"'";
                Statement updateScore = con.createStatement();
                updateScore.execute(updateAverageScore);
            }

        }catch (Exception e){
            System.out.println("Error "+e);
        }
    }
}
