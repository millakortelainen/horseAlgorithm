package horsealgorithm.util;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

public class CombinatorTest {
    Combinator c;

    @Before
    public void setUp() {
        c = new Combinator();
    }

    @Test
    public void testFactorialCalculator() {
        assertEquals(6, c.factorial(3));
        assertEquals(720, c.factorial(6));
    }
}