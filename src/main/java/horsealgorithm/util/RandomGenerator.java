package horsealgorithm.util;

import horsealgorithm.domain.SkillLevel;
import horsealgorithm.domain.Type;

public class RandomGenerator {

    /**
     * Gives random number from 0 to max-1. 
     * Uses System.nanoTime() for concluding the number.
     * 
     * @param max excludin upper bounder
     * @return random integer number
     */
    public int randomNumber(int max) {
        long l = System.nanoTime() % max;
        return (int) l;
    }
    
    /**
     * Returns random name from the list of given names
     * 
     * @param names names as a string array
     * @return name as a string
     */
    public String getRandomName(String[] names) {
        return names[randomNumber(names.length)];
    }

    /**
     * Gives random type from type values.
     * 
     * @param t Types in Type class
     * @return new type with randomly generated value
     */
    public Type getRandomType(Type t) {
        return new Type(1 + randomNumber(t.numberOfTypes()));
    }

    /**
     * Randomly generates skill level
     * 
     * @param sl SkillLevel objct containing the skill levels
     * @return randomly generated skill level
     */
    public SkillLevel getRandomSkillLevel(SkillLevel sl) {
        return new SkillLevel(1 + randomNumber(sl.numberOfSkillLevels()));
    }

}