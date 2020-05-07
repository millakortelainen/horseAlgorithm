package horsealgorithm.util;

import java.util.*;
import horsealgorithm.domain.*;

/**
 * Pairs up horses and riders;
 */
public class PairFactory {

    /**
     * Pairs up all the riders and horses. For every rider is given every horse.
     * 
     * @param horses horses to be paired
     * @param riders riders to be paired
     * @return ArrayList of horse-rider pairs.
     */
    public Pair[] pairAll(Horse[] horses, Rider[] riders) {
        Pair[] pairs = new Pair[amountOfPairs(horses.length, riders.length)];
        int i = 0;
        for (Horse h : horses) {
            for (Rider r : riders) {
                pairs[i] = new Pair(h, r);
                i++;
            }
        }
        return pairs;
    }

    private int amountOfPairs(int n, int m) {
        return n * m;
    }

}