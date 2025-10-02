package lab2;

public class Admin extends Employee {
    private String department;

    public Admin(int workId, String firstName, String lastName, String department) {
        super(workId, firstName, lastName);
        this.department = department;
    }

    public Admin() {
        super();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }


}
