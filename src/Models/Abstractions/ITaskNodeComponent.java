package Models.Abstractions;
// Паттерн Composite (ITaskNodeComponent)
public interface ITaskNodeComponent extends IEntity {
    public void completedDisplay();
    public void add(ITaskNodeComponent component);
    public void remove(ITaskNodeComponent component);
    public ITaskNodeComponent getClone();
}