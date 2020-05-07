package horsealgorithm.domain;

public class Rider extends Node {
    private Pair[] favoriteHorses;

    /**
     * Constructor for rider with all parameters
     * 
     * @param id
     * @param name
     * @param skillLevel
     * @param height
     * @param type
     */
    public Rider(int id, String name, SkillLevel skillLevel, int height, Type type) {
        super(id, name, skillLevel, height, type);
        this.favoriteHorses = new Pair[3];
    }

    /**
     * Constructor for rider with automated parameters for testing
     * 
     * @param id
     */
    public Rider(int id) {
        super(id, "RiderName" + id, new SkillLevel(999), 123, new Type(999));
        this.favoriteHorses = new Pair[3];
    }

    /**
     * @param favoriteHorses the favoriteHorses to set
     */
    public void setFavoriteHorses(Pair[] favoriteHorses) {
        this.favoriteHorses = favoriteHorses;
    }

    /**
     * @return the favoriteHorses
     */
    public Pair[] getFavoriteHorses() {
        return favoriteHorses;
    }

    @Override
    public String toString() {

        String horses = "";
        for (int i = 0; i < favoriteHorses.length; i++) {
            if (favoriteHorses[i] == null) {
                horses += "No horse \n";
            } else {
                horses += favoriteHorses[i].getHorse().getName() + "\n";
            }
        }

        return "RIDER INFO: \n"
                + super.getId() + ". " + "Name: " + super.getName() + "\n"
                + "Skill Level: " + super.getSkillLevel() + "\n"
                + "Height: " + super.getHeight() + " cm \n"
                + "Type: " + super.getType() + "\n"
                + "Top 3 horses: \n" + horses;
    }

}