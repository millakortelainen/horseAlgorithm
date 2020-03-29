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
    public HashMap<Double, ArrayList<Pair>> calculateAllScores(ArrayList<Pair> list) {

        HashMap<Double, ArrayList<Pair>> scores = new HashMap<>();
        for (Pair p : list) {
            double score = this.calculateCompatibility(p.getHorse(), p.getRider());
            setFavoritesToRiders(p.getRider(), p.getHorse(), score);
            if (!scores.containsKey(score)) {
                scores.put(score, new ArrayList<>());
            }
            scores.get(score).add(p);
        }

        return scores;
    }

    /**
     * Checks the riders favorite horses. If the score of the rider and horse is
     * better than old favorite horse, then sets the horse as a new favorite horse.
     * 
     * @param r     rider
     * @param h     horse
     * @param score score of rider and horse
     */
    public void setFavoritesToRiders(Rider r, Horse h, double score) {
        Horse[] favHorses = r.getFavoriteHorses();

        for (int i = 0; i < r.getFavoriteHorses().length; i++) {
            if (r.getFavoriteHorses()[i] == null) {
                favHorses[i] = h;
                i = r.getFavoriteHorses().length;
            } else if (this.calculateCompatibility(r.getFavoriteHorses()[i], r) < score) {
                favHorses[i] = h;
            }
        }
        r.setFavoriteHorses(favHorses);

    }

    public void GSAlgorithmForPairing(ArrayList<Horse> horses, ArrayList<Rider> riders) {
        // all horses and rider in the initialized list are free
        // index of the list is rider, rider without horse is 0
        int[] pairs = new int[riders.size() + 1];
        // stack for free riders and horses
        ArrayDeque<Integer> freeRiders = new ArrayDeque<>();
        ArrayDeque<Integer> freeHorses = new ArrayDeque<>();
        for (Horse horse : horses) {
            freeHorses.add(horse.getId());
        }
        for (Rider rider : riders) {
            freeRiders.add(rider.getId());
        }
        // as long as there are free riders and horses, they will be paired
        while (!freeRiders.isEmpty() && !freeHorses.isEmpty()) {
            // first free horse
            int h = freeHorses.peek();

        }

    }

}