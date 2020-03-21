package horsealgorithm.util;

import horsealgorithm.domain.Horse;
import horsealgorithm.domain.Rider;

public class MatchCalculator {

    public double calculateCompatibility(Horse horse, Rider rider) {
        double comp = 0;
        if (Math.abs(horse.getHeight() - rider.getHeight()) >= 20) {
            return 0;
        }
        if (horse.getType().equals(rider.getType())) {
            comp += 0.5;
        }
        if (horse.getSkillLevel().equals(rider.getSkillLevel())) {
            comp += 0.5;
        }
        return comp;
    }

}