package Services;
import Dal.Abstractions.BaseStorage;
import Models.Abstractions.BaseEntity;
import Models.Abstractions.IClone;
import java.util.List;
import java.util.UUID;

// Паттерн Bridge (BaseStorage<T> storage)
public abstract class BaseService<T extends BaseEntity & IClone<T>> {
    protected final BaseStorage<T> storage;

    protected BaseService(BaseStorage<T> storage) {
        this.storage = storage;
    }

    public abstract T getById(UUID id);

    public abstract List<T> getAll();

    public abstract void removeById(UUID id);

    public abstract void updateState(UUID id);
}
