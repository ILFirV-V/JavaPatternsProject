package Dal.Abstractions;
import Models.Abstractions.BaseEntity;
import Models.Abstractions.IClone;
import java.util.*;

public abstract class BaseStorage<T extends BaseEntity & IClone<T>>  {
    private final Map<UUID, T> storage = new HashMap<>();

    public void addOrUpdate(T item) {
        if (storage.containsKey(item.getId())) {
            storage.replace(item.getId(), item);
        } else {
            storage.put(item.getId(), item);
        }
    }

    public void remove(UUID itemId) {
        storage.remove(itemId);
    }

    public List<T> getAll() {
        List<T> copies = new ArrayList<>();
        for (T item : storage.values()) {
            copies.add(item.getClone());
        }
        return copies;
    }

    public T getById(UUID itemId) {
        return storage.get(itemId);
    }
}