package Helpers;

import Models.Implementations.Enums.TaskCompletionStatus;
import Models.Implementations.Task;

// Паттерн Builder
public class TaskBuilder {
    private String name;
    private String description;

    public TaskBuilder name(String name) {
        this.name = name;
        return this;
    }

    public TaskBuilder description(String description) {
        this.description = description;
        return this;
    }

    public Task build() {
        return new Task(name, description);
    }
}