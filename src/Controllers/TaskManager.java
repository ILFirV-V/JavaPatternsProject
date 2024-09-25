package Controllers;

import Models.Implementations.Task;
import Services.BaseTaskService;

import java.util.List;
import java.util.UUID;

public class TaskManager {
    private final BaseTaskService taskService;

    public TaskManager(BaseTaskService taskFactory) {
        this.taskService = taskFactory;
    }

    public void addTask(String name, String description) {
        if(!name.isEmpty()) {
            taskService.createTask(name, description);
        }
    }

    public void removeTask(UUID taskId) {
        taskService.removeTaskById(taskId);
    }

    public List<Task> getShowTasks() {
        return taskService.getTasks();
    }

    public Task getShowTask(UUID taskId) {
        return taskService.getTaskById(taskId);
    }

    public void updateTaskState(UUID taskId) {
        taskService.updateTaskState(taskId);
    }
}
