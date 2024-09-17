package Dal.Implementations;
import Models.Implementations.Task;
import java.util.*;

// Паттерн Singleton
public class TaskStorage {
    private final static TaskStorage instance = new TaskStorage();;
    private Map<UUID, Task> tasks = new HashMap<>();

    private TaskStorage() {}

    public static TaskStorage getInstance() {
        return instance;
    }

    public void addOrUpdateTask(Task task) {
        var index = -1;
        for(var i = 0; i < tasks.size(); i++)
        {
            if(tasks.get(i).getId() == task.getId())
            {
                index = i;
                break;
            }
        }
        if(index == -1)
        {
            tasks.put(task.getId(), task);
        }
        else
        {
            tasks.replace(task.getId(), task);
        }
    }

    public void removeTask(UUID taskId) {
        tasks.remove(taskId);
    }

    public List<Task> getTasks() {
        List<Task> taskCopies = new ArrayList<>();
        for (Task task : tasks.values()) {
            taskCopies.add(task.getClone());
        }
        return taskCopies;
    }

    public Task getTaskById(UUID taskId)
    {
        return tasks.get(taskId);
    }
}
