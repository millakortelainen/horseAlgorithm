package horsealgorithm.domain;

public class Type {
    private String[] types = { "dressage", "show jumping", "kids", "cross country" };

    public int numberOfTypes() {
        return types.length;
    }

    public String getType(int i) {
        if(i==999){
            return "Test";
        }
        if (i > types.length) {
            return "No such type";
        }
        return types[i - 1];
    }

    /**
     * @return the types
     */
    public String[] getTypes() {
        return types;
    }

    /**
     * @param types the types to set
     */
    public void setTypes(String[] types) {
        this.types = types;
    }
}