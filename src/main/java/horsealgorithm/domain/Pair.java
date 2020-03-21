package horsealgorithm.domain;

public class Pair<V, T> {
    private V key;
    private T value;

    public void setPair(V key, T value){
        this.key = key;
        this.value = value;
    }

    public V getKey(){
        return key;
    }

    public T getValue(){
        return value;
    }

    @Override
    public String toString() {
        return "" + key + ", " + value + "";
    }
}