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
    public ArrayList<Pair<Horse, Rider>> pairAll(ArrayList<Horse> horses, ArrayList<Rider> riders) {
        ArrayList<Pair<Horse, Rider>> pairs = new ArrayList<>();
        for (Horse h : horses) {
            for (Rider r : riders) {
                Pair<Horse, Rider> p = new Pair<>();
                p.setPair(h, r);
                pairs.add(p);
            }
        }
        return pairs;
    }
}