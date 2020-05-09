package horsealgorithm.domain;

import java.util.Arrays;

public class Stack<T> {
    private T[] values;
    private int lastValueIndex;

    /**
     * Constructor for stack data structure
     */
    public Stack() {
        this.values = (T[]) new Object[10];
        this.lastValueIndex = 0;
    }

    /**
     * Adds given value to firs free index in array.
     * If the array is full, 
     * then doubles array's size.
     * 
     * @param value value that will be added to list
     */
    public void add(T value) {
        if (this.lastValueIndex + 1 == this.values.length) {
            T[] newValues = (T[]) new Object[this.values.length * 2];
            this.values = this.copyArray(newValues);
        }
        this.values[this.lastValueIndex + 1] = value;
        this.lastValueIndex++;
    }

    /**
     * Gives last value of the array.
     * If array is empty, return null.
     * 
     * @return last values of the values array
     */
    public T poll() {
        if (this.isEmpty()) {
            return null;
        }

        if (this.lastValueIndex == values.length / 2) {
            T[] newValues = (T[]) new Object[(values.length / 2) + 1];
            this.values = this.copyArray(newValues);
        }
        T value = values[this.lastValueIndex];
        values[this.lastValueIndex] = null;
        this.lastValueIndex--;
        return value;
    }

    /**
     * Checks if the array contains any values
     * 
     * @return true if array does not contain values, false if the array contains
     *         values
     */
    public boolean isEmpty() {
        if (this.lastValueIndex == 0) {
            return true;
        }
        return false;
    }

    /**
     * Gives amount of values in array.
     * 
     * @return number of values in array.
     */
    public int size() {
        return this.lastValueIndex;
    }

    /**
     * Copies values of the array to the new given array.
     * 
     * @param newValues the array to copy
     * @return new array with same values as in old values array
     */
    private T[] copyArray(T[] newValues) {
        for (int i = 0; i <= this.lastValueIndex; i++) {
            newValues[i] = values[i];
        }
        return newValues;
    }

}