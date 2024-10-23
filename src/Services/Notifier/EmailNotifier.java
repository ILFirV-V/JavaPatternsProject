package Services.Notifier;

import Models.Implementations.Enums.TaskCompletionStatus;
import Models.Implementations.Task;

public class EmailNotifier implements ITaskNotifier {
    private final ITaskNotifier delegate;

    public EmailNotifier(ITaskNotifier delegate) {
        this.delegate = delegate;
    }

    @Override
    public void notifyStatusChange(Task task, TaskCompletionStatus oldStatus, TaskCompletionStatus newStatus) {
        // Отправляем уведомление на почту
        System.out.println("Отправлено уведомление на email: задача " + task.getName() + " изменила статус с " + oldStatus.getRussianText() + " на " + newStatus.getRussianText());
        delegate.notifyStatusChange(task, oldStatus, newStatus);
    }
}