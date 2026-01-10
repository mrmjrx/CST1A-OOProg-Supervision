package uk.ac.cam.mr2083.sect4;

import uk.ac.cam.mr2083.sect2.OOPLinkedList;
import uk.ac.cam.mr2083.sect2.OOPLinkedListElement;

public class OOPSortedLinkedList extends OOPLinkedList {
    @Override
    public void insert(int elem) {
        OOPLinkedListElement currHead = this.getHead();

        if (this.getHead() == null) {
            super.insert(elem);
            return;
        }

        if (elem < currHead.getValue()) {
            OOPLinkedListElement newHead =  new OOPLinkedListElement(elem);
            newHead.setNext(currHead);
            this.setHead(newHead);
            return;
        }

        OOPLinkedListElement currElem = currHead;
        while (currElem.hasNext() && currElem.getNext().getValue() < elem) {
            currElem = currElem.getNext();
        }

        OOPLinkedListElement newElem = new OOPLinkedListElement(elem);
        newElem.setNext(currElem.getNext());
        currElem.setNext(newElem);
    }
}
