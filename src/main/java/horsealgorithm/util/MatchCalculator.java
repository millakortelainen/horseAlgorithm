package horsealgorithm.util;

import horsealgorithm.domain.Horse;
import horsealgorithm.domain.Pair;
import horsealgorithm.domain.Rider;
import horsealgorithm.domain.Stack;

/**
 * Class Match Calculator is a calculator which calculates scores of horse-rider
 * pairs.
 */
public class MatchCalculator {

    FavoriteHorseHandler fhh;
    ScoreCalculator sc;

    /**
     * Constructor for match calculator. Constructor set up favorite horse handler
     * and score calculator for the class.
     */
    public MatchCalculator() {
        this.fhh = new FavoriteHorseHandler();
        this.sc = new ScoreCalculator();
    }

    /**
     * Calculates scores for all the hors-rider combinations
     * 
     * @param pairs all the horse-rider combinations
     * @return all scored horse-rider pairs
     */
    public Pair[] calculateAllScores(Pair[] pairs) {

        for (Pair p : pairs) {
            double score = sc.calculateCompatibility(p.getHorse(), p.getRider());
            p.setScore(score);
            fhh.setFavoritesToRider(p);
        }
        return pairs;
    }

    /**
     * Calculates optimal paris for horses and riders.
     * 
     * @param horses horses to be paired
     * @param riders riders to be paired
     * @return array of optimal pairs.
     */
    public Pair[] gsAlgorithmForPairing(Horse[] horses, Rider[] riders, ScoreCalculator sc) {

        Pair[] horsesRider = new Pair[horses.length];

        Stack<Rider> freeRiders = new Stack<>();

        for (Rider rider : riders) {
            freeRiders.add(rider);
        }

        while (!freeRiders.isEmpty()) {
            Rider r = freeRiders.poll();
            boolean favoriteHorseWasFree = false;
            for (int i = 0; i < 3; i++) {

                Pair ridersFavorite = r.getFavoriteHorses()[i];
                if (ridersFavorite == null) {
                    continue;
                }
                if (horseDoesNotHaveRider(horsesRider, ridersFavorite)) {
                    horsesRider = setRiderToHorse(horsesRider, ridersFavorite);
                    favoriteHorseWasFree = true;
                    break;
                } else {
                    if (riderHasBetterScore(horsesRider, ridersFavorite)) {
                        freeRiders.add(getHorsesCurrentRider(horsesRider, ridersFavorite));
                        horsesRider = setRiderToHorse(horsesRider, ridersFavorite);
                        favoriteHorseWasFree = true;
                        break;
                    }
                }
            }
            if (!favoriteHorseWasFree) {
                for (int i = 0; i < horsesRider.length; i++) {
                    if (horsesRider[i] == null) {
                        horsesRider[i] = new Pair(horses[i], r, 
                                                  sc.calculateCompatibility(horses[i], r));
                        break;
                    }
                }
            }
        }
        return horsesRider;

    }

    /**
     * Returns horse's id from the pair
     * 
     * @param p horse-rider pair
     * @return id of the pairs horse
     */
    public int horseId(Pair p) {
        return p.getHorse().getId();
    }

    /**
     * Checks if the horse has a rider already
     * 
     * @param horsesRider array of the horses' riders. every index corresponds to
     *                    horses id.
     * @param p           pair which horse's rider is checked
     * @return true if horse has a rider, false if horse does not have a rider
     */
    public boolean horseDoesNotHaveRider(Pair[] horsesRider, Pair p) {
        return horsesRider[horseId(p) - 1] == null;
    }

    /**
     * set rider to the horse
     * 
     * @param horsesRider array of horses and their according riders. array's index
     *                    is horses id-1.
     * @param p           pair which horse's rider is set
     * @return updated array of horse's rider
     */
    public Pair[] setRiderToHorse(Pair[] horsesRider, Pair p) {
        horsesRider[horseId(p) - 1] = p;
        return horsesRider;
    }

    /**
     * Check what is the score of the horse's current rider
     * 
     * @param horsesRider array of all the horses riders
     * @param p           pair which horse's rider score is checked
     * @return score of the horse-rider combination
     */
    public double horsesCurrentRidersScore(Pair[] horsesRider, Pair p) {
        return horsesRider[horseId(p) - 1].getScore();
    }

    /**
     * Compares pairs score to the existing pair's score
     * 
     * @param horsesRider array of the all riders of the horses
     * @param p           pair which score is compared to
     * @return true if compared pairs p score is higher, false id already existing
     *         pair has a higher score
     */
    public boolean riderHasBetterScore(Pair[] horsesRider, Pair p) {
        return horsesCurrentRidersScore(horsesRider, p) < p.getScore();
    }

    /**
     * Returns the curren rider of the horse according to horsesRider array
     * 
     * @param horsesRider array where the horse's rider can be found
     * @param p           pair which horses rider is returned
     * @return rider of the horse according to horseRider array
     */
    public Rider getHorsesCurrentRider(Pair[] horsesRider, Pair p) {
        return horsesRider[p.getHorse().getId() - 1].getRider();
    }

}