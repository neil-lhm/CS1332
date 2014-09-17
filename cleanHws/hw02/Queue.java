/**
 * Your queue implementation. Don't add any new public methods.
 *
 * @author Your Name Here
 * @version 1.0
 */
public class Queue<T> implements QueueInterface<T> {

    private LinkedListInterface<T> queue;

    public Queue() {
        queue = new DoublyLinkedList<T>();
    }

    @Override
    public void enqueue(T t) {
    }

    @Override
    public T dequeue() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

}
