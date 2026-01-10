package uk.ac.cam.mr2083.sect6;

import uk.ac.cam.mr2083.sect5.oopdatastructures.OOPList;

public class CloneableOOPLinkedList implements OOPList, Cloneable {
    protected static class OOPLinkedListElement {
        private int value;
        private OOPLinkedListElement next = null;

        public OOPLinkedListElement(int value) {
            this.value = value;
        }

        public OOPLinkedListElement(int value, OOPLinkedListElement next) {
            this.value = value;
            this.next = next;
        }

        public boolean hasNext() {
            return next != null;
        }

        public OOPLinkedListElement getNext() {
            return next;
        }

        public int getValue() {
            return value;
        }

        public void setNext(OOPLinkedListElement next) {
            this.next = next;
        }
    }


    private OOPLinkedListElement head = null;

    public CloneableOOPLinkedList() {} // create empty list

    public CloneableOOPLinkedList(int[] ints) {
        this.head = null;

        for (int elem : ints) {
            this.append(elem);
        }
    }


    protected OOPLinkedListElement getTail() {
        if (head == null) return null;

        // tail has no next value, so find elem. with this
        OOPLinkedListElement currElem = head;
        while (currElem.hasNext()) {
            currElem = currElem.getNext();
        }

        return currElem;
    }

    public void insert(int elem) { // insert at front
        this.head = new OOPLinkedListElement(elem, head);
    }

    public void append(int elem) { // append to end of list
        if (head == null) {
            head = new OOPLinkedListElement(elem);
            return;
        }

        // append to end of list
        OOPLinkedListElement tail = getTail();
        tail.setNext(new OOPLinkedListElement(elem));
    }

    public int popFront() {
        if (head == null) throw new ArrayIndexOutOfBoundsException(0);

        int currHeadValue = head.getValue();
        head = head.getNext();

        return currHeadValue;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int length() {
        int length = 0;
        OOPLinkedListElement curr = head;

        // for every elem, inc. length
        while (curr != null) {
            length++;
            curr = curr.getNext();
        }

        return length;
    }

    public int get(int idx) throws ArrayIndexOutOfBoundsException {
        if (idx < 0) throw new ArrayIndexOutOfBoundsException(idx);

        OOPLinkedListElement curr = head;

        // fetch a new elem. idx times
        for (int i = 0; i < idx; i++) {
            curr = curr.getNext();

            if (curr == null) {
                throw new ArrayIndexOutOfBoundsException(idx);
            }
        }

        return curr.getValue();
    }

    protected void setHead(OOPLinkedListElement newHead) {
        this.head = newHead;
    }

    protected OOPLinkedListElement getHead() {
        return this.head;
    }

    @Override
    public CloneableOOPLinkedList clone() {
        CloneableOOPLinkedList newList = new CloneableOOPLinkedList();

        OOPLinkedListElement curr = head;

        while (curr != null) {
            newList.append(curr.getValue());
            curr = curr.getNext();
        }

        return newList;
    }
}
