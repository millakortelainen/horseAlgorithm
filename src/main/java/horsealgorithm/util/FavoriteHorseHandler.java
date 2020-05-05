package horsealgorithm.util;

import horsealgorithm.domain.*;

public class FavoriteHorseHandler {
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

    public boolean emptySlotInFavorites(Rider r) {
        for (Pair p : r.getFavoriteHorses()) {
            if (p == null) {
                return true;
            }
        }
        return false;
    }

    public int indexOfFirstEmptyFavHorseSlot(Rider r) {
        for (int i = 0; i < r.getFavoriteHorses().length; i++) {
            if (r.getFavoriteHorses()[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public double lowestScoreInRidersFavHorses(Rider r) {
        double score = 9999;
        for (Pair p : r.getFavoriteHorses()) {
            if (p.getScore() < score) {
                score = p.getScore();
            }
        }
        return score;
    }

    public int indexOfTheLowestScoreHorse(Rider r, double score) {
        for (int i = 0; i < r.getFavoriteHorses().length; i++) {
            if (r.getFavoriteHorses()[i].getScore() == score) {
                return i;
            }
        }
        return -1;
    }

}