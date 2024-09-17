package Models.Implementations;
import java.util.UUID;

public class Task {
    private String name;
    private String description;
    private boolean completed;
    private final UUID id;

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
        this.completed = false;
        this.id = UUID.randomUUID();
    }

    private Task(Task oldTask) {
        this.name = oldTask.getName();
        this.description = oldTask.getDescription();
        this.completed = oldTask.isCompleted();
        this.id = oldTask.getId();
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

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Task getClone() {
        return new Task(this);
    }
}
