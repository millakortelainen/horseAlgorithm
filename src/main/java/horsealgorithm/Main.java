
package horsealgorithm;

import horsealgorithm.domain.SkillLevel;
import horsealgorithm.domain.Type;
import horsealgorithm.ui.UI;
import horsealgorithm.util.RandomGenerator;

class Main {
    public static void main(String[] args) {
         UI ui = new UI();
         ui.start(new SkillLevel(), new Type(), new RandomGenerator());
    }
}
