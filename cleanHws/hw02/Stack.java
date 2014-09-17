/**
 * Your stack implementation. Don't add any new public methods.
 *
 * @author Your Name
 * @version 1.0
 */
public class Stack<T> implements StackInterface<T> {

    private LinkedListInterface<T> stack;

    public Stack() {
        stack = new DoublyLinkedList<T>();
    }

    @Override
    public void push(T t) {

    }

    @Override
    public T pop() {
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
