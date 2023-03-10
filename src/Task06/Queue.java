package Task06;

public interface Queue {
    void put (Command command);
    Command take();
}
