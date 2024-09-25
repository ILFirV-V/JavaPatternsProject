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
        switch (this) {
            case ASSIGNED:
                return IN_PROGRESS;
            case IN_PROGRESS:
                return COMPLETED;
            case COMPLETED:
                return COMPLETED; // нужно оставаться на COMPLETED
        }
        throw new IllegalStateException("Unexpected status: " + this);
    }
}
