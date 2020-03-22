package horsealgorithm.util;

import horsealgorithm.domain.Horse;

import java.lang.reflect.Array;
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

    private String[] skillLevels = { "easy", "intermediate", "advanced" };

    private String[] types = { "dressage", "show jumping", "kids", "cross country" };

    /**
     * Method to ceate a random horse.
     * 
     * @return randomly generated horse
     */
    public Horse makeHorse() {
        Random r = new Random();
        String horseName = this.names[r.nextInt(this.names.length)];
        String horseSkillLevel = this.skillLevels[r.nextInt(this.skillLevels.length)];
        int horseHeight = 100 + r.nextInt(96);
        String horseType = this.types[r.nextInt(this.types.length)];

        return new Horse(horseName, horseSkillLevel, horseHeight, horseType);
    }

    /**
     * Creates as many horses as given as a parameter n.
     * 
     * @param n amount of created horses
     * @return ArrayList of randomly generated horses.
     */
    public ArrayList<Horse> makeHorses(int n) {
        ArrayList<Horse> horses = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            horses.add(this.makeHorse());
        }
        return horses;
    }

}