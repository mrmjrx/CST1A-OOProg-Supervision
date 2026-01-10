package uk.ac.cam.mr2083.sect5.oopdatastructures;

import java.util.Arrays;

public class OOPArrayQueue implements OOPQueue {
    private static final int MIN_CAPACITY = 4;
    private static final int GROWTH_RATE = 2;

    private int[] buffer = new int[MIN_CAPACITY];
    private int head = 0;
    private int tail = 0;

    private int capacity = MIN_CAPACITY;
    private int length = 0;


    @Override
    public int length() {
        return length;
    }

    @Override
    public int peek() throws EmptyQueueException {
        if (this.isEmpty()) {
            throw new EmptyQueueException();
        }

        return buffer[head];
    }

    @Override
    public void enqueue(int val) {
        if (arrayFull()) {
            resizeArray();
        }

        buffer[tail] = val;
        length++;
        tail = (tail + 1) % capacity;

        System.out.println("buf=" + Arrays.toString(buffer) + "; head=" + head + "; tail=" + tail);
    }

    private void resizeArray() {
        int newCapacity = capacity * GROWTH_RATE;
        int[] newBuffer = new int[newCapacity];

        if (tail > head) {
            System.arraycopy(buffer, head, newBuffer, 0, length);
        } else {
            System.arraycopy(buffer, head, newBuffer, 0, capacity - head);
            System.arraycopy(buffer, 0, newBuffer, capacity - head, tail);
        }

        tail = length;
        head = 0;
        capacity = newCapacity;
        buffer = newBuffer;
    }

    @Override
    public int dequeue() throws EmptyQueueException {
        if (this.isEmpty()) {
            throw new EmptyQueueException();
        }

        int item = buffer[head];
        head = (head + 1) % capacity;
        length--;

        if (length == 0) {
            head = 0;
            tail = 0;
        }

        System.out.println("buf=" + Arrays.toString(buffer) + "; head=" + head + "; tail=" + tail);

        return item;
    }

    private boolean arrayFull() {
        return (tail + 1) % capacity == head;
    }
}
