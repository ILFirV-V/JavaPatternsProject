package Services.Notifier;

import Models.Implementations.Enums.TaskCompletionStatus;
import Models.Implementations.Task;

public class DefaultTaskNotifier implements ITaskNotifier {
    @Override
    public void notifyStatusChange(Task task, TaskCompletionStatus oldStatus, TaskCompletionStatus newStatus) {
        // Базовая логика
    }
}