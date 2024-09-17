package Services;

import Dal.Implementations.TaskStorage;
import Models.Implementations.Task;

import java.util.List;
import java.util.UUID;

public class TaskService extends BaseTaskService {
    private final TaskStorage storage;

    public TaskService() {
        this.storage = TaskStorage.getInstance();
    }

    @Override
    public void createTask(String name, String description) {
        var task = new Task(name, description);
        storage.addOrUpdateTask(task);
    }

    @Override
    public Task getTaskById(UUID takId) {
        return storage.getTaskById(takId);
    }

    @Override
    public List<Task> getTasks() {
        return storage.getTasks();
    }

    @Override
    public void removeTaskById(UUID takId) {
        storage.removeTask(takId);
    }
}
