package View;

import Controllers.TaskManager;
import Models.Implementations.Task;

import java.util.List;
import java.util.Scanner;

public class TaskViewManager {
    private TaskManager taskManager;

    public TaskViewManager(TaskManager taskManager) {
        this.taskManager = taskManager;
    }

    public void manageTasks() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите действие: ");
            System.out.println("1. Добавить задачу");
            System.out.println("2. Удалить задачу");
            System.out.println("3. Изменить статус задачи");
            System.out.println("4. Показать задачи");
            System.out.println("5. Выход");

            var choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введите название задачи: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите описание задачи: ");
                    String description = scanner.nextLine();
                    taskManager.addTask(name, description);
                    break;
                case 2:
                    var removeTasks = taskManager.getShowTasks();
                    showTasks(removeTasks);
                    System.out.print("Введите номер задачи для удаления: ");
                    var taskIndex = scanner.nextInt() - 1;
                    if (taskIndex < 0 || taskIndex >= removeTasks.size()) {
                        System.out.println("Неверный номер задачи.");
                        break;
                    }
                    var taskId = removeTasks.get(taskIndex).getId();
                    taskManager.removeTask(taskId);
                    break;
                case 3:
                    var showUpdateTasks = taskManager.getShowTasks();
                    showTasks(showUpdateTasks);
                    System.out.print("Введите номер задачи для изменения статуса: ");
                    var updateTaskIndex = scanner.nextInt() - 1;
                    if (updateTaskIndex < 0 || updateTaskIndex >= showUpdateTasks.size()) {
                        System.out.println("Неверный номер задачи.");
                        break;
                    }
                    var updateTaskId = showUpdateTasks.get(updateTaskIndex).getId();
                    taskManager.updateTaskState(updateTaskId);
                    break;
                case 4:
                    var showTasks = taskManager.getShowTasks();
                    showTasks(showTasks);
                    break;
                case 5:
                    System.out.println("Выход из программы.");
                    return;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private void showTasks(List<Task> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("Список задач пуст.");
            return;
        }

        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            System.out.println((i + 1) + ". " + task.getName() + " (" + task.getDescription() + ")" + "статус: " + task.getCompletedStatus().getRussianText());
        }
    }
}