package horsealgorithm.util;

import horsealgorithm.domain.*;

public class ScoreCalculator {

    public double calculateCompatibility(Horse horse, Rider rider) {
        return heightScore(horse, rider) + typeScore(horse, rider) + skillLevelScore(rider, horse);
    }

    public double heightScore(Horse horse, Rider rider) {
        if (Math.abs(horse.getHeight() - rider.getHeight()) > 20) {
            return 0;
        }
        return 0.3;
    }

    public double typeScore(Horse horse, Rider rider) {
        if (horse.getType() == rider.getType()) {
            return 0.2;
        }
        return 0;
    }

    public double skillLevelScore(Rider r, Horse h) {
        if (h.getSkillLevel() == r.getSkillLevel()) {
            return 0.5;
        }
        if (h.getSkillLevel() > r.getSkillLevel()) {
            return 0.3;
        }
        return 0.0;
    }
}