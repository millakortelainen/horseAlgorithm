package horsealgorithm.domain;

public class Horse extends Node {


    /**
     * Constructor for horse with all parameters
     */
    public Horse(int id, String name, SkillLevel skillLevel, int height, Type type) {
        super(id, name, skillLevel, height, type);
    }

    /**
     * Constructor for horse with parameter id,
     * all other parameters are generated. 
     * For testing purposes.
     */
    public Horse(int id) {
        super(id, "HorseName" + id, new SkillLevel(999), 155, new Type(999));
    }

    @Override
    public String toString() {

        return "HORSE INFO: \n" 
                + super.getId() + ". " + "Name: " + super.getName() + "\n"
                + "Skill Level: " + super.getSkillLevel() + "\n" 
                + "Height: " + super.getHeight() + " cm \n"
                + "Type: " + super.getType();
    }
}