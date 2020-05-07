package horsealgorithm.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import horsealgorithm.domain.*;

public class PairFactoryTest {

    PairFactory pf;
    Horse[] horses = { new Horse(1), new Horse(2) };
    Rider[] riders = { new Rider(1), new Rider(2) };
    Horse[] horses2 = { new Horse(1), new Horse(2), new Horse(3) };

    @Before
    public void setUp() {
        this.pf = new PairFactory();
    }

    @Test
    public void pairAllArrayLengthIsRightTest() {
        assertEquals(4, pf.pairAll(horses, riders).length);
        assertEquals(6, pf.pairAll(horses2, riders).length);
    }

    @Test
    public void pairAllArrayTest() {
        Pair[] pairs = pf.pairAll(horses, riders);
        boolean pass = true;
        for (Pair p : pairs) {
            if (p == null) {
                pass = false;
            }
        }
        assertTrue(pass);
    }

    @Test
    public void pairAllArrayTest2() {
        Pair[] pairs = pf.pairAll(horses2, riders);
        boolean pass = true;
        for (Pair p : pairs) {
            if (p == null) {
                pass = false;
            }
        }
        assertTrue(pass);
    }

}