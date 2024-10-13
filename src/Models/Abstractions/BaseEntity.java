package Models.Abstractions;
import java.util.UUID;

public abstract class BaseEntity implements IEntity {
    protected final UUID id;

    protected BaseEntity(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
