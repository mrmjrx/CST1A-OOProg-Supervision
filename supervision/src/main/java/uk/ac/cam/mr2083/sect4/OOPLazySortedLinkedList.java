package uk.ac.cam.mr2083.sect4;

import uk.ac.cam.mr2083.sect2.OOPLinkedListElement;

public class OOPLazySortedLinkedList extends OOPSortedLinkedList {
    private boolean sorted = false;

    @Override
    public void insert(int elem) {
        if (sorted) {
            super.insert(elem);
            return;
        }

        OOPLinkedListElement newElem = new OOPLinkedListElement(elem);
        OOPLinkedListElement currHead = this.getHead();

        if (currHead == null) {
            this.setHead(newElem);
            return;
        }

        // similar to OCaml cons operation
        newElem.setNext(currHead);
        this.setHead(newElem);
    }

    private void sort() {
        if (sorted) return;

        if (this.isEmpty()) return;

        boolean swapOccured;
        do {
            swapOccured = false;

            OOPLinkedListElement prevElem = null;
            OOPLinkedListElement currElem = this.getHead();

            while (currElem.hasNext()) {
                OOPLinkedListElement nextElem = currElem.getNext();

                if (currElem.getValue() > nextElem.getValue()) {
                    // swap
                    currElem.setNext(nextElem.getNext());
                    nextElem.setNext(currElem);

                    if (prevElem != null) {
                        prevElem.setNext(nextElem);
                    } else {
                        this.setHead(nextElem);
                    }

                    swapOccured = true;
                }

                prevElem = currElem;
                currElem = nextElem;
            }
        } while (swapOccured);

        sorted = true;
    }

    @Override
    public int peek() {
        this.sort();
        return super.peek();
    }

    @Override
    public int pop() {
        this.sort();
        return super.pop();
    }

    @Override
    public OOPLinkedListElement getTail() {
        this.sort();
        return super.getTail();
    }

    @Override
    public int get(int n) {
        this.sort();
        return super.get(n);
    }
}
