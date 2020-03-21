package horsealgorithm.util;

import org.junit.Test;
import static org.junit.Assert.*;
import horsealgorithm.domain.Horse;

public class HorseFactoryTest {
    
    @Test 
    public void RandomHorseIsCreated() {
        HorseFactory hf = new HorseFactory();
        Horse h = hf.makeHorse();
        assertNotNull(h);    }

}
