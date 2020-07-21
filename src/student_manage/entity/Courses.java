package student_manage.entity;

public class Courses {
    private String courseid;
    private String name;
    private String credits;

    public Courses() {
    }

    public Courses(String courseid, String name, String credits) {
        this.courseid = courseid;
        this.name = name;
        this.credits = credits;
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCredits() {
        return credits;
    }

    public void setCredits(String credits) {
        this.credits = credits;
    }
}
