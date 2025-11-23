package uk.ac.cam.mr2083.sect2;

public class SearchSet {
    private int numElements = 0;
    private BinaryTreeNode head = null;

    public SearchSet() {} // implicitly declared by Java

    public int getNumElements() {
        return numElements;
    }

    public void insert(int value) {
        if (head == null) {
            this.head = new BinaryTreeNode(value);
            numElements = 1;
            return;
        }

        BinaryTreeNode prev = null;
        BinaryTreeNode current = head;

        while (current != null) {
            if (current.getValue() == value) return; // value already in set

            prev = current;
            current = value < current.getValue() ? current.getLeft() : current.getRight();
        }

        // prev is the parent node to the new node to insert
        assert prev != null;

        BinaryTreeNode newNode = new BinaryTreeNode(value);

        if (value < prev.getValue()) prev.setLeft(newNode);
        else prev.setRight(newNode);

        numElements++;
    }

    public boolean contains(int value) {
        BinaryTreeNode current = head;

        while (current != null) {
            if (current.getValue() == value) return true;

            current = value < current.getValue() ? current.getLeft() : current.getRight();
        }

        // if reached a null node where value should be, elem not in search set
        return false;
    }
}
