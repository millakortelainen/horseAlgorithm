package horsealgorithm.domain;

public class Type {
    private String[] types = { "dressage", "show jumping", "kids", "cross country" };
    private int numberOfType;

    public Type(int numberOfType){
        this.numberOfType = numberOfType;
    }

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

    public int getNumberOfType(){
        return this.numberOfType;
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