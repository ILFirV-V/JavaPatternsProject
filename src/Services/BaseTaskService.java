package Services;

import Models.Implementations.Task;

import java.util.List;
import java.util.UUID;

public abstract class BaseTaskService {
    public abstract void createTask(String name, String description);

    public abstract Task getTaskById(UUID takId);

    public abstract List<Task> getTasks();

    public abstract void removeTaskById(UUID takId);

    public abstract void updateTaskState(UUID takId);
}
