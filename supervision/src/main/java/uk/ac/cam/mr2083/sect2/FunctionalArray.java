package uk.ac.cam.mr2083.sect2;

public class FunctionalArray {
    private final int capacity;
    private BinaryTreeNode head = new BinaryTreeNode(0);

    public FunctionalArray(int capacity) {
        this.capacity = capacity;
    }

    public int get(int index) {
        return getNode(index).getValue();
    }

    private BinaryTreeNode getNode(int index) {
        // bound check
        if (index < 0 || index >= capacity) throw new ArrayIndexOutOfBoundsException(index);

        BinaryTreeNode current = head;
        index++; // functional array requires 1-indexing

        while (index != 1) { // in a functional aray, this is the terminating condition
            boolean nextMoveLeft = index % 2 == 1; // determines if the LSB is 1 or 0.

            if (nextMoveLeft) {
                // if node at the left, doesn't exist - create
                if (current.getLeft() == null) current.setLeft(new BinaryTreeNode(0));
                current = current.getLeft();
            } else {
                // if node at the right doesn't exist - create
                if (current.getRight() == null) current.setRight(new BinaryTreeNode(0));
                current = current.getRight();
            }

            index >>= 1; // R-shift index
        }

        return current;
    }

    public void set(int index, int value) {
        getNode(index).setValue(value);
    }
}
