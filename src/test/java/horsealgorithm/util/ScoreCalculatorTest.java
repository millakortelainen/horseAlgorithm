package horsealgorithm.util;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import horsealgorithm.domain.*;

public class ScoreCalculatorTest {

    ScoreCalculator sc;

    @Before
    public void setUp() {
        sc = new ScoreCalculator();
    }

    @Test
    public void heightScoreTest() {
        assertEquals(0.0, sc.heightScore(new Horse(1, "name", 1, 120, 1), new Rider(1, "name", 1, 141, 1)), 0.0001);
        assertEquals(0.0, sc.heightScore(new Horse(1, "name", 1, 125, 1), new Rider(1, "name", 1, 100, 1)), 0.0001);
        assertEquals(0.3, sc.heightScore(new Horse(1, "name", 1, 120, 1), new Rider(1, "name", 1, 140, 1)), 0.0001);
        assertEquals(0.3, sc.heightScore(new Horse(1, "name", 1, 125, 1), new Rider(1, "name", 1, 110, 1)), 0.0001);
    }

    @Test
    public void typeScoreTest() {
        assertEquals(0.2, sc.typeScore(new Horse(1, "name", 1, 120, 1), new Rider(1, "name", 1, 141, 1)), 0.0001);
        assertEquals(0.0, sc.typeScore(new Horse(1, "name", 1, 120, 2), new Rider(1, "name", 1, 140, 1)), 0.0001);
        assertEquals(0.0, sc.typeScore(new Horse(1, "name", 1, 125, 1), new Rider(1, "name", 1, 110, 3)), 0.0001);

    }

    @Test
    public void skillLevelScoreTest() {
        Horse h = new Horse(1);
        Rider r = new Rider(1);

        h.setSkillLevel(1);
        r.setSkillLevel(1);
        assertEquals(0.5, sc.skillLevelScore(r, h), 0.0001);

        h.setSkillLevel(3);
        assertEquals(0.3, sc.skillLevelScore(r, h), 0.0001);

        r.setSkillLevel(5);
        assertEquals(0.0, sc.skillLevelScore(r, h), 0.0001);
    }

    @Test
    public void calculateCompatibilityTest() {
        Horse h = new Horse(1);
        Rider r = new Rider(1);
        h.setHeight(180);
        r.setHeight(180);
        h.setSkillLevel(1);
        r.setSkillLevel(1);
        h.setType(1);
        r.setType(1);
        assertEquals(1.0, sc.calculateCompatibility(h, r), 0.0001);
        h.setHeight(175);
        assertEquals(1.0, sc.calculateCompatibility(h, r), 0.0001);

        r.setType(2);
        assertEquals(0.8, sc.calculateCompatibility(h, r), 0.0001);

        h.setSkillLevel(3);
        assertEquals(0.6, sc.calculateCompatibility(h, r), 0.0001);

        r.setSkillLevel(5);
        assertEquals(0.3, sc.calculateCompatibility(h, r), 0.0001);

        r.setHeight(100);
        assertEquals(0.0, sc.calculateCompatibility(h, r), 0.0001);
    }

}