package Models.Implementations.Enums;

public enum TaskCompletionStatus {

    ASSIGNED("Назначено"),
    IN_PROGRESS("В процессе"),
    COMPLETED("Завершено");

    private final String text;

    TaskCompletionStatus(String russianText) {
        this.text = russianText;
    }

    public String getRussianText() {
        return text;
    }

    public TaskCompletionStatus nextStatus() {
        return switch (this) {
            case ASSIGNED -> IN_PROGRESS;
            case IN_PROGRESS -> COMPLETED;
            case COMPLETED -> COMPLETED; // нужно оставаться на COMPLETED
        };
    }
}
