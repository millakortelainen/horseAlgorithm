package horsealgorithm.util;

import horsealgorithm.domain.Rider;
import horsealgorithm.domain.SkillLevel;
import horsealgorithm.domain.Type;

import java.util.Random;

/**
 * Creates random riders from pool of names, skill-levels and types.
 */
public class RiderFactory {

    private String[] names = { "Julius Meyer", "Emmett Talley", "Barry Ball", 
        "Lsuther Meyer", "Howard Miller", "Jonathan Woodard", 
        "Marvin Blair", "Keith Burgess", "Nathan Bates", 
        "Max Downs", "Carolyn Reed", "Edith Raymond", 
        "Virginia Byers", "Alice Gordon", "Becky Mullins", 
        "Janice Johnston", "Stacy Roach", "Dawn Butler", 
        "Jasmin Ryan", "Peyton Mooney", "Gene Jacobson", 
        "Woodrow Yates", "Dick Richardson", "Louis McCoy", 
        "Vincent Keller", "Lester Hamilton", "Micheal Jacobson", 
        "Jay Norton", "Angel Galloway", "Bryce Hyde" };

    private int lastID = 0;

    /**
     * Creates rider with random parameters
     * @param sl skill levels of the simulation
     * @param t types of the simulation
     * @return created rider
     */
    public Rider makeRider(SkillLevel sl, Type t) {
        Random r = new Random();
        String riderName = this.names[r.nextInt(this.names.length)];
        SkillLevel riderSkillLevel = getRandomSkillLevel(sl);
        int riderHeight = 100 + r.nextInt(96);
        Type riderType = getRandomType(t);
        this.lastID++;
        return new Rider(lastID, riderName, riderSkillLevel, riderHeight, riderType);
    }

    /**
     * Creates n-amount of riders
     * 
     * @param n number of riders to be created
     * @param sl skill levels of the simulation
     * @param t types of the simulation
     * @return n-length array of randomly generated riders
     */
    public Rider[] makeRiders(int n, SkillLevel sl, Type t) {
        Rider[] riders = new Rider[n];
        for (int i = 0; i < n; i++) {
            riders[i] = makeRider(sl, t);
        }
        return riders;
    }

    /**
     * Creates a random skill level for the rider
     * 
     * @param sl all the skill levels of the simulation
     * @return randomly generated skill level
     */
    public SkillLevel getRandomSkillLevel(SkillLevel sl) {
        Random r = new Random();
        return new SkillLevel(1 + r.nextInt(sl.numberOfSkillLevels()));
    }

    /**
     * Creates a random type for the rider
     * 
     * @param t all the types of the simulation
     * @return randomly generated type
     */
    public Type getRandomType(Type t) {
        Random r = new Random();
        return new Type(1 + r.nextInt(t.numberOfTypes()));
    }


}