import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class FibonacciIteratorTest {
    private FibonacciIterator fI;

    @Before
    public void setUp() throws Exception {
        fI = new FibonacciIterator(5);
    }

    @Test
    public void test() {
        assertTrue(fI.hasNext());
        assertEquals(new Integer(1), fI.next());
        assertEquals(new Integer(1), fI.next());
        assertEquals(new Integer(2), fI.next());
        assertEquals(new Integer(3), fI.next());
        assertEquals(new Integer(5), fI.next());
        assertTrue(!fI.hasNext());
    }

}
