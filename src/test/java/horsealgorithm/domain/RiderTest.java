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
        rider = new Rider(1, "Name", 1, 155, 1);
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
        rider.setSkillLevel(2);
        assertEquals(2, rider.getSkillLevel());
        rider.setHeight(123);
        assertEquals(123, rider.getHeight());
        rider.setType(2);
        assertEquals(2, rider.getType());
    }

    @Test
    public void ridersFavoriteHorsesisEmptyFirst() {
        Pair[] pairs = new Pair[3];
        assertArrayEquals(pairs, rider.getFavoriteHorses());
    }

    @Test
    public void riderToString() {
        assertEquals("RIDER INFO: \n" + "1. Name: Name\n" + "Skill Level: easy\n" + "Height: 155 cm \n"
                + "Type: dressage\n" + "Top 3 horses: \n" + "No horse \n" + "No horse \n" + "No horse \n", rider.toString());
        Horse h1 = new Horse(1);
        Horse h2 = new Horse(2);
        Horse h3 = new Horse(3);
        Pair[] favPairs = { new Pair(h1, rider), new Pair(h2, rider), new Pair(h3, rider)};
        rider.setFavoriteHorses(favPairs);
        assertEquals("RIDER INFO: \n" + "1. Name: Name\n" + "Skill Level: easy\n" + "Height: 155 cm \n"
                + "Type: dressage\n" + "Top 3 horses: \n" + "HorseName1\n" + "HorseName2\n" + "HorseName3\n", rider.toString());

    }

}