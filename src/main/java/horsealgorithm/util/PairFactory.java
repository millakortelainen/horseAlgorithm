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
    public ArrayList<Pair> pairAll(ArrayList<Horse> horses, ArrayList<Rider> riders) {
        ArrayList<Pair> pairs = new ArrayList<>();
        for (Horse h : horses) {
            for (Rider r : riders) {
                Pair p = new Pair(h, r);
                pairs.add(p);
            }
        }
        return pairs;
    }
}