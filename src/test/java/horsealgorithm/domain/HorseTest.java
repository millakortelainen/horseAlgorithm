package horsealgorithm.domain;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class HorseTest {
    Horse horse;

    @Before
    public void setUp() {
        horse =  new Horse("TestHorse", "TestSkillLevel", 177, "TestType");
    }
    
    @Test 
    public void horseIsCreated() {
        assertNotNull(horse);
        assertEquals("HORSE INFO: \n"+
        "Name: TestHorse\n"+ 
        "Skill Level: TestSkillLevel\n"+
        "Height: 177 cm \n"+
        "Type: TestType", horse.toString());
    }

    @Test
    public void testHorseSettersAndGetters(){
        horse.setName("NewTest");
        assertEquals("NewTest", horse.getName());
        horse.setSkillLevel("NewSkillLevel");
        assertEquals("NewSkillLevel", horse.getSkillLevel());
        horse.setHeight(130);
        assertEquals(130, horse.getHeight());
        horse.setType("NewType");
        assertEquals("NewType", horse.getType());
    }

}
