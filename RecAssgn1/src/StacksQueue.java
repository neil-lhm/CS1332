/**
 * StacksQueue
 *
 * Implementation of a queue using
 * two stacks as the backing store.
 *
 * @author Your Name Here
 * @version 1.0
 */
public class StacksQueue<T> implements QueueInterface<T> {

    // TODO Add any private variables you need.
    private ArrayStack<T> enStack = new ArrayStack<T>();
    private ArrayStack<T> deStack = new ArrayStack<T>();
    // HINT Use one stack as the "enqueue" stack
    //      and one stack as the "dequeue" stack.
    @Override
    public void enqueue(Object o) {
        enStack.push((T) o);
    }

    @Override
    public T dequeue() {
        if (isEmpty()) return null;
        else if (!deStack.isEmpty()) return deStack.pop();
        else {
            while (!enStack.isEmpty()) deStack.push(enStack.pop());
            return deStack.pop();
        }
                
    }

    @Override
    public boolean isEmpty() {
        if (enStack.isEmpty() && deStack.isEmpty()) return true;
        return false;
    }
}
