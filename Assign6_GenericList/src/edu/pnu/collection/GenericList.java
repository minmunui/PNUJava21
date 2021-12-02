package edu.pnu.collection;

public class GenericList<T> {
    private static final int DEFAULT_SiZE = 10;
    private T[] data;
    private int size = 0;
    private int cursor = 0;

    public GenericList() {
        this.data = (T[]) new Object[DEFAULT_SiZE];
        this.size = DEFAULT_SiZE;
    }

    public GenericList(int size) {
        this.data = (T[]) new Object[size];
        this.size = size;
    }

    public void addObject(T objectToAdd) {
        this.data[cursor] = objectToAdd;
        cursor ++;
    }

    public void clear() {
        this.data = (T[]) new Object[size];
        cursor = 0;
    }

    public T findObject(T objectToFind) {
        for ( int i = 0 ; i < size ; i ++ ) {
            if ( objectToFind.equals(this.data[i])){
                return this.data[i];
            }
        }
        return null;
    }

    public T[] values() {
        return this.data;
    }

    public int size() {
        return this.cursor;
    }

    public String toString() {
        String stringToReturn = "";
        for ( T i : this.data) {
            if ( i != null )
                stringToReturn+=i.toString()+"\n";
        }
        return stringToReturn;
    }
}
