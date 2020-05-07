package horsealgorithm.util;

import horsealgorithm.domain.Horse;
import horsealgorithm.domain.SkillLevel;
import horsealgorithm.domain.Type;
import java.util.Random;

/**
 * Horse Factory creates random horses.
 */
public class HorseFactory {

    private String[] names = { "Gomer", "Donkey", "Radio Flyer", "Hoofer",
        "Lostma Cowboy", "Klip Klop", "Foalovit",
        "Clodhopper", "Waffle House", "Ed",
        "Bartholomew", "LumberJack", "Bucktooth",
        "Loco", "Sir Topham Hatt", "General Tso",
        "Carrots", "Hall & Oats", "Overbite", 
        "Sprinkles", "Bandito", "Lollygagger", 
        "Heisenberg", "Hemi", "Frankenstein", 
        "Horsepower", "Moose", "Bing Bong", 
        "Rainbow Unicorn", "Rusty Saddle", "Transmission", 
        "Crouching Tiger", "Cowboy", "Jalopy", 
        "Stable Boy", "Foxtrot" };

    private int lastID = 0;

    /**
     * Method to ceate a random horse.
     * 
     * @return randomly generated horse
     */
    public Horse makeHorse(Type t, SkillLevel sl) {
        Random r = new Random();
        String horseName = this.names[r.nextInt(this.names.length)];
        SkillLevel horseSkillLevel = getRandomSkillLevel(sl);
        int horseHeight = 100 + r.nextInt(96);
        Type horseType = getRandomType(t);
        this.lastID++;
        return new Horse(lastID, horseName, horseSkillLevel, horseHeight, horseType);
    }

    /**
     * Creates as many horses as given as a parameter n.
     * 
     * @param n amount of created horses
     * @return Array of randomly generated horses.
     */
    public Horse[] makeHorses(int n, Type t, SkillLevel sl) {
        Horse[] horses = new Horse[n];
        for (int i = 0; i < n; i++) {
            horses[i] = makeHorse(t, sl);
        }
        return horses;
    }

    /**
     * Returns one random skill level from all the possible skill levels.
     * 
     * @param sl all the skill levels that can be selected
     * @return random skill level of all skill levels
     */
    public SkillLevel getRandomSkillLevel(SkillLevel sl) {
        Random r = new Random();
        return new SkillLevel(1 + r.nextInt(sl.numberOfSkillLevels()));
    }

    /**
     * Returns one random type for horse from all possible types
     * @param t all possible types
     * @return randomly generated type
     */
    public Type getRandomType(Type t) {
        Random r = new Random();
        return new Type(1 + r.nextInt(t.numberOfTypes()));
    }

}