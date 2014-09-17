import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;


import org.junit.Before;
import org.junit.Test;

public class StacksQueueTest {
    
    private StacksQueue<Integer> queue;
    
    @Before
    public void setup() {
        queue = new StacksQueue<Integer>();
    }
    
    @Test
    public void testQueue() {
        queue.enqueue(new Integer(0));
        queue.enqueue(new Integer(1));
        queue.enqueue(new Integer(2));
        
        assertEquals(new Integer(0), queue.dequeue());
        assertEquals(new Integer(1), queue.dequeue());
        queue.enqueue(new Integer(3));
        queue.enqueue(new Integer(4));
        assertEquals(new Integer(2), queue.dequeue());
        assertEquals(new Integer(3), queue.dequeue());
        assertEquals(new Integer(4), queue.dequeue());
        assertTrue(queue.isEmpty());
    }
    
}
