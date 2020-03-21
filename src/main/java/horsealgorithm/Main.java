
package horsealgorithm;

import horsealgorithm.domain.Horse;
import horsealgorithm.util.HorseFactory;

class Main{
    public static void main(String[] args) {
        Horse h = new HorseFactory().makeHorse();
        System.out.println(h);
    }
}
