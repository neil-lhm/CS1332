/**
 * ArrayStack
 *
 * Implementation of a stack using an array
 * as the backing store.
 *
 * @author Menghang Li
 * @version 1.0
 */
public class ArrayStack<T> implements StackInterface<T> {

    private static final int STACK_SIZE = 200;
    //TODO Add any private variables you may need.
    private int size;
    private Object[] backArr;
    //HINT Use an object array and something to keep track
    //     of what the next available slot or last added index is.

    public ArrayStack() {
        backArr = (T[]) new Object[STACK_SIZE];
        size = 0;
    }

    @Override
    public void push(T t) {
        if (t == null) throw new IllegalArgumentException();
        else if (size == STACK_SIZE) throw new RuntimeException();
        else {
            backArr[size++] = t;
        }
    }

    @Override
    public T pop() {
        if (size == 0) return null;
        else {
            T data = (T) backArr[(size - 1)];
            backArr[--size] = null;
            return data;
        }
        
    }

    @Override
    public T[] toArray() {
        return (T[]) backArr;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) return true;
        return false;
    }
        
    
}
