package lab2;

abstract public class Employee {
    private int workId;
    private String firstName;
    private String lastName;

    public static int countEmployee;

    public Employee(int workId, String firstName, String lastName) {
        this.workId = workId;
        this.firstName = firstName;
        this.lastName = lastName;
        countEmployee++;
    }

    public Employee() {
        countEmployee++;
    }

    public int getWorkId() {
        return workId;
    }

    public void setWorkId(int workId) {
        this.workId = workId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}