package uk.ac.cam.mr2083.sect5.oopdatastructures;

public class EmptyQueueException extends Exception {
    public EmptyQueueException() {
        super("Queue is empty.");
    }
}
