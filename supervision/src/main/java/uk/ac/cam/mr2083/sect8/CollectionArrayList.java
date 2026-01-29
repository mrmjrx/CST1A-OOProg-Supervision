package uk.ac.cam.mr2083.sect8;

import java.util.AbstractList;

public class CollectionArrayList<T> extends AbstractList<T> {
    private int length = 0;
    private int capacity = 4;

    private T[] buffer = (T[]) new Object[capacity];


    private void resize() {
        if (length < capacity) return;

        resize(capacity * 2);
    }

    private void resize(int newCapacity) {
        if (length < capacity) return;

        T[] newBuffer = (T[]) new Object[newCapacity];
        System.arraycopy(this.buffer, 0, newBuffer, 0, this.length);

        this.buffer = newBuffer;
        this.capacity = newCapacity;
    }


    @Override
    public boolean add(T t) {
        this.resize();
        this.buffer[length++] = t;
        return true;
    }


    @Override
    public T set(int index, T element) {
        if (index < 0 || index >= length) throw new IndexOutOfBoundsException();

        T old = this.buffer[index];
        this.buffer[index] = element;
        return old;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= length) throw new IndexOutOfBoundsException();

        T old = this.buffer[index];

        for (int i = index; i < length; i++) {
            this.buffer[i] = this.buffer[i + 1];
        }

        this.buffer[--length] = null;
        return old;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException();
        }

        return buffer[index];
    }

    @Override
    public int size() {
        return length;
    }
}
