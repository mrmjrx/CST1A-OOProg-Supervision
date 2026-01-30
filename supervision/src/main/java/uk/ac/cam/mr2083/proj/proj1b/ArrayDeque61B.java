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
        this.tail = (tail + 1) % capacity;
        this.length++;
    }

    private void resizeIfRequired() {
        if (this.length == this.capacity)
            this.resize((int) (capacity * GROWTH_FACTOR));

        if (this.capacity > MINIMUM_CAPACITY && this.length < capacity * MINIMUM_UTILISATION)
            this.resize(Math.max((int) (capacity * MINIMUM_UTILISATION), MINIMUM_CAPACITY));
    }

    private void resize(int newCapacity) {
        assert length <= newCapacity;

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
        return length == 0;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public T removeFirst() {
        if (length == 0) return null;

        T elem = buffer[head];

        buffer[head] = null;
        head = (head + 1) % capacity;

        length--;

        if (length == 0) {
            head = 0;
            tail = 0;
        }

        this.resizeIfRequired();

        return elem;
    }

    @Override
    public T removeLast() {
        if (length == 0) return null;

        this.tail = Math.floorMod(this.tail - 1, this.capacity);
        T elem = buffer[tail];

        buffer[tail] = null;
        length--;

        if (length == 0) {
            head = 0;
            tail = 0;
        }

        this.resizeIfRequired();

        return elem;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= length) {
            return null;
        }

        return buffer[(head + index) % capacity];
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
