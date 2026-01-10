package uk.ac.cam.mr2083.sect5.oopdatastructures;

public class OOPListQueue implements OOPQueue {
    OOPLinkedList headList = new OOPLinkedList();
    OOPLinkedList tailList = new OOPLinkedList();

    private void normalise() {
        if (!headList.isEmpty()) return;
        if (tailList.isEmpty()) return;

        do {
            headList.insert(tailList.popFront());
        } while(!tailList.isEmpty());
    }

    @Override
    public int length() {
        return headList.length() + tailList.length();
    }

    @Override
    public boolean isEmpty() {
        return headList.isEmpty() && tailList.isEmpty();
    }

    @Override
    public int peek() throws EmptyQueueException {
        if (headList.isEmpty()) throw new EmptyQueueException();

        return headList.getHead().getValue();
    }

    @Override
    public void enqueue(int val) {
        tailList.insert(val);
        normalise();
    }

    @Override
    public int dequeue() throws EmptyQueueException {
        if (headList.isEmpty()) throw new EmptyQueueException();

        int head = headList.popFront();
        this.normalise();

        return head;
    }
}
