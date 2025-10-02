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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getFirstName() {
        return "Зарплата: " + getFirstName() + " " + getLastName() + " равна " + getSalary();
    }
}
