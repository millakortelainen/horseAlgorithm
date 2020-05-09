package horsealgorithm.util;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

import horsealgorithm.domain.*;

public class HorseFactoryTest {

    HorseFactory hf;
    SkillLevel sl;
    Type t;
    RandomGenerator rg;

    @Before
    public void setUp() {
        hf = new HorseFactory();
        sl = new SkillLevel();
        t = new Type();
        rg = new RandomGenerator();
    }

    @Test
    public void randomHorseIsCreated() {
        Horse h = hf.makeHorse(t, sl, rg);
        assertNotNull(h);
        assertEquals(1, h.getId());
        assertNotEquals(999, h.getSkillLevel());
        assertNotEquals(123, h.getSkillLevel());
        assertNotEquals(999, h.getType());
        assertNotEquals(123, h.getType());
    }

    @Test
    public void manyHorsesAreCreated() {
        int n = 100000;
        Horse[] horses = hf.makeHorses(n, t, sl, rg);

        boolean pass = true;
        for (int i = 0; i < n; i++) {
            if (horses[i] == null) {
                pass = false;
            }
            if (horses[i].getId() != i + 1) {
                pass = false;
            }
            if (horses[i].getSkillLevel().getSkillLevelNumber() > sl.numberOfSkillLevels()
                    || horses[i].getSkillLevel().getSkillLevelNumber() < 1) {
                pass = false;
            }
            if (horses[i].getType().getNumberOfType() > t.numberOfTypes()
                    || horses[i].getType().getNumberOfType() < 1) {
                pass = false;
            }
        }
        assertTrue(pass);
        assertEquals(n, horses.length);
    }

}
