package horsealgorithm.util;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

import horsealgorithm.domain.*;

public class RiderFactoryTest {

    RiderFactory rf;
    SkillLevel sl;
    Type t;

    @Before
    public void setUp() {
        rf = new RiderFactory();
        sl = new SkillLevel();
        t = new Type();
    }

    @Test
    public void randomRiderIsCreated() {
        Rider r = rf.makeRider(sl, t);
        assertNotNull(r);
        assertEquals(1, r.getId());
        assertNotEquals(999, r.getSkillLevel());
        assertNotEquals(123, r.getSkillLevel());
        assertNotEquals(999, r.getType());
        assertNotEquals(123, r.getType());
    }

    @Test
    public void manyRidersAreCreated() {
        int n = 100;
        Rider[] riders = rf.makeRiders(n);

        boolean pass = true;
        for (int i = 0; i < n; i++) {
            if (riders[i] == null) {
                pass = false;
            }
            if (riders[i].getId() != i + 1) {
                pass = false;
            }
            if (riders[i].getSkillLevel() > sl.numberOfSkillLevels() || riders[i].getSkillLevel() < 1) {
                pass = false;
            }
            if (riders[i].getType() > t.numberOfTypes() || riders[i].getType() < 1) {
                pass = false;
            }
        }
        assertTrue(pass);
        assertSame(n, riders.length);
    }

}
