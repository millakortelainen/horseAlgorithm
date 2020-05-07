package horsealgorithm.domain;

public class SkillLevel {
    private String[] skillLevels = { "easy", "intermediate", "advanced" };
    private int skillLevelNumber;

    /**
     * Constructor for skill level with parameter number.
     * 
     * @param number integer value of the skilllevel
     */
    public SkillLevel(int number) {
        this.skillLevelNumber = number;
    }

    /**
     * Contructor for skill level without parameters. 
     * Skill level is set to 999.
     */
    public SkillLevel() {
        this.skillLevelNumber = 999;
    }

    /**
     * return amoun of differen skill levels
     * @return number of skill levels as an integer
     */
    public int numberOfSkillLevels() {
        return skillLevels.length;
    }

    /**
     * Get skill level as string corresponding to number of skill level.
     * @param i number of the skill level
     * @return skill level as a string
     */
    public String getSkillLevel(int i) {
        if (i == 999) {
            return "Test";
        }
        if (i > skillLevels.length) {
            return "No such skill level";
        }
        return skillLevels[i - 1];
    }

    /**
     * @return the skillLevels
     */
    public String[] getSkillLevels() {
        return skillLevels;
    }

    /**
     * @param skillLevels the skillLevels to set
     */
    public void setSkillLevels(String[] skillLevels) {
        this.skillLevels = skillLevels;
    }

    /**
     * @return getter for skill level number
     */
    public int getSkillLevelNumber() {
        return this.skillLevelNumber;
    }

    @Override
    public String toString() {
        return this.getSkillLevel(this.skillLevelNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }

        if (!(o instanceof SkillLevel)) {
            return false;
        }

        SkillLevel sl2 = (SkillLevel) o;

        if (this.skillLevelNumber == sl2.getSkillLevelNumber()) {
            return true;
        }

        return false;
    }
}