package horsealgorithm.domain;

public class Horse implements Comparable<Horse> {
    private int id;
    private String name;
    private int skillLevel;
    private int height;
    private int type;

    public Horse(int id, String name, int skillLevel, int height, int type) {
        this.id = id;
        this.name = name;
        this.skillLevel = skillLevel;
        this.height = height;
        this.type = type;
    }

    public Horse(int id) {
        this.id = id;
        this.name = "HorseName" + id;
        this.skillLevel = 999;
        this.height = 155;
        this.type = 999;
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
    public void setSkillLevel(int skillLevel) {
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
    public void setType(int type) {
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
    public int getSkillLevel() {
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
    public int getType() {
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
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }

        if (!(o instanceof Horse)) {
            return false;
        }

        Horse horse2 = (Horse) o;

        if (this.name.equals(horse2.getName()) && this.id == horse2.getId() && this.type == horse2.getType()
                && this.skillLevel == horse2.getSkillLevel() && this.height == horse2.getHeight()) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {

        return "HORSE INFO: \n" + this.id + ". " + "Name: " + this.name + "\n" + "Skill Level: "
                + new SkillLevel().getSkillLevel(this.skillLevel) + "\n" + "Height: " + this.height + " cm \n"
                + "Type: " + new Type().getType(this.type);
    }

    @Override
    public int compareTo(Horse h) {
        if (this.id == h.getId()) {
            return 0;
        }
        if (this.id > h.getId()) {
            return 1;
        }
        return -1;
    }

}