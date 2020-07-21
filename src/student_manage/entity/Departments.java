package student_manage.entity;

public class Departments {
    private String DeptID;
    private String Name;
    private int NoofStudent;

    public Departments() {
    }

    public Departments(String deptID, String name, int noofStudent) {
        DeptID = deptID;
        Name = name;
        NoofStudent = noofStudent;
    }

    public String getDeptID() {
        return DeptID;
    }

    public void setDeptID(String deptID) {
        DeptID = deptID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getNoofStudent() {
        return NoofStudent;
    }

    public void setNoofStudent(int noofStudent) {
        NoofStudent = noofStudent;
    }
}
