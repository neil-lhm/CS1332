import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class CircularLinkedListTest {
    private CircularLinkedList<Integer> list;

    @Before
    public void setUp() throws Exception {
        list = new CircularLinkedList<Integer>();
    }

    @Test
    public void testIterator() {
        list.addToFront(new Integer(0));
        list.addToBack(new Integer(1));
        list.addAtIndex(1, new Integer(2));
        Iterator<Integer> i = list.iterator();
        assertEquals(new Integer(0), i.next());
        assertTrue(i.hasNext());
        assertEquals(new Integer(2), i.next());
        assertEquals(new Integer(1), i.next());
        assertTrue(!i.hasNext());
    }

}
