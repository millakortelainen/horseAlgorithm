package horsealgorithm.domain;

public class Rider implements Comparable<Rider> {
    private int id;
    private String name;
    private int skillLevel;
    private int height;
    private int type;
    private Pair[] favoriteHorses;

    public Rider(int id, String name, int skillLevel, int height, int type) {
        this.id = id;
        this.name = name;
        this.skillLevel = skillLevel;
        this.height = height;
        this.type = type;
        this.favoriteHorses = new Pair[3];
    }

    public Rider(int id) {
        this.id = id;
        this.name = "RiderName" + id;
        this.skillLevel = 999;
        this.height = 123;
        this.type = 999;
        this.favoriteHorses = new Pair[3];
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
    public int getSkillLevel() {
        return skillLevel;
    }

    /**
     * @return the type
     */
    public int getType() {
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
    public void setSkillLevel(int skillLevel) {
        this.skillLevel = skillLevel;
    }

    /**
     * @param type the type to set
     */
    public void setType(int type) {
        this.type = type;
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
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }

        if (!(o instanceof Rider)) {
            return false;
        }

        Rider r2 = (Rider) o;

        if (this.name.equals(r2.getName()) && this.id == r2.getId() && this.type == r2.getType()
                && this.skillLevel == r2.getSkillLevel() && this.height == r2.getHeight()) {
            return true;
        }

        return false;
    }

    public String toString() {
        String horses = "";
        for (int i = 0; i < favoriteHorses.length; i++) {
            if (favoriteHorses[i] == null) {
                horses += "No horse \n";
            } else {
                horses += favoriteHorses[i].getHorse().getName() + "\n";
            }
        }

        return "RIDER INFO: \n" + this.id + ". " + "Name: " + this.name + "\n" + "Skill Level: "
                + new SkillLevel().getSkillLevel(this.skillLevel) + "\n" + "Height: " + this.height + " cm \n"
                + "Type: " + new Type().getType(this.type) + "\nTop 3 horses: \n" + horses;
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