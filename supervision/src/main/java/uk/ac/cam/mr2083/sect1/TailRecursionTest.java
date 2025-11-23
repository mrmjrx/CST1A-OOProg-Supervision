package uk.ac.cam.mr2083.sect1;

public class TailRecursionTest {
    public static long sumTo(int n, long acc) {
        if (n == 0) return acc;

        return sumTo(n - 1, acc + n); // tail-recursive call
    }

    public static void main(String[] args) {
        // causes StackOverflowError
        System.out.println(sumTo(10_000_000, 0));
    }
}
