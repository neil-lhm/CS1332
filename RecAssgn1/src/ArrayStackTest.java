import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;


import org.junit.Before;
import org.junit.Test;

public class ArrayStackTest {
    
    private ArrayStack<Integer> stack;
    
    @Before
    public void setup() {
        stack = new ArrayStack<Integer>();
    }
    
    @Test(timeout = 200) 
    public void testStack() {
        stack.push(new Integer(0));
        stack.push(new Integer(1));
        stack.push(new Integer(2));
        
        assertEquals(new Integer(2), stack.pop());
        assertEquals(new Integer(1), stack.pop());
        assertEquals(new Integer(0), stack.pop());
        
        stack.push(new Integer(0));
        assertEquals(new Integer(0), stack.pop());
        assertNull(stack.pop());
        assertTrue(stack.isEmpty());
    }
}
