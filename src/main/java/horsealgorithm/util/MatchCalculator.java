package horsealgorithm.util;

import horsealgorithm.domain.*;
import java.util.*;

/**
 * Class Match Calculator is a calculator which calculates scores of horse-rider
 * pairs.
 */
public class MatchCalculator {

    /**
     * Calculates double value of how well rider and horse fit together. Value can
     * be between 0.0 to 1.0.
     * 
     * @param horse horse to be paired
     * @param rider rider to be paired
     * @return score of horse and rider.
     */
    public double calculateCompatibility(Horse horse, Rider rider) {
        double comp = 0;
        if (Math.abs(horse.getHeight() - rider.getHeight()) > 20) {
            return 0;
        }
        if (horse.getType().equals(rider.getType())) {
            comp += 0.5;
        }
        comp += this.calculateSkillLevel(rider.getSkillLevel(), horse.getSkillLevel());
        return comp;
    }

    /**
     * Compares rider's skill level to horse's skill level. All riders get maximum
     * points when the horses skill level is advanced. If horse's skill level is
     * inermediate then advanced level riders get lower score. If horse's skill
     * level is easy then advanced and intermediate level riders get lower score.
     * The lower score means lower compatibility.
     * 
     * @param skillLevelRider Rider's skill level as a string
     * @param skillLevelHorse Horse's skill level as a string
     * @return score of how well the skill levels of rider and horse matches.
     */
    public double calculateSkillLevel(String skillLevelRider, String skillLevelHorse) {
        if (skillLevelHorse.equalsIgnoreCase("easy")) {
            if (skillLevelRider.equalsIgnoreCase("intemediate") || skillLevelRider.equalsIgnoreCase("advanced")) {
                return 0.3;
            }
            return 0.5;
        }
        if (skillLevelHorse.equalsIgnoreCase("intermediate")) {
            if (skillLevelRider.equalsIgnoreCase("advanced")) {
                return 0.3;
            }
            return 0.5;
        }
        if (skillLevelHorse.equalsIgnoreCase("advanced")) {
            return 0.5;
        }
        return 0.0;
    }

    /**
     * Calculates score to all given riders and horses. 
     * 
     * @param list all horse-rider pairs to be calculated.
     * @return HashMap where the key is compatibility score.
     */
    public HashMap<Double, ArrayList<Pair<Horse, Rider>>> calculateAllScores(ArrayList<Pair<Horse, Rider>> list) {

        HashMap<Double, ArrayList<Pair<Horse, Rider>>> scores = new HashMap<>();
        for (Pair<Horse, Rider> p : list) {
            double score = this.calculateCompatibility(p.getKey(), p.getValue());
            if (!scores.containsKey(score)) {
                scores.put(score, new ArrayList<>());
            }
            scores.get(score).add(p);
        }

        return scores;
    }

}