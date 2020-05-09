package horsealgorithm.util;

import horsealgorithm.domain.SkillLevel;
import horsealgorithm.domain.Type;

public class RandomGenerator {

    public int randomNumber(int max) {
        long l = System.nanoTime() % max;
        return (int) l;
    }

    public String getRandomName(String[] names) {
        return names[randomNumber(names.length)];
    }

    public Type getRandomType(Type t) {
        return new Type(1 + randomNumber(t.numberOfTypes()));
    }

    public SkillLevel getRandomSkillLevel(SkillLevel sl) {
        return new SkillLevel(1 + randomNumber(sl.numberOfSkillLevels()));
    }

}