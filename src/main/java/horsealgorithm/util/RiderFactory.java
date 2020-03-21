package horsealgorithm.util;

import horsealgorithm.domain.Rider;
import java.util.Random;

public class RiderFactory{

    private String[] names = {"Julius Meyer","Emmett Talley","Barry Ball",
        "Lsuther Meyer","Howard Miller","Jonathan Woodard","Marvin Blair","Keith Burgess",
        "Nathan Bates","Max Downs","Carolyn Reed","Edith Raymond","Virginia Byers",
        "Alice Gordon","Becky Mullins","Janice Johnston","Stacy Roach",
        "Dawn Butler","Jasmin Ryan","Peyton Mooney","Gene Jacobson","Woodrow Yates",
        "Dick Richardson","Louis McCoy","Vincent Keller","Lester Hamilton",
        "Micheal Jacobson","Jay Norton","Angel Galloway","Bryce Hyde"
    };

    private String[] skillLevels = {"easy", "intermediate", "advanced"};
    
    private String[] types = {"dressage", "show jumping", "kids", "cross country"};
   
    public Rider makeRider(){
        Random r = new Random();
        String riderName = this.names[r.nextInt(this.names.length)];
        String riderSkillLevel = this.skillLevels[r.nextInt(this.skillLevels.length)];
        int riderHeight = 100 + r.nextInt(96);
        String riderType = this.types[r.nextInt(this.types.length)];
        
        return new Rider(riderName, riderSkillLevel, riderHeight, riderType);
    }

}