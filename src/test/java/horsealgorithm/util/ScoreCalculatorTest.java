package horsealgorithm.util;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import horsealgorithm.domain.*;

public class ScoreCalculatorTest {

    ScoreCalculator sc;
    SkillLevel sl;
    Type t;
    Horse h;
    Rider r;

    @Before
    public void setUp() {
        sc = new ScoreCalculator();
        sl = new SkillLevel();
        t = new Type();
        h = new Horse(1);
        r = new Rider(1);
    }

    @Test
    public void heightScoreTest() {
        assertEquals(0.0, sc.heightScore(new Horse(1, "name", sl, 120, t), new Rider(1, "name", sl, 141, t)), 0.0001);
        assertEquals(0.0, sc.heightScore(new Horse(1, "name", sl, 125, t), new Rider(1, "name", sl, 100, t)), 0.0001);
        assertEquals(0.3, sc.heightScore(new Horse(1, "name", sl, 120, t), new Rider(1, "name", sl, 140, t)), 0.0001);
        assertEquals(0.3, sc.heightScore(new Horse(1, "name", sl, 125, t), new Rider(1, "name", sl, 110, t)), 0.0001);
    }

    @Test
    public void typeScoreTest() {
        assertEquals(0.2,
                sc.typeScore(new Horse(1, "name", sl, 120, new Type(1)), new Rider(1, "name", sl, 141, new Type(1))),
                0.0001);
        assertEquals(0.0,
                sc.typeScore(new Horse(1, "name", sl, 120, new Type(2)), new Rider(1, "name", sl, 140, new Type(1))),
                0.0001);
        assertEquals(0.0,
                sc.typeScore(new Horse(1, "name", sl, 125, new Type(1)), new Rider(1, "name", sl, 110, new Type(3))),
                0.0001);

    }

    @Test
    public void skillLevelScoreTest() {
        Horse h = new Horse(1);
        Rider r = new Rider(1);

        h.setSkillLevel(new SkillLevel(1));
        r.setSkillLevel(new SkillLevel(1));
        assertEquals(0.5, sc.skillLevelScore(r, h), 0.0001);

        h.setSkillLevel(new SkillLevel(3));
        assertEquals(0.3, sc.skillLevelScore(r, h), 0.0001);

        r.setSkillLevel(new SkillLevel(5));
        assertEquals(0.0, sc.skillLevelScore(r, h), 0.0001);
    }

    @Test
    public void calculateCompatibilityTest1() {
        h.setHeight(180);
        r.setHeight(180);
        h.setSkillLevel(new SkillLevel(1));
        r.setSkillLevel(new SkillLevel(1));
        h.setType(new Type(1));
        r.setType(new Type(1));
        System.out.print(sc.calculateCompatibility(h, r));
        assertEquals(1.0, sc.calculateCompatibility(h, r), 0.0001);
    }

    @Test
    public void calculateCompatibilityTest2() {

        h.setHeight(180);
        r.setHeight(180);
        h.setSkillLevel(new SkillLevel(1));
        r.setSkillLevel(new SkillLevel(1));
        h.setType(new Type(1));
        r.setType(new Type(1));
        h.setHeight(175);
        assertEquals(1.0, sc.calculateCompatibility(h, r), 0.0001);
    }

    @Test
    public void calculateCompatibilityTest3() {

        h.setHeight(180);
        r.setHeight(180);
        h.setSkillLevel(new SkillLevel(1));
        r.setSkillLevel(new SkillLevel(1));
        h.setType(new Type(1));
        r.setType(new Type(1));
        h.setHeight(175);

        r.setType(new Type(2));
        assertEquals(0.8, sc.calculateCompatibility(h, r), 0.0001);
    }

    @Test
    public void calculateCompatibilityTest4() {

        h.setHeight(180);
        r.setHeight(180);
        h.setSkillLevel(new SkillLevel(1));
        r.setSkillLevel(new SkillLevel(1));
        h.setType(new Type(1));
        r.setType(new Type(1));
        h.setHeight(175);

        r.setType(new Type(2));

        h.setSkillLevel(new SkillLevel(3));
        assertEquals(0.6, sc.calculateCompatibility(h, r), 0.0001);
    }

    @Test
    public void calculateCompatibilityTest5() {

        h.setHeight(180);
        r.setHeight(180);
        h.setSkillLevel(new SkillLevel(1));
        r.setSkillLevel(new SkillLevel(1));
        h.setType(new Type(1));
        r.setType(new Type(1));
        h.setHeight(175);

        r.setType(new Type(2));

        h.setSkillLevel(new SkillLevel(3));

        r.setSkillLevel(new SkillLevel(5));
        assertEquals(0.3, sc.calculateCompatibility(h, r), 0.0001);
    }

    @Test
    public void calculateCompatibilityTest6() {

        h.setHeight(180);
        r.setHeight(180);
        h.setSkillLevel(new SkillLevel(1));
        r.setSkillLevel(new SkillLevel(1));
        h.setType(new Type(1));
        r.setType(new Type(1));
        h.setHeight(175);

        r.setType(new Type(2));

        h.setSkillLevel(new SkillLevel(3));

        r.setSkillLevel(new SkillLevel(5));

        r.setHeight(100);
        assertEquals(0.0, sc.calculateCompatibility(h, r), 0.0001);
    }

}