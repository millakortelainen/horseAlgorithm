
package horsealgorithm;

import horsealgorithm.domain.*;
import horsealgorithm.util.HorseFactory;
import horsealgorithm.util.RiderFactory;
import horsealgorithm.util.MatchCalculator;
import java.util.*;

class Main {
    public static void main(String[] args) {
        ArrayList<Horse> horses = new ArrayList<>();
        ArrayList<Rider> riders = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            horses.add(new HorseFactory().makeHorse());
            riders.add(new RiderFactory().makeRider());
        }

        HashMap<Double, ArrayList<Pair<Horse, Rider>>> score = new HashMap<>();
        for (Horse h : horses) {
            for (Rider r : riders) {
                double i = new MatchCalculator().calculateCompatibility(h, r);
                Pair<Horse, Rider> p = new Pair<>();
                p.setPair(h, r);
                if (score.containsKey(i)) {
                    score.get(i).add(p);
                } else {
                    score.put(i, new ArrayList<>());
                    score.get(i).add(p);
                }
            }
        }
        for (Double key : score.keySet()) {
            System.out.println("Compatibility level " + key);
            for (Pair<Horse,Rider> p : score.get(key)) {
                System.out.println(p.getKey().getName()+", "+p.getValue().getName());
            }
            System.out.println("");
        }
    }
}
