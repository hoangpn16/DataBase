package student_manage.entity;

public class Results {
    private String studentID;
    private String courseID;
    private String year;
    private String semester;
    private float mark;
    private String grade;

    public Results() {
    }

    public Results(String studentID, String courseID, String year, String semester, float mark, String grade) {
        this.studentID = studentID;
        this.courseID = courseID;
        this.year = year;
        this.semester = semester;
        this.mark = mark;
        this.grade = grade;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
