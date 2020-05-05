package horsealgorithm.domain;

public class SkillLevel {
    private String[] skillLevels = { "easy", "intermediate", "advanced" };

    public int numberOfSkillLevels() {
        return skillLevels.length;
    }

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
}