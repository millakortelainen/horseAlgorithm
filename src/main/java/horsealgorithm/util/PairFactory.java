package horsealgorithm.util;

import java.util.*;
import horsealgorithm.domain.*;

public class PairFactory {

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