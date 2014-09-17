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
        stack.addToFront(t);
    }

    @Override
    public T pop() {
        return stack.removeFromBack();
    }

    @Override
    public int size() {
        return stack.size();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }



}
