package Dal.Implementations;
import Dal.Abstractions.BaseStorage;
import Models.Implementations.Task;

// Паттерн Singleton
public class TaskStorage extends BaseStorage<Task> {
    private final static TaskStorage instance = new TaskStorage();

    private TaskStorage() {}

    public static TaskStorage getInstance() {
        return instance;
    }
}
