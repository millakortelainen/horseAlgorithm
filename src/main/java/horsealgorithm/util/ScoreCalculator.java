package horsealgorithm.util;

import horsealgorithm.domain.Horse;
import horsealgorithm.domain.Rider;

public class ScoreCalculator {

    /**
     * Calculates compatibility of the rider and horse. 
     * Calculation uses helper methods of the class to determine 
     * the final score. Score is dependent on horses and riders 
     * height difference, horses and riders skill levels and
     * horse's and rider's types.
     * 
     * @param horse given horse
     * @param rider given rider
     * @return compatibility level as a double. 
     * it is like a percent of how much horse and rider like each other.
     */
    public double calculateCompatibility(Horse horse, Rider rider) {
        return heightScore(horse, rider) + typeScore(horse, rider) + skillLevelScore(rider, horse);
    }

    /**
     * Score of the height differation of the horse and rider
     * 
     * @param horse given horse
     * @param rider given rider
     * @return return 0 if the horses and riders height difference is more than 20,
     * returns 0.3 if the horse's and rider's eight difference is less than 20
     */
    public double heightScore(Horse horse, Rider rider) {
        if (Math.abs(horse.getHeight() - rider.getHeight()) > 20) {
            return 0;
        }
        return 0.3;
    }

    /**
     * Gives score to pairs type.
     * 
     * @param horse given horse
     * @param rider given rider
     * @return if the horse and the rider has the same score the returns 0.2,
     * else returns 0.
     */
    public double typeScore(Horse horse, Rider rider) {
        if (horse.getType().equals(rider.getType())) {
            return 0.2;
        }
        return 0;
    }

    /**
     * Gives score of the paris skill levels
     * 
     * @param r given rider
     * @param h given horse
     * @return if horse and rider have has the same skill level then returns 0.5
     * if horses skill level is better than rider then returns 0.3
     * else returns 0
     */
    public double skillLevelScore(Rider r, Horse h) {
        if (h.getSkillLevel().equals(r.getSkillLevel())) {
            return 0.5;
        }
        if (horsesSkillLevelIsLarger(r, h)) {
            return 0.3;
        }
        return 0.0;
    }

    /**
     * check is the horses skill level is better than riders.
     * 
     * @param r given rider
     * @param h given horse
     * @return true if the horses skill level is better than riders
     * false if riders skill level is better than horses
     */
    public boolean horsesSkillLevelIsLarger(Rider r, Horse h) {
        return h.getSkillLevel().getSkillLevelNumber() > r.getSkillLevel().getSkillLevelNumber();
    }
}