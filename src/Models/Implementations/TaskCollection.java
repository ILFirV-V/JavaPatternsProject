package Models.Implementations;
import Models.Abstractions.BaseEntity;
import Models.Abstractions.IClone;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// Паттерн Prototype (getClone)
// Паттерн Static Factory Method (createExampleCollection)
public class TaskCollection
        extends BaseEntity
        implements IClone<TaskCollection>
{
    private String name;
    private final List<Task> tasks;

    public TaskCollection(String name) {
        super(UUID.randomUUID());
        this.name = name;
        this.tasks = new ArrayList<>();
    }

    private TaskCollection(TaskCollection oldTaskCollection) {
        super(oldTaskCollection.getId());
        this.name = oldTaskCollection.getName();
        this.tasks = oldTaskCollection.getTasks();
    }

    @Override
    public TaskCollection getClone() {
        return new TaskCollection(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Task> getTasks() {
        List<Task> taskCopies = new ArrayList<>();
        for (Task task : tasks) {
            taskCopies.add(task.getClone());
        }
        return taskCopies;
    }

    public TaskCollection createExampleCollection() {
        var exampleCollectionName = "Коллекция для примера";
        return new TaskCollection(exampleCollectionName) ;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }
}
