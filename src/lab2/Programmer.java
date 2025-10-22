package lab2;

public class Programmer extends Employee {
    private int salary;

    public Programmer() {
        super();
    }

    public Programmer(int workId, String firstName, String lastName, int salary) {
        super(workId, firstName, lastName);
        this.salary = salary;
    }

    @Override
    public void increaseWorkId() {
        setWorkId(getWorkId() + 25);
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
