package uk.ac.cam.mr2083.proj.proj1a;

import org.jetbrains.annotations.NotNull;
import uk.ac.cam.mr2083.proj.Deque61B;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LinkedListDeque61B<T> implements Deque61B<T> {
    private class Node {
        private final T value;
        private @NotNull Node next;
        private @NotNull Node prev;

        private Node(T value, @NotNull Node prev, @NotNull Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }

        private Node(T value) {
            this.value = value;
            this.next = this;
            this.prev = this;
        }

        private T getRecursive(int index, @NotNull Node sentinel) {
            if (this == sentinel) return null;
            if (index == 0) return this.value;

            return this.next.getRecursive(index - 1, sentinel);
        }
    }

    private final Node sentinel;
    private int length = 0;

    public LinkedListDeque61B() {
        sentinel = new Node(null);
    }

    @Override
    public void addFirst(T x) {
        sentinel.next = new Node(x, sentinel, sentinel.next);

        // the previous next element must have its prev pointer set to the new node
        sentinel.next.next.prev = sentinel.next;

        length++;
    }

    @Override
    public void addLast(T x) {
        sentinel.prev = new Node(x, sentinel.prev, sentinel);

        // the previous prev element must have its next pointer set to the new node
        sentinel.prev.prev.next = sentinel.prev;

        length++;
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();

        Node currNode = sentinel.next;
        while (currNode != sentinel) {
            returnList.add(currNode.value);
            currNode = currNode.next;
        }

        return returnList;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public T removeFirst() {
        Node returnNode = sentinel.next;

        if (returnNode == sentinel) return null;

        sentinel.next = returnNode.next;
        sentinel.next.prev = sentinel;

        length--;

        return returnNode.value;
    }

    @Override
    public T removeLast() {
        Node returnNode = sentinel.prev;

        if (returnNode == sentinel) return null;

        sentinel.prev = returnNode.prev;
        sentinel.prev.next = sentinel;

        length--;

        return returnNode.value;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= length) return null;

        Node currNode = sentinel.next;

        for (int i = 0; i < index; i++) currNode = currNode.next;

        return currNode.value;
    }

    @Override
    public T getRecursive(int index) {
        if (index < 0) return null;

        return this.sentinel.next.getRecursive(index, sentinel);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof LinkedListDeque61B<?> arrDeq)) return false;

        if (this.length != arrDeq.length) return false;

        for (int i = 0; i < length; i++) {
            if (!this.get(i).equals(arrDeq.get(i))) return false;
        }

        return true;
    }

    @Override
    public String toString() {
        StringBuilder stringRepr = new StringBuilder();
        stringRepr.append("[");

        Node currNode = sentinel.next;
        while (currNode != sentinel) {
            stringRepr.append(currNode.value.toString());

            if (currNode.next != sentinel) stringRepr.append(", ");

            currNode = currNode.next;
        }

        stringRepr.append("]");
        return stringRepr.toString();
    }
}
