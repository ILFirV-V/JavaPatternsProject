package Services;
import Dal.Implementations.TaskStorage;
import Models.Implementations.Task;
import java.util.List;
import java.util.UUID;

public class TaskService extends BaseTaskService {
    public TaskService() {
        super(TaskStorage.getInstance());
    }

    @Override
    public void create(String name, String description) {
        var task = new Task(name, description);
        storage.addOrUpdate(task);
    }

    @Override
    public Task getById(UUID id) {
        return storage.getById(id);
    }

    @Override
    public List<Task> getAll() {
        return storage.getAll();
    }

    @Override
    public void updateState(UUID id) {
        var task = storage.getById(id);
        task.updateCompletedStatus();
        storage.addOrUpdate(task);
    }

    @Override
    public void removeById(UUID id) {
        storage.remove(id);
    }
}
