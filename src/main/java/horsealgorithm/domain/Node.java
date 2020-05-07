package horsealgorithm.domain;

public class Node {
    private int id;
    private String name;
    private SkillLevel skillLevel;
    private int height;
    private Type type;

    /**
     * Constructor for node with all parameters
     */
    public Node(int id, String name, SkillLevel skillLevel, int height, Type type) {
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
    public void setSkillLevel(SkillLevel skillLevel) {
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
    public void setType(Type type) {
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
    public SkillLevel getSkillLevel() {
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
    public Type getType() {
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

        if (!(o instanceof Node)) {
            return false;
        }

        Node n2 = (Node) o;

        if (this.id == n2.getId()
                && this.name.equals(n2.getName())
                && this.skillLevel.equals(n2.getSkillLevel())
                && this.getType().equals(n2.getType())
                && this.height == n2.getHeight()) {
            return true;
        }

        return false;
    }

}