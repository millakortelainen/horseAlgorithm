package horsealgorithm.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class SkillLevelTest {
    SkillLevel sl;

    @Before
    public void setUp(){
        sl = new SkillLevel();
    }

    @Test
    public void skillLevelIsCreated() {
        assertNotNull(sl);
    }

    @Test
    public void lengthIsRight() {
        assertEquals(sl.getSkillLevels().length, sl.numberOfSkillLevels());
    }

    @Test
    public void getTypeTest(){
        assertEquals("Test", sl.getSkillLevel(999));
        assertEquals("No such skill level", sl.getSkillLevel(123));
        assertEquals("easy", sl.getSkillLevel(1));
        assertEquals("intermediate", sl.getSkillLevel(2));
        assertEquals("advanced", sl.getSkillLevel(3));
    }
}