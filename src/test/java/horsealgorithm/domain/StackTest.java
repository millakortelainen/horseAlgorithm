package horsealgorithm.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class StackTest {

    Stack<Object> s;

    @Before
    public void setUp() {
        s = new Stack<>();
    }

    @Test
    public void stackIsNotNull() {
        assertNotNull(s);
    }

    @Test
    public void objectIsAddedToStack() {
        Object o = new Object();
        s.add(o);
        assertEquals(1, s.size());
        assertEquals(o, s.poll());
        assertTrue(s.isEmpty());
    }

    @Test
    public void arrayInStackWorks() {
        for (int i = 0; i < 15; i++) {
            s.add(new Object());
        }
        assertEquals(15, s.size());

        for (int i = 0; i < 100; i++) {
            s.add(new Object());
        }
        assertEquals(115, s.size());

        boolean pass = true;

        for (int i = 0; i < 115; i++) {
            Object o = s.poll();
            if (o == null) {
                pass = false;
            }
        }

        assertTrue(pass);

        assertNull(s.poll());
    }

}