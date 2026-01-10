package uk.ac.cam.mr2083.sect5.oopdatastructures;

public class OOPArrayList implements OOPList {
    public final int GROWTH_FACTOR = 2;

    private int capacity = 4;
    private int length = 0;

    private int[] arr = new int[capacity];

    private void reallocateArray(int requiredCapacity) {
        if (requiredCapacity <= capacity) return;
        int newCapacity = Math.max(GROWTH_FACTOR * capacity, requiredCapacity);
        int[] newArr = new int[newCapacity];
        this.capacity = newCapacity;

        System.arraycopy(arr, 0, newArr, 0, length);
        arr = newArr;
    }

    @Override
    public void insert(int val) {
        this.reallocateArray(length + 1);
        System.arraycopy(arr, 0, arr, 1, length);
        arr[0] = val;
        length++;
    }

    @Override
    public void append(int val) {
        this.reallocateArray(length + 1);
        arr[length++] = val;
    }

    @Override
    public int popFront() {
        int elem = arr[0];
        System.arraycopy(arr, 1, arr, 0, length - 1);
        return elem;
    }

    @Override
    public int length() {
        return this.length;
    }

    @Override
    public int get(int idx) throws ArrayIndexOutOfBoundsException {
        if (idx < 0 || idx >= length()) throw new ArrayIndexOutOfBoundsException();
        return arr[idx];
    }

    public int capacity() {
        return this.capacity;
    }
}
