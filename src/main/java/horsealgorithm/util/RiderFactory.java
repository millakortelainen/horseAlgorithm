package horsealgorithm.util;

import horsealgorithm.domain.*;

import java.util.*;

/**
 * Creates random riders from pool of names, skill-levels and types.
 */
public class RiderFactory {

    private String[] names = { "Julius Meyer", "Emmett Talley", "Barry Ball", "Lsuther Meyer", "Howard Miller",
            "Jonathan Woodard", "Marvin Blair", "Keith Burgess", "Nathan Bates", "Max Downs", "Carolyn Reed",
            "Edith Raymond", "Virginia Byers", "Alice Gordon", "Becky Mullins", "Janice Johnston", "Stacy Roach",
            "Dawn Butler", "Jasmin Ryan", "Peyton Mooney", "Gene Jacobson", "Woodrow Yates", "Dick Richardson",
            "Louis McCoy", "Vincent Keller", "Lester Hamilton", "Micheal Jacobson", "Jay Norton", "Angel Galloway",
            "Bryce Hyde" };

    private int lastID = 0;

    public Rider makeRider(SkillLevel sl, Type t) {
        Random r = new Random();
        String riderName = this.names[r.nextInt(this.names.length)];
        int riderSkillLevel = 1 + r.nextInt(sl.numberOfSkillLevels());
        int riderHeight = 100 + r.nextInt(96);
        int riderType = 1 + r.nextInt(t.numberOfTypes());
        this.lastID++;
        return new Rider(lastID, riderName, riderSkillLevel, riderHeight, riderType);
    }

    public Rider[] makeRiders(int n) {
        Rider[] riders = new Rider[n];
        for (int i = 0; i < n; i++) {
            riders[i] = makeRider(new SkillLevel(), new Type());
        }
        return riders;
    }

}