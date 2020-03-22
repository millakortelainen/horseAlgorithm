package horsealgorithm.util;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

import horsealgorithm.domain.Horse;
import horsealgorithm.domain.Rider;

public class MatchCalculatorTest {
    Horse horse;
    Rider rider;
    MatchCalculator m;

    @Before
    public void setUp() {
        horse = new Horse("TestHorse", "advanced", 177, "dressage");
        rider = new Rider("TestName", "advanced", 170, "dressage");
        m = new MatchCalculator();
    }

    @Test
    public void TestPerfectMatchingScore() {
        double d = m.calculateCompatibility(horse, rider);
        assertEquals(1.0, d, 0.0001);
    }

    @Test
    public void TestPerfectMatchingScore2() {
        horse.setHeight(170);
        rider.setHeight(190);
        double d = m.calculateCompatibility(horse, rider);
        assertEquals(1.0, d, 0.0001);
    }

    @Test
    public void TestMediumMatchingScore() {
        horse.setSkillLevel("easy");
        double d = m.calculateCompatibility(horse, rider);
        assertEquals(0.8, d, 0.0001);
    }

    @Test
    public void TestMediumMatchingScore2() {
        rider.setType("differentType");
        double d = m.calculateCompatibility(horse, rider);
        assertEquals(0.5, d, 0.0001);
    }

    @Test
    public void TestBadMatchingScore() {
        horse.setHeight(140);
        double d = m.calculateCompatibility(horse, rider);
        assertEquals(0.0, d, 0.0001);
    }

    @Test
    public void TestBadMatchingScore2() {
        rider.setSkillLevel("easy");
        rider.setType("alsoDifferent");
        double d = m.calculateCompatibility(horse, rider);
        assertEquals(0.5, d, 0.0001);
    }

}
