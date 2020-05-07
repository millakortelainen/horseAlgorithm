package horsealgorithm.domain;

public class Type {
    private String[] types = { "dressage", "show jumping", "kids", "cross country" };
    private int numberOfType;

    /**
     * Constructor for type with parameters.
     * @param numberOfType number of the type
     */
    public Type(int numberOfType) {
        this.numberOfType = numberOfType;
    }

    /**
     * Constructor for type without parameters. 
     * Number of the type is set to 999.
     */
    public Type() {
        this.numberOfType = 999;
    }

    /**
     * Number of all type categories.
     * @return amount on types as a integer value
     */
    public int numberOfTypes() {
        return types.length;
    }

    /**
     * Gives type corresponding to the number from type array.
     * @param i number of the type
     * @return type category as a string
     */
    public String getType(int i) {
        if (i == 999) {
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

    /**
     * 
     * @return number of the type
     */
    public int getNumberOfType() {
        return this.numberOfType;
    }

    @Override
    public String toString() {
        return this.getType(this.getNumberOfType());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }

        if (!(o instanceof Type)) {
            return false;
        }

        Type t2 = (Type) o;

        if (this.numberOfType == t2.getNumberOfType()) {
            return true;
        }

        return false;
    }
}