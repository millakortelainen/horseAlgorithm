package horsealgorithm.domain;

public class Rider implements Comparable<Rider>{
    private int id;
    private String name;
    private String skillLevel;
    private int height;
    private String type;
    private Horse[] favoriteHorses;

    public Rider(int id, String name, String skillLevel, int height, String type) {
        this.id = id;
        this.name = name;
        this.skillLevel = skillLevel;
        this.height = height;
        this.type = type;
        this.favoriteHorses = new Horse[3];
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the skillLevel
     */
    public String getSkillLevel() {
        return skillLevel;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param skillLevel the skillLevel to set
     */
    public void setSkillLevel(String skillLevel) {
        this.skillLevel = skillLevel;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @param favoriteHorses the favoriteHorses to set
     */
    public void setFavoriteHorses(Horse[] favoriteHorses) {
        this.favoriteHorses = favoriteHorses;
    }

    /**
     * @return the favoriteHorses
     */
    public Horse[] getFavoriteHorses() {
        return favoriteHorses;
    }

    public String toString() {
        String horses = "";
        for (int i = 0; i < favoriteHorses.length; i++) {
            if (favoriteHorses[i] == null) {
                horses += "NaN \n";
            } else {
                horses += favoriteHorses[i].getName() + "\n";
            }
        }
        return "RIDER INFO: \n" + this.id + ". " + "Name: " + this.name + "\n" + "Skill Level: " + this.skillLevel
                + "\n" + "Height: " + this.height + " cm \n" + "Type: " + this.type + "\nTop 3 horses: \n" + horses;
    }

    @Override
    public int compareTo(Rider r) {
        if (this.id == r.getId()) {
            return 0;
        }
        if (this.id > r.getId()) {
            return 1;
        }
        return -1;
    }

}