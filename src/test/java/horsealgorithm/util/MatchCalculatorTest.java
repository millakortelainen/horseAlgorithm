package horsealgorithm.util;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

import horsealgorithm.domain.*;

public class MatchCalculatorTest {
    MatchCalculator m;

    @Before
    public void setUp() {
        m = new MatchCalculator();
    }

    @Test
    public void calculateAllScoresTest() {
        Horse[] horses = new HorseFactory().makeHorses(3);
        Rider[] riders = new RiderFactory().makeRiders(3);
        Pair[] pairs = new PairFactory().pairAll(horses, riders);
        Pair[] pairsWithScores = m.calculateAllScores(pairs);
        boolean pass = true;
        for (Pair p : pairsWithScores) {
            if (p.getScore() < 0.0) {
                pass = false;
            }
        }
        assertTrue(pass);
    }

    @Test
    public void horseDoesNotHavePairTest() {
        Pair[] horsesRider = { null, null, new Pair(new Horse(3), new Rider(1)) };
        assertTrue(m.horseDoesNotHaveRider(horsesRider, new Pair(new Horse(1), new Rider(1))));
        assertFalse(m.horseDoesNotHaveRider(horsesRider, new Pair(new Horse(3), new Rider(1))));
    }

    @Test
    public void setRiderToHorse() {
        Pair[] horsesRider = { null, null, new Pair(new Horse(3), new Rider(1)) };
        Pair p = new Pair(new Horse(1), new Rider(2));
        horsesRider = m.setRiderToHorse(horsesRider, p);
        assertNotNull(horsesRider[0]);
        assertNull(horsesRider[1]);
        assertNotNull(horsesRider[2]);
    }

    @Test
    public void horsesCurrentRidersScoreTest() {
        Pair[] horsesRider = { null, null, new Pair(new Horse(3), new Rider(1), 0.6) };
        Pair p = new Pair(new Horse(3), new Rider(2));
        assertEquals(0.6, m.horsesCurrentRidersScore(horsesRider, p), 0.000001);
    }

    @Test
    public void riderHasBetterScoreTest() {
        Pair[] horsesRider = { null, null, new Pair(new Horse(3), new Rider(1), 0.6) };
        Pair p = new Pair(new Horse(3), new Rider(2), 0.8);
        assertTrue(m.riderHasBetterScore(horsesRider, p));

        p.setScore(0.4);
        assertFalse(m.riderHasBetterScore(horsesRider, p));
    }

    @Test
    public void getHorsesCurrentRiderTest() {
        Pair[] horsesRider = { null, null, new Pair(new Horse(3), new Rider(1), 0.6) };
        Pair p = new Pair(new Horse(3), new Rider(2), 0.8);
        Rider r = m.getHorsesCurrentRider(horsesRider, p);
        assertEquals(new Rider(1).getId(), r.getId());
    }

    @Test
    public void GSAtest1() {
        Rider[] riders = { new Rider(1), new Rider(2), new Rider(3) };
        Horse[] horses = { new Horse(1), new Horse(2), new Horse(3) };
        Pair[] pairs = new PairFactory().pairAll(horses, riders);
        m.calculateAllScores(pairs);
        Pair[] all = m.GSAlgorithmForPairing(horses, riders);
        assertEquals(3, all.length);

        boolean pass = true;
        for (Pair p : all) {
            if (p == null) {
                pass = false;
            }
        }
        assertTrue(pass);
    }

    @Test
    public void GSAtest2() {
        Rider[] riders = { new Rider(1), new Rider(2), new Rider(3) };
        Horse[] horses = { new Horse(1), new Horse(2), new Horse(3), new Horse(4) };
        Pair[] pairs = new PairFactory().pairAll(horses, riders);
        m.calculateAllScores(pairs);
        Pair[] all = m.GSAlgorithmForPairing(horses, riders);
        assertEquals(4, all.length);

        int nulls = 0;
        for (Pair p : all) {
            if (p == null) {
                nulls++;
            }
        }
        assertEquals(1, nulls);
    }

    @Test
    public void GSAtest3() {
        Rider r1 = new Rider(1);
        Rider r2 = new Rider(2);
        Rider r3 = new Rider(3);
        Horse h1 = new Horse(1);
        Horse h2 = new Horse(2);
        Horse h3 = new Horse(3);

        r1.setSkillLevel(1);
        h3.setSkillLevel(1);
        r1.setType(4);
        h3.setType(4);
        r1.setHeight(190);
        h3.setHeight(190);

        r3.setSkillLevel(5);
        h2.setSkillLevel(5);
        r3.setType(2);
        h2.setType(2);
        r3.setHeight(120);
        h2.setHeight(120);

        r2.setSkillLevel(2);
        h1.setSkillLevel(2);
        r2.setType(5);
        h1.setType(5);
        r2.setHeight(100);
        h1.setHeight(100);

        Rider[] riders = { r1, r2, r3 };
        Horse[] horses = { h1, h2, h3 };
        Pair[] pairs = new PairFactory().pairAll(horses, riders);
        m.calculateAllScores(pairs);
        Pair[] all = m.GSAlgorithmForPairing(horses, riders);
        assertEquals(3, all.length);

        assertEquals(r2, all[0].getRider());
        assertEquals(r3, all[1].getRider());
        assertEquals(r1, all[2].getRider());
    }

}
