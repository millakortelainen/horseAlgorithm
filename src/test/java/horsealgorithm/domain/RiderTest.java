package horsealgorithm.domain;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class RiderTest {
    Rider rider;

    @Before
    public void setUp() {
        rider = new Rider(1, "Name", "SkillLevel", 155, "Type");
    }

    @Test
    public void riderIsCreated() {
        assertNotNull(rider);
    }

    @Test
    public void ridersSettersAndGettert() {
        rider.setId(2);
        assertEquals(2, rider.getId());
        rider.setName("newName");
        assertEquals("newName", rider.getName());
        rider.setSkillLevel("newSkillLevel");
        assertEquals("newSkillLevel", rider.getSkillLevel());
        rider.setHeight(123);
        assertEquals(123, rider.getHeight());
        rider.setType("newType");
        assertEquals("newType", rider.getType());
    }

    @Test
    public void ridersFavoriteHorsesisEmptyFirst() {
        Horse[] horses = new Horse[3];
        assertArrayEquals(horses, rider.getFavoriteHorses());
    }

    @Test
    public void ridersFavoriteHorses() {
        Horse h1 = new Horse(1, "name", "skillLevel", 133, "type");
        Horse h2 = new Horse(2, "name", "skillLevel", 111, "type");
        Horse h3 = new Horse(3, "name", "skillLevel", 199, "type");
        Horse[] horses = { h1, h2, h3 };
        rider.setFavoriteHorses(horses);
        assertArrayEquals(horses, rider.getFavoriteHorses());
    }

    @Test
    public void riderToString(){
        assertEquals("RIDER INFO: \n"+ 
        "1. Name: Name\n"+
        "Skill Level: SkillLevel\n"+
        "Height: 155 cm \n" +
        "Type: Type\n"+
        "Top 3 horses: \n"+ 
        "NaN \n" +
        "NaN \n" +
        "NaN \n" , rider.toString());
        Horse h1 = new Horse(1, "name", "skillLevel", 133, "type");
        Horse h2 = new Horse(2, "name", "skillLevel", 111, "type");
        Horse h3 = new Horse(3, "name", "skillLevel", 199, "type");
        Horse[] horses = { h1, h2, h3 };
        rider.setFavoriteHorses(horses);
        assertEquals("RIDER INFO: \n"+ 
        "1. Name: Name\n"+
        "Skill Level: SkillLevel\n"+
        "Height: 155 cm \n" +
        "Type: Type\n"+
        "Top 3 horses: \n"+ 
        "name\n" +
        "name\n" +
        "name\n" , rider.toString());

    }

}