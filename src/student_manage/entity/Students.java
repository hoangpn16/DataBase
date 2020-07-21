package student_manage.entity;

public class Students {
    private String studentid;
    private String lastname;
    private String firstname;
    private String sex;
    private String dateofbirth;
    private String placeofbirth;
    private String deptid;
    private String scholarship;
    private float averagescore;

    public Students() {
    }

    public Students(String studentid, String lastname, String firstname, String sex, String dateofbirth, String placeofbirth,
                    String deptid, String scholarship, float averagescore) {
        this.studentid = studentid;
        this.lastname = lastname;
        this.firstname = firstname;
        this.sex = sex;
        this.dateofbirth = dateofbirth;
        this.placeofbirth = placeofbirth;
        this.deptid = deptid;
        this.scholarship = scholarship;
        this.averagescore = averagescore;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getPlaceofbirth() {
        return placeofbirth;
    }

    public void setPlaceofbirth(String placeofbirth) {
        this.placeofbirth = placeofbirth;
    }

    public String getDeptid() {
        return deptid;
    }

    public void setDeptid(String deptid) {
        this.deptid = deptid;
    }

    public String getScholarship() {
        return scholarship;
    }

    public void setScholarship(String scholarship) {
        this.scholarship = scholarship;
    }

    public float getAveragescore() {
        return averagescore;
    }

    public void setAveragescore(float averagescore) {
        this.averagescore = averagescore;
    }
}
