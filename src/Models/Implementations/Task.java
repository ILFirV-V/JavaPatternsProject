package Models.Implementations;
import Models.Abstractions.BaseEntity;
import Models.Abstractions.IClone;
import Models.Abstractions.ITaskNodeComponent;
import Models.Implementations.Enums.TaskCompletionStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// Паттерн Prototype (getClone)
// Паттерн Static Factory Method (createCompletedTask, createExampleTask)
// Паттерн Builder (TaskBuilder)
// Паттерн Composite (ITaskNodeComponent)
public class Task
        extends BaseEntity
        implements ITaskNodeComponent, IClone<Task> {
    private String name;
    private String description;
    private TaskCompletionStatus completionStatus;
    private List<ITaskNodeComponent> subComponents;

    public Task(String name, String description)
    {
        super(UUID.randomUUID());
        this.name = name;
        this.description = description;
        this.completionStatus = TaskCompletionStatus.ASSIGNED;
        this.subComponents = new ArrayList<>();
    }

    private Task(String name, String description, TaskCompletionStatus completionStatus) {
        super(UUID.randomUUID());
        this.name = name;
        this.description = description;
        this.completionStatus = completionStatus;
        this.subComponents = new ArrayList<>();
    }

    private Task(Task oldTask) {
        super(oldTask.getId());
        this.name = oldTask.getName();
        this.description = oldTask.getDescription();
        this.completionStatus = oldTask.getCompletedStatus();
        this.subComponents = new ArrayList<>();

        for (ITaskNodeComponent oldComponent : oldTask.subComponents) {
            this.subComponents.add(oldComponent.getClone());
        }
    }

    public Task createCompletedTask(String name, String description) {
        var newTask = new Task(name, description);
        newTask.completionStatus = TaskCompletionStatus.COMPLETED;
        return newTask;
    }

    public Task createExampleTask() {
        var exampleTaskName = "Пример задачи";
        var exampleTaskDescription = "Здесь пример описания";
        return new Task(exampleTaskName, exampleTaskDescription);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public UUID getId() {
        return id;
    }

    public TaskCompletionStatus getCompletedStatus() {
        return completionStatus;
    }

    public void updateCompletedStatus() {
        this.completionStatus = this.completionStatus.nextStatus();
    }

    public List<ITaskNodeComponent> getSubComponents() {
        List<ITaskNodeComponent> returnSubComponents = new ArrayList<>();

        for (ITaskNodeComponent component : this.subComponents) {
            returnSubComponents.add(component.getClone());
        }
        return returnSubComponents;
    }

    @Override
    public Task getClone() {
        return new Task(this);
    }

    public TaskBuilder builder()
    {
        return new TaskBuilder();
    }

    @Override
    public void completedDisplay() {
        completionStatus = TaskCompletionStatus.COMPLETED;
        for (ITaskNodeComponent component : this.subComponents) {
            component.completedDisplay();
        }
    }

    @Override
    public void add(ITaskNodeComponent component) {
        this.subComponents.add(component);
    }

    @Override
    public void remove(ITaskNodeComponent component) {
        this.subComponents.remove(component);
    }

    public class TaskBuilder {
        private String name;
        private String description;
        private TaskCompletionStatus completionStatus = TaskCompletionStatus.ASSIGNED;

        private TaskBuilder() { }

        public TaskBuilder name(String name) {
            this.name = name;
            return this;
        }

        public TaskBuilder description(String description) {
            this.description = description;
            return this;
        }

        public TaskBuilder completionStatus(TaskCompletionStatus completionStatus) {
            this.completionStatus = completionStatus;
            return this;
        }

        public Task build() {
            return new Task(name, description, completionStatus);
        }
    }
}
