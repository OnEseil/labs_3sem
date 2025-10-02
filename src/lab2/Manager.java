package lab2;

public class Manager extends Employee {
    private String task;
    private int worksHours;

    public Manager(int workId, String firstName, String lastName, String task) {
        super(workId, firstName, lastName);
        this.task = task;
    }

    public Manager() {
        super();
    }

    @Override
    public void increaseWorkId() {
        setWorkId(getWorkId() + 1);
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String manageTask(String task) {
        return "Менеджер c айди:" + getWorkId() + " назначает задачу: " + task;
    }

    public int getWorksHours() {
        return worksHours;
    }

    public void setWorksHours(int worksHours) {
        this.worksHours = worksHours;
    }
}
