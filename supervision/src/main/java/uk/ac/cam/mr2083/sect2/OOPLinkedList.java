package uk.ac.cam.mr2083.sect2;

public class OOPLinkedList {
    private OOPLinkedListElement head = null;

    public OOPLinkedList() {} // create empty list

    public OOPLinkedList(int[] ints) {
        this.head = null;

        for (int elem : ints) {
            this.insert(elem);
        }
    }


    public OOPLinkedListElement getTail() {
        if (head == null) return null;

        // tail has no next value, so find elem. with this
        OOPLinkedListElement currElem = head;
        while (currElem.hasNext()) {
            currElem = currElem.getNext();
        }

        return currElem;
    }

    public void push(int elem) { // insert at front
        this.head = new OOPLinkedListElement(elem, head);
    }

    public void insert(int elem) { // append to end of list
        if (head == null) {
            head = new OOPLinkedListElement(elem);
            return;
        }

        // append to end of list
        OOPLinkedListElement tail = getTail();
        tail.setNext(elem);
    }

    public int pop() {
        if (head == null) throw new ArrayIndexOutOfBoundsException(0);

        int currHeadValue = head.getValue();
        head = head.getNext();

        return currHeadValue;
    }

    public int peek() {
        if (head == null) throw new ArrayIndexOutOfBoundsException(0);
        return head.getValue();
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

    public int get(int n) {
        if (n < 0) throw new ArrayIndexOutOfBoundsException(n);

        OOPLinkedListElement curr = head;

        // fetch a new elem. n times
        for (int i = 0; i < n; i++) {
            curr = curr.getNext();

            if (curr == null) {
                throw new ArrayIndexOutOfBoundsException(n);
            }
        }

        return curr.getValue();
    }
}
