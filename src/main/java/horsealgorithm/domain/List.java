package horsealgorithm.domain;

public class List<T> {

    private T[] values;
    private int size;

    public List(){
        this.values = (T[]) new Object[10];
        this.size = 0;
    }
    public void add(T value) {
        if(this.size == this.values.length) {
            increaseSize();
        }
        this.values[this.size] = value;
        this.size++; 
    }
    private void increaseSize() {
        int newSize = this.values.length + this.values.length / 2;
        T[] t = (T[]) new Object[newSize];
        for (int i = 0; i < this.values.length; i++) {
            t[i] = this.values[i];
        }
    
        this.values = t;
    }

    public int size(){
        return this.size;
    }
}