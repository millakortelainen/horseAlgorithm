package horsealgorithm.util;

import org.junit.Test;
import static org.junit.Assert.*;
import horsealgorithm.domain.Rider;

public class RiderFactoryTest {
    
    @Test 
    public void RandomRiderIsCreated() {
        RiderFactory rf = new RiderFactory();
        Rider r = rf.makeRider();
        assertNotNull(r);
        }

}
