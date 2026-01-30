package uk.ac.cam.mr2083.proj.proj1b;

import java.util.Comparator;
import java.util.Iterator;

public class Maximizer61B {
    /**
     * Returns the maximum element from the given iterable of comparables.
     * You may assume that the iterable contains no nulls.
     *
     * @param iterable  the Iterable of T
     * @return          the maximum element
     */
    public static <T extends Comparable<T>> T max(Iterable<T> iterable) {
        T currMax = null;

        for (T elem : iterable) {
            if (currMax == null || elem.compareTo(currMax) > 0) currMax = elem;
        }

        return currMax;
    }

    /**
     * Returns the maximum element from the given iterable according to the specified comparator.
     * You may assume that the iterable contains no nulls.
     *
     * @param iterable  the Iterable of T
     * @param comp      the Comparator to compare elements
     * @return          the maximum element according to the comparator
     */
    public static <T> T max(Iterable<T> iterable, Comparator<T> comp) {
        T currMax = null;

        for (T elem : iterable) {
            if (currMax == null || comp.compare(elem, currMax) > 0) currMax = elem;
        }

        return currMax;
    }
}
