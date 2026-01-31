package uk.ac.cam.mr2083.proj.proj1b;

import uk.ac.cam.mr2083.proj.Deque61B;

import java.util.Arrays;
import java.util.List;

public class ArrayDeque61B<T> implements Deque61B<T> {
    private static final int MINIMUM_CAPACITY = 8;
    private static final double GROWTH_FACTOR = 2;
    private static final double MINIMUM_UTILISATION = 0.25;

    private int length = 0;
    private int capacity;

    private int head = 0;
    private int tail = 0;

    private T[] buffer;

    public ArrayDeque61B(int capacity) {
        this.capacity = Math.max(capacity, MINIMUM_CAPACITY);
        this.buffer = (T[]) new Object[capacity];
    }

    public ArrayDeque61B() {
        this(MINIMUM_CAPACITY);
    }

    @Override
    public void addFirst(T x) {
        if (this.length == 0) {
            this.addLast(x); // for the first insertion, code is identical to addLast
            return;
        }

        this.resizeIfRequired();

        this.head = Math.floorMod(this.head - 1, this.capacity);
        this.buffer[this.head] = x;
        this.length++;
    }

    @Override
    public void addLast(T x) {
        this.resizeIfRequired();

        this.buffer[this.tail] = x;
        this.tail = (this.tail + 1) % this.capacity;
        this.length++;
    }

    private void resizeIfRequired() {
        if (this.length == this.capacity)
            this.resize((int) (capacity * GROWTH_FACTOR));

        if (this.capacity > MINIMUM_CAPACITY && this.length < this.capacity * MINIMUM_UTILISATION)
            this.resize(Math.max((int) (this.capacity * MINIMUM_UTILISATION), MINIMUM_CAPACITY));
    }

    private void resize(int newCapacity) {
        assert this.length <= newCapacity;

        T[] newBuffer = (T[]) new Object[newCapacity];

        this.copyToBuffer(newBuffer);

        this.buffer = newBuffer;
        this.capacity = newCapacity;
        this.head = 0;
        this.tail = length;
    }

    private void copyToBuffer(T[] destBuffer) {
        if (this.length == 0) return;

        int newIndex = 0;
        int i = this.head;

        do {
            destBuffer[newIndex++] = this.buffer[i];
            i = (i + 1) % this.capacity;
        } while (i != this.tail);
    }

    private T[] getMinimumBuffer() {
        T[] minBuffer = (T[]) new Object[this.length];

        this.copyToBuffer(minBuffer);
        return minBuffer;
    }

    @Override
    public List<T> toList() {
        return List.of(getMinimumBuffer());
    }

    @Override
    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override
    public int size() {
        return this.length;
    }

    @Override
    public T removeFirst() {
        if (this.length == 0) return null;

        T elem = this.buffer[this.head];

        this.buffer[this.head] = null;
        this.head = Math.floorMod(this.head + 1, capacity);

        this.length--;

        if (this.length == 0) {
            this.head = 0;
            this.tail = 0;
        }

        this.resizeIfRequired();

        return elem;
    }

    @Override
    public T removeLast() {
        if (this.length == 0) return null;

        this.tail = Math.floorMod(this.tail - 1, this.capacity);
        T elem = this.buffer[this.tail];

        this.buffer[this.tail] = null;
        this.length--;

        if (this.length == 0) {
            this.head = 0;
            this.tail = 0;
        }

        this.resizeIfRequired();

        return elem;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= this.length) {
            return null;
        }

        return this.buffer[(this.head + index) % this.capacity];
    }

    @Override
    public T getRecursive(int index) {
        throw new UnsupportedOperationException("ArrayDeque.getRecursive is not a valid operation");
    }

    public int capacity() { // primarily exposed for testing purposes
        return this.capacity;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.getMinimumBuffer());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ArrayDeque61B<?> arrDeq)) return false;

        if (this.length != arrDeq.length) return false;

        for (int i = 0; i < length; i++) {
            if (!this.get(i).equals(arrDeq.get(i))) return false;
        }

        return true;
    }
}
