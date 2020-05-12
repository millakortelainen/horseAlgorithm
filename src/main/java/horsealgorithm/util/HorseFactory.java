package horsealgorithm.util;

import horsealgorithm.domain.Horse;
import horsealgorithm.domain.SkillLevel;
import horsealgorithm.domain.Type;

/**
 * Horse Factory creates random horses.
 */
public class HorseFactory {

    private String[] names = { "Gomer", "Donkey", "Radio Flyer", 
        "Hoofer", "Lostma Cowboy", "Klip Klop", "Foalovit",
        "Clodhopper", "Waffle House", "Ed", "Bartholomew", 
        "LumberJack", "Bucktooth", "Loco", "Sir Topham Hatt",
        "General Tso", "Carrots", "Hall & Oats", "Overbite", 
        "Sprinkles", "Bandito", "Lollygagger", "Heisenberg",
        "Hemi", "Frankenstein", "Horsepower", "Moose", "Bing Bong", 
        "Rainbow Unicorn", "Rusty Saddle",
        "Transmission", "Crouching Tiger", "Cowboy", 
        "Jalopy", "Stable Boy", "Foxtrot" };

    private int lastID = 0;

    /**
     * Method to ceate a random horse.
     * 
     * @return randomly generated horse
     */
    public Horse makeHorse(Type t, SkillLevel sl, RandomGenerator rg) {
        String horseName = rg.getRandomName(names);
        SkillLevel horseSkillLevel = rg.getRandomSkillLevel(sl);
        int horseHeight = 100 + rg.randomNumber(96);
        Type horseType = rg.getRandomType(t);
        this.lastID++;
        return new Horse(lastID, horseName, horseSkillLevel, horseHeight, horseType);
    }

    /**
     * Creates as many horses as given as a parameter n.
     * 
     * @param n amount of created horses
     * @return Array of randomly generated horses.
     */
    public Horse[] makeHorses(int n, Type t, SkillLevel sl, RandomGenerator rg) {
        Horse[] horses = new Horse[n];
        for (int i = 0; i < n; i++) {
            horses[i] = makeHorse(t, sl, rg);
        }
        return horses;
    }

   
}