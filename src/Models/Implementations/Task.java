package Models.Implementations;
import Models.Implementations.Enums.TaskCompletionStatus;

import java.util.UUID;
// Паттерн Prototype (getClone)
// Паттерн Static Factory Method (getCompletedTask)
public class Task {
    private String name;
    private String description;
    private final UUID id;
    private TaskCompletionStatus completionStatus;

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
        this.id = UUID.randomUUID();
        this.completionStatus = TaskCompletionStatus.ASSIGNED;
    }

    private Task(Task oldTask) {
        this.name = oldTask.getName();
        this.description = oldTask.getDescription();
        this.id = oldTask.getId();
        this.completionStatus = oldTask.getCompletedStatus();
    }

    public Task createCompletedTask(String name, String description) {
        var newTask = new Task(name, description);
        newTask.completionStatus = TaskCompletionStatus.COMPLETED;
        return newTask;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public UUID getId() {
        return id;
    }

    public TaskCompletionStatus getCompletedStatus() {
        return completionStatus;
    }

    public void updateCompletedStatus() {
        this.completionStatus = this.completionStatus.nextStatus();
    }

    public Task getClone() {
        return new Task(this);
    }
}
