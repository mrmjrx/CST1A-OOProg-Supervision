package uk.ac.cam.mr2083.sect5.oopdatastructures;

import java.util.Optional;

public interface OOPQueue {
    int length();
    int peek() throws EmptyQueueException;
    void enqueue(int val);
    int dequeue() throws EmptyQueueException;

    default boolean isEmpty() { return length() == 0; }

    default Optional<Integer> optionalPeek() {
        try {
            return Optional.of(peek());
        } catch (EmptyQueueException e) {
            return Optional.empty();
        }
    }

    default Optional<Integer> optionalDequeue() {
        try {
            return Optional.of(dequeue());
        } catch (EmptyQueueException e) {
            return Optional.empty();
        }
    }
}

