import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This is a class that will allow you to iterate through the first n Fibonacci
 * elements
 * 
 * @author kushagramansingh
 *
 */
public class FibonacciIterator implements Iterator<Integer> {
    private Integer n;
    private Integer current;
    private Integer runningValue = 1;
    private Integer previousValue = 0;

    public FibonacciIterator(Integer n) {
        // n stores the times next() should be called
        this.n = n;
    }

    @Override
    public boolean hasNext() {
        if (n <= 0) {
            return false;
        }
        return true;
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            current = previousValue + runningValue;
            previousValue = runningValue;
            runningValue = current;
            n--;
            return previousValue;

        }
        throw new NoSuchElementException();

    }
}
