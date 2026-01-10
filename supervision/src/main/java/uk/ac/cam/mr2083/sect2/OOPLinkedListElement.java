package uk.ac.cam.mr2083.sect2;

public class OOPLinkedListElement {
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
