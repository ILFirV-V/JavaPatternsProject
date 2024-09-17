import Controllers.TaskManager;
import Services.TaskService;
import View.TaskViewManager;

public class Main {
    public static void main(String[] args) {
        var taskService = new TaskService();
        var taskManager = new TaskManager(taskService);
        var taskViewManager = new TaskViewManager(taskManager);
        taskViewManager.manageTasks();
    }
}