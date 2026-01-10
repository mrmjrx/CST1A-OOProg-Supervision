package uk.ac.cam.mr2083.sect5.oopdatastructures;

public interface OOPList {
    void insert(int val);
    void append(int val);
    int popFront();
    int length();
    int get(int idx) throws ArrayIndexOutOfBoundsException;

    default boolean isEmpty() {
        return length() == 0;
    }
}
