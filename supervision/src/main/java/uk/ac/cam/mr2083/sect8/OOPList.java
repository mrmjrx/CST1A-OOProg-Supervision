package uk.ac.cam.mr2083.sect8;

public interface OOPList<T> {
    void insert(T val);
    void append(T val);
    T popFront();
    int length();
    T get(int idx) throws ArrayIndexOutOfBoundsException;

    default boolean isEmpty() {
        return length() == 0;
    }
}
