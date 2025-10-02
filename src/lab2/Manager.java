package lab2;

public class Manager extends Employee {
    private String task;

    public Manager(int workId, String firstName, String lastName, String taskDescription) {
        super(workId, firstName, lastName);
        this.task = taskDescription;
    }

    public Manager() {
        super();
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String manageTask(String taskDescription) {
        return "Менеджер c айди:" + super.getWorkId() + " назначает задачу: " + task;
    }
}
