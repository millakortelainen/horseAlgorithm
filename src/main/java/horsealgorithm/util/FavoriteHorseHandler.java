package horsealgorithm.util;

import horsealgorithm.domain.Horse;
import horsealgorithm.domain.Pair;
import horsealgorithm.domain.Rider;

public class FavoriteHorseHandler {

    /**
     * Calculates which horses are going to be in rider's favorite horses. 
     * Rider's favorite horses are pair's that has the highest score with rider.
     * 
     * @param p pair which rider's favorite horses are assigned
     */
    public void setFavoritesToRider(Pair p) {
        Rider r = p.getRider();
        Horse h = p.getHorse();
        Pair[] favHorses = r.getFavoriteHorses();
        if (horseIsInFavorites(h, r)) {
            return;
        }
        if (emptySlotInFavorites(r)) {
            favHorses[indexOfFirstEmptyFavHorseSlot(r)] = p;
            r.setFavoriteHorses(favHorses);
            return;
        }
        double lowestScoreInRidersFavHorses = lowestScoreInRidersFavHorses(r);
        if (lowestScoreInRidersFavHorses < p.getScore()) {
            favHorses[indexOfTheLowestScoreHorse(r, lowestScoreInRidersFavHorses)] = p;
        }
    }

    /**
     * Check is the horse given as a parameter is already in rider's favorite horse.
     * 
     * @param h horse to compare
     * @param r rider whose favorite horses in focus
     * @return true if the horse was in favorite horses, false if horse wasn't in favorites
     */
    public boolean horseIsInFavorites(Horse h, Rider r) {
        for (Pair p : r.getFavoriteHorses()) {
            if (p != null) {
                if (h.equals(p.getHorse())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if there is empty spot in rider's favorite horses.
     * 
     * @param r rider which favorite horses are checkes
     * @return true if there was not assigned a favorite horse,
     *  false if the rider's favorite horses are full
     */
    public boolean emptySlotInFavorites(Rider r) {
        for (Pair p : r.getFavoriteHorses()) {
            if (p == null) {
                return true;
            }
        }
        return false;
    }

    /**
     * checks which slot of riders 3 favorite horse slots is free
     * 
     * @param r rider whom free horses are at review
     * @return index of the firs empty slot of the riders favorite horse array. 
     * if there is not empty slot returns -1.
     */
    public int indexOfFirstEmptyFavHorseSlot(Rider r) {
        for (int i = 0; i < r.getFavoriteHorses().length; i++) {
            if (r.getFavoriteHorses()[i] == null) {
                return i;
            }
        }
        return -1;
    }

    /**
     * goes through all the riders favorite horses and checks which horse has the lowest score
     * 
     * @param r rider whose horses are viewed
     * @return lowest score of the riders favorite horses
     */
    public double lowestScoreInRidersFavHorses(Rider r) {
        double score = 9999;
        for (Pair p : r.getFavoriteHorses()) {
            if (p.getScore() < score) {
                score = p.getScore();
            }
        }
        return score;
    }

    /**
     * returns index of the horse that has the lowest score. 
     * if there are many with same score then return first of them
     * 
     * @param r riders whom favorite hores are viewed
     * @param score lowest score of the horse
     * @return index of the horse that had the lowest score
     */
    public int indexOfTheLowestScoreHorse(Rider r, double score) {
        for (int i = 0; i < r.getFavoriteHorses().length; i++) {
            if (r.getFavoriteHorses()[i].getScore() == score) {
                return i;
            }
        }
        return -1;
    }

}