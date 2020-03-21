package horsealgorithm.util;

import org.junit.Test;
import static org.junit.Assert.*;
import horsealgorithm.domain.Horse;
import horsealgorithm.domain.Rider;

public class MatchCalculatorTest {

    @Test
    public void TestPerfectMatchingScore() {
        Horse h = new Horse("TestName", "TestSkillLevel", 188, "TestType");
        Rider r = new Rider("TestName", "TestSkillLevel", 170, "TestType");
        MatchCalculator m = new MatchCalculator();
        double d = m.calculateCompatibility(h, r);
        assertEquals(1.0, d, 0.0001);
    }

}
