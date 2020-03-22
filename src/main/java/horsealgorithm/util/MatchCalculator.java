package horsealgorithm.util;

import horsealgorithm.domain.*;
import java.util.*;
/**
 * Class Match Calculator is a calculator which calculates scores of horse-rider pairs.
 */
public class MatchCalculator {

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

    public double calculateSkillLevel(String skillLevelRider, String skillLevelHorse) {
        if (skillLevelHorse.equalsIgnoreCase("easy")) {
            if (skillLevelRider.equalsIgnoreCase("intemediate") || skillLevelRider.equalsIgnoreCase("advanced")) {
                return 0.3;
            }
            return 0.5;
        }
        if (skillLevelHorse.equalsIgnoreCase("intermediate")) {
            if(skillLevelRider.equalsIgnoreCase("advanced")){
                return 0.3;
            }
            return 0.5;
        }
        if (skillLevelHorse.equalsIgnoreCase("advanced")) {
            return 0.5;
        }
        return 0.0;
    }

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