package horsealgorithm.util;

import horsealgorithm.domain.*;
import java.util.*;

/**
 * Class Match Calculator is a calculator which calculates scores of horse-rider
 * pairs.
 */
public class MatchCalculator {

    FavoriteHorseHandler FHH;
    ScoreCalculator SC;

    public MatchCalculator(FavoriteHorseHandler FHH) {
        this.FHH = FHH;
    }

    public MatchCalculator() {
        this.FHH = new FavoriteHorseHandler();
        this.SC = new ScoreCalculator();
    }

    /**
     * Calculates score to all given riders and horses.
     * 
     * @param list all horse-rider pairs to be calculated.
     * @return HashMap where the key is compatibility score.
     */
    public Pair[] calculateAllScores(Pair[] pairs) {

        for (Pair p : pairs) {
            double score = SC.calculateCompatibility(p.getHorse(), p.getRider());
            p.setScore(score);
            FHH.setFavoritesToRider(p);
        }
        return pairs;
    }

    public Pair[] GSAlgorithmForPairing(Horse[] horses, Rider[] riders) {

        Pair[] horsesRider = new Pair[horses.length];

        ArrayDeque<Rider> freeRiders = new ArrayDeque<>();

        for (Rider rider : riders) {
            freeRiders.add(rider);
        }

        while (!freeRiders.isEmpty()) {
            Rider r = freeRiders.poll();
            for (int i = 0; i < 3; i++) {
                Pair ridersFavorite = r.getFavoriteHorses()[i];
                if (ridersFavorite == null) {
                    continue;
                }
                if (horseDoesNotHaveRider(horsesRider, ridersFavorite)) {
                    horsesRider = setRiderToHorse(horsesRider, ridersFavorite);
                    break;
                } else {
                    if (riderHasBetterScore(horsesRider, ridersFavorite)) {
                        freeRiders.add(getHorsesCurrentRider(horsesRider, ridersFavorite));
                        horsesRider = setRiderToHorse(horsesRider, ridersFavorite);
                        break;
                    }
                }
            }
        }
        return horsesRider;

    }

    public int horseId(Pair p) {
        return p.getHorse().getId();
    }

    public boolean horseDoesNotHaveRider(Pair[] horsesRider, Pair p) {
        return horsesRider[horseId(p) - 1] == null;
    }

    public Pair[] setRiderToHorse(Pair[] horsesRider, Pair p) {
        horsesRider[horseId(p) - 1] = p;
        return horsesRider;
    }

    public double horsesCurrentRidersScore(Pair[] horsesRider, Pair p) {
        return horsesRider[horseId(p) - 1].getScore();
    }

    public boolean riderHasBetterScore(Pair[] horsesRider, Pair p) {
        return horsesCurrentRidersScore(horsesRider, p) < p.getScore();
    }

    public Rider getHorsesCurrentRider(Pair[] horsesRider, Pair p) {
        return horsesRider[p.getHorse().getId() - 1].getRider();
    }

}