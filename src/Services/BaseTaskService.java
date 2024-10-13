package Services;
import Dal.Abstractions.BaseStorage;
import Models.Implementations.Task;

public abstract class BaseTaskService extends BaseService<Task> {
    protected BaseTaskService(BaseStorage<Task> storage) {
        super(storage);
    }

    public abstract void create(String name, String description);
}
