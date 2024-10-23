package Services.Notifier;

import Models.Implementations.Enums.TaskCompletionStatus;
import Models.Implementations.Task;

public interface ITaskNotifier {
    void notifyStatusChange(Task task, TaskCompletionStatus oldStatus, TaskCompletionStatus newStatus);
}