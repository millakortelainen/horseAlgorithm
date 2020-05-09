package horsealgorithm.util;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class RandomGeneratorTest {

    RandomGenerator rg;

    @Before
    public void setUp() {
        rg = new RandomGenerator();
    }

    @Test
    public void numbersAreWithinBoundaries() {
        boolean pass = true;
        int n = 99999;
        for (int i = 0; i < 10000; i++) {
            int r = rg.randomNumber(n);
            if (r > n || r < 0) {
                pass = false;
            }
        }
        assertTrue(pass);
    }
}