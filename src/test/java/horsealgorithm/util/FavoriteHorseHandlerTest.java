package horsealgorithm.util;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

import horsealgorithm.domain.Horse;
import horsealgorithm.domain.Pair;
import horsealgorithm.domain.Rider;

public class FavoriteHorseHandlerTest {

    FavoriteHorseHandler FHH;
    Rider r1;
    Rider r2;
    Rider r3;
    Horse h1;
    Horse h2;
    Horse h3;
    Horse h4;

    @Before
    public void setUp() {
        FHH = new FavoriteHorseHandler();

        r1 = new Rider(1);
        r2 = new Rider(2);
        r3 = new Rider(3);

        h1 = new Horse(1);
        h2 = new Horse(2);
        h3 = new Horse(3);
        h4 = new Horse(4);

    }

    @Test
    public void setOneRiderFavoriteHorsesTest() {
        Pair p1 = new Pair(h1, r1, 1.0);
        Pair p2 = new Pair(h2, r1, 1.0);
        Pair p3 = new Pair(h3, r1, 1.0);
        FHH.setFavoritesToRider(p1);
        boolean h1IsFavorite = false;
        for (Pair p : r1.getFavoriteHorses()) {
            if (p != null) {
                if (h1.equals(p.getHorse())) {
                    h1IsFavorite = true;
                }
            }
        }
        assertTrue(h1IsFavorite);
        h1IsFavorite = false;

        FHH.setFavoritesToRider(p2);
        boolean h2IsFavorite = false;
        for (Pair p : r1.getFavoriteHorses()) {
            if (p != null) {
                if (h1.equals(p.getHorse())) {
                    h1IsFavorite = true;
                }
                if (h2.equals(p.getHorse())) {
                    h2IsFavorite = true;
                }
            }
        }
        assertTrue(h1IsFavorite);
        assertTrue(h2IsFavorite);
        h1IsFavorite = false;
        h2IsFavorite = false;

        FHH.setFavoritesToRider(p3);
        boolean h3IsFavorite = false;
        for (Pair p : r1.getFavoriteHorses()) {
            if (h1.equals(p.getHorse())) {
                h1IsFavorite = true;
            }
            if (h2.equals(p.getHorse())) {
                h2IsFavorite = true;
            }
            if (h3.equals(p.getHorse())) {
                h3IsFavorite = true;
            }
        }
        assertTrue(h1IsFavorite);
        assertTrue(h2IsFavorite);
        assertTrue(h3IsFavorite);
    }

    @Test
    public void favoritesAreSetForThreeRiders() {
        Rider[] riders = { r1, r2, r3 };
        Horse[] horses = { h1, h2, h3 };

        Pair[] pairs = new PairFactory().pairAll(horses, riders);
        for (Pair p : pairs) {
            FHH.setFavoritesToRider(p);
        }
        boolean ridersPass = false;

        for (Rider r : riders) {
            boolean containsH1 = false;
            boolean containsH2 = false;
            boolean containsH3 = false;
            for (Pair p : r.getFavoriteHorses()) {
                if (h1.equals(p.getHorse())) {
                    containsH1 = true;
                }
                if (h2.equals(p.getHorse())) {
                    containsH2 = true;
                }
                if (h3.equals(p.getHorse())) {
                    containsH3 = true;
                }
            }
            if (!containsH1 || !containsH2 || !containsH3) {
                ridersPass = false;
            } else {
                ridersPass = true;
            }
        }
        assertTrue(ridersPass);
    }

    @Test
    public void ridersGetBestScoreAsFavHorse() {

        Pair p1 = new Pair(h1, r1, 1.0);
        Pair p2 = new Pair(h2, r1, 0.8);
        Pair p3 = new Pair(h3, r1, 0.6);
        Pair p4 = new Pair(h4, r1, 1.0);

        FHH.setFavoritesToRider(p1);
        FHH.setFavoritesToRider(p2);
        FHH.setFavoritesToRider(p3);
        FHH.setFavoritesToRider(p4);
        boolean h1isFav = false;
        boolean h2isFav = false;
        boolean h4isFav = false;
        for (Pair p : r1.getFavoriteHorses()) {
            if (h1.equals(p.getHorse())) {
                h1isFav = true;
            }
            if (h2.equals(p.getHorse())) {
                h2isFav = true;
            }
            if (h4.equals(p.getHorse())) {
                h4isFav = true;
            }
        }
        boolean pass = false;
        if (h1isFav && h2isFav && h4isFav) {
            pass = true;
        }
        System.out.print(r1);
        assertTrue(pass);
    }

    @Test
    public void horseIsInFavoritesTest() {

        Pair p1 = new Pair(h1, r1, 1.0);
        Pair p2 = new Pair(h2, r1, 8.0);
        Pair p3 = new Pair(h3, r1, 6.0);
        Pair[] favHorses = { p1, p2, p3 };
        r1.setFavoriteHorses(favHorses);
        assertTrue(FHH.horseIsInFavorites(h1, r1));
        assertFalse(FHH.horseIsInFavorites(h4, r1));
    }

    @Test
    public void emptySlotInFavoritesTest() {
        Rider r1 = new Rider(1);
        assertTrue(FHH.emptySlotInFavorites(r1));
        Horse h1 = new Horse(1);
        Horse h2 = new Horse(2);
        Horse h3 = new Horse(3);

        Pair p1 = new Pair(h1, r1, 1.0);
        Pair p2 = new Pair(h2, r1, 8.0);
        Pair p3 = new Pair(h3, r1, 6.0);
        Pair[] favHorses = { p1, p2, null };
        r1.setFavoriteHorses(favHorses);
        assertTrue(FHH.emptySlotInFavorites(r1));
        favHorses[2] = p3;
        r1.setFavoriteHorses(favHorses);
        assertFalse(FHH.emptySlotInFavorites(r1));
    }

    @Test
    public void indexOfFirstEmptyFavHorseSlotTest() {
        assertEquals(0, FHH.indexOfFirstEmptyFavHorseSlot(r1));

        Pair p1 = new Pair(h1, r1, 1.0);
        Pair[] favHorses = { p1, null, null };
        r1.setFavoriteHorses(favHorses);
        assertEquals(1, FHH.indexOfFirstEmptyFavHorseSlot(r1));

        Pair p2 = new Pair(h2, r1, 0.8);
        favHorses[1] = p2;
        r1.setFavoriteHorses(favHorses);
        assertEquals(2, FHH.indexOfFirstEmptyFavHorseSlot(r1));

        Pair p3 = new Pair(h3, r1, 0.6);
        favHorses[2] = p3;
        r1.setFavoriteHorses(favHorses);
        assertEquals(-1, FHH.indexOfFirstEmptyFavHorseSlot(r1));
    }

    @Test
    public void lowestScoreInRidersFavHorsesTest() {
        Pair p1 = new Pair(h1, r1, 1.0);
        Pair p2 = new Pair(h2, r1, 0.8);
        Pair p3 = new Pair(h3, r1, 0.6);

        Pair[] favHorses = { p1, p2, p3 };
        r1.setFavoriteHorses(favHorses);
        assertEquals(0.6, FHH.lowestScoreInRidersFavHorses(r1), 0.0001);
    }

    @Test
    public void indexOfLowestScoreHorseTest() {
        Pair p1 = new Pair(h1, r1, 1.0);
        Pair p2 = new Pair(h2, r1, 0.8);
        Pair p3 = new Pair(h3, r1, 0.6);

        Pair[] favHorses = { p1, p2, p3 };
        r1.setFavoriteHorses(favHorses);
        assertEquals(2, FHH.indexOfTheLowestScoreHorse(r1, 0.6));

        Pair p4 = new Pair(h3, r1, 1.0);
        favHorses[2] = p4;
        r1.setFavoriteHorses(favHorses);
        assertEquals(1, FHH.indexOfTheLowestScoreHorse(r1, 0.8));

    }
}