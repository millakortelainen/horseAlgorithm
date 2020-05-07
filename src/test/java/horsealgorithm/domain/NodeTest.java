package horsealgorithm.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class NodeTest {

    Node n;

    @Before
    public void setUp(){
        n = new Node(1, "name", new SkillLevel(), 199, new Type());
    }

    @Test
    public void equalsTest(){
        assertEquals(new Node(1, "name", new SkillLevel(), 199, new Type()), n);
    }
}