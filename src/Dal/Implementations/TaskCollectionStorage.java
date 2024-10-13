package Dal.Implementations;
import Dal.Abstractions.BaseStorage;
import Models.Implementations.TaskCollection;

// Паттерн Singleton
public class TaskCollectionStorage extends BaseStorage<TaskCollection> {
    private final static TaskCollectionStorage instance = new TaskCollectionStorage();

    private TaskCollectionStorage() {}

    public static TaskCollectionStorage getInstance() {
        return instance;
    }
}