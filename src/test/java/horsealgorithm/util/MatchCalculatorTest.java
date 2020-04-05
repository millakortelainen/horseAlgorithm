package horsealgorithm.util;

import org.junit.Test;
import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.junit.Before;

import horsealgorithm.domain.Horse;
import horsealgorithm.domain.Pair;
import horsealgorithm.domain.Rider;

public class MatchCalculatorTest {
    Horse horse;
    Rider rider;
    MatchCalculator m;

    @Before
    public void setUp() {
        horse = new Horse(1, "TestHorse", "advanced", 177, "dressage");
        rider = new Rider(1, "TestName", "advanced", 170, "dressage");
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

    @Test
    public void GSAlgorithmTestAllHorsesGetRider() {
        Horse h1 = new Horse(1, "name", "skillLevel", 155, "type");
        Horse h2 = new Horse(2, "name", "skillLevel", 155, "type");
        Horse h3 = new Horse(3, "name", "skillLevel", 155, "type");
        Rider r1 = new Rider(1, "name", "skillLevel", 155, "type");
        Rider r2 = new Rider(2, "name", "skillLevel", 155, "type");
        Rider r3 = new Rider(3, "name", "skillLevel", 155, "type");

        ArrayList<Horse> horses = new ArrayList<>();
        ArrayList<Rider> riders = new ArrayList<>();

        horses.add(h1);
        horses.add(h2);
        horses.add(h3);

        riders.add(r1);
        riders.add(r2);
        riders.add(r3);
        ArrayList<Pair> list = new PairFactory().pairAll(horses, riders);
        m.calculateAllScores(list);
        ArrayList<Pair> pairs = m.GSAlgorithmForPairing(horses, riders);

        assertEquals(3, pairs.size());
    }

    @Test
    public void GSAlgorithmTestSomeHorses() {
        Horse h1 = new Horse(1, "name", "skillLevel", 155, "type");
        Horse h2 = new Horse(2, "name", "skillLevel", 155, "type");
        Horse h3 = new Horse(3, "name", "skillLevel", 155, "type");
        Horse h4 = new Horse(4, "name", "skillLevel", 155, "type");
        Rider r1 = new Rider(1, "name", "skillLevel", 155, "type");
        Rider r2 = new Rider(2, "name", "skillLevel", 155, "type");
        Rider r3 = new Rider(3, "name", "skillLevel", 155, "type");

        ArrayList<Horse> horses = new ArrayList<>();
        ArrayList<Rider> riders = new ArrayList<>();

        horses.add(h1);
        horses.add(h2);
        horses.add(h3);
        horses.add(h4);

        riders.add(r1);
        riders.add(r2);
        riders.add(r3);
        ArrayList<Pair> list = new PairFactory().pairAll(horses, riders);
        m.calculateAllScores(list);
        ArrayList<Pair> pairs = m.GSAlgorithmForPairing(horses, riders);

        assertEquals(3, pairs.size());
    }
    @Test
    public void GSAlgorithmTestScoresVary() {
        Horse h1 = new Horse(1, "name", "skillLevel", 133, "type");
        Horse h2 = new Horse(2, "name", "skillLevel", 120, "type");
        Horse h3 = new Horse(3, "name", "skillLevel", 180, "type");
        Rider r1 = new Rider(1, "name", "skillLevel", 100, "type");
        Rider r2 = new Rider(2, "name", "skillLevel", 200, "type");
        Rider r3 = new Rider(3, "name", "skillLevel", 180, "type");

        ArrayList<Horse> horses = new ArrayList<>();
        ArrayList<Rider> riders = new ArrayList<>();

        horses.add(h1);
        horses.add(h2);
        horses.add(h3);

        riders.add(r1);
        riders.add(r2);
        riders.add(r3);
        ArrayList<Pair> list = new PairFactory().pairAll(horses, riders);
        m.calculateAllScores(list);
        ArrayList<Pair> pairs = m.GSAlgorithmForPairing(horses, riders);

        assertEquals(3, pairs.size());
    }

    



}
