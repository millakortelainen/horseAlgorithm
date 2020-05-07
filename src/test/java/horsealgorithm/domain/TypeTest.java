package horsealgorithm.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class TypeTest {
    Type t;

    @Before
    public void setUp() {
        t = new Type();
    }

    @Test
    public void typeIsCreated() {
        assertNotNull(t);
    }

    @Test
    public void lengthIsRight() {
        assertEquals(t.getTypes().length, t.numberOfTypes());
    }

    @Test
    public void getTypeTest(){
        assertEquals("Test", t.getType(999));
        assertEquals("No such type", t.getType(123));
        assertEquals("dressage", t.getType(1));
        assertEquals("show jumping", t.getType(2));
        assertEquals("kids", t.getType(3));
        assertEquals("cross country", t.getType(4));
    }

    @Test
    public void typeEqualsTest(){
        assertEquals(t, new Type());
        assertEquals(new Type(1), new Type(1));
        assertNotEquals(new Type(1), new Type(2));
    }

}