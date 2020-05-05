package horsealgorithm.util;

import horsealgorithm.domain.*;
import java.util.*;

/**
 * Horse Factory creates random horses.
 */
public class HorseFactory {

    private String[] names = { "Gomer", "Donkey", "Radio Flyer", "Hoofer", "Lostma Cowboy", "Klip Klop", "Foalovit",
            "Clodhopper", "Waffle House", "Ed", "Bartholomew", "LumberJack", "Bucktooth", "Loco", "Sir Topham Hatt",
            "General Tso", "Carrots", "Hall & Oats", "Overbite", "Sprinkles", "Bandito", "Lollygagger", "Heisenberg",
            "Hemi", "Frankenstein", "Horsepower", "Moose", "Bing Bong", "Rainbow Unicorn", "Rusty Saddle",
            "Transmission", "Crouching Tiger", "Cowboy", "Jalopy", "Stable Boy", "Foxtrot" };

    private int lastID = 0;

    /**
     * Method to ceate a random horse.
     * 
     * @return randomly generated horse
     */
    public Horse makeHorse(Type t, SkillLevel sl) {
        Random r = new Random();
        String horseName = this.names[r.nextInt(this.names.length)];
        int horseSkillLevel = 1 + r.nextInt(sl.numberOfSkillLevels());
        int horseHeight = 100 + r.nextInt(96);
        int horseType = 1 + r.nextInt(t.numberOfTypes());
        this.lastID++;
        return new Horse(lastID, horseName, horseSkillLevel, horseHeight, horseType);
    }

    /**
     * Creates as many horses as given as a parameter n.
     * 
     * @param n amount of created horses
     * @return Array of randomly generated horses.
     */
    public Horse[] makeHorses(int n) {
        Horse[] horses = new Horse[n];
        for (int i = 0; i < n; i++) {
            horses[i] = makeHorse(new Type(), new SkillLevel());
        }
        return horses;
    }

}