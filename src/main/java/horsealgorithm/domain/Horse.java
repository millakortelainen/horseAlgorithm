package horsealgorithm.domain;

public class Horse {
    private int id;
    private String name;
    private String skillLevel;
    private int height;
    private String type;

    public Horse(int id, String name, String skillLevel, int height, String type) {
        this.id = id;
        this.name = name;
        this.skillLevel = skillLevel;
        this.height = height;
        this.type = type;
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
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
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
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Horse)) {
            return false;
        }

        Horse horse2 = (Horse) o;

        if (this.name.equals(horse2.getName()) 
            && this.id == horse2.getId() 
            && this.type.equals(horse2.getType()) 
            && this.skillLevel.equals(horse2.getSkillLevel()) 
            && this.height == horse2.getHeight()) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "HORSE INFO: \n" + this.id + ". " + "Name: " + this.name + "\n" + "Skill Level: " + this.skillLevel
                + "\n" + "Height: " + this.height + " cm \n" + "Type: " + this.type;
    }

}