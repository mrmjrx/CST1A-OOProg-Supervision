package uk.ac.cam.mr2083.sect3;

public class IntArrayTest {
    private static void incrementFirstItem(int[] arr) {
        arr[0]++;
    }

    public static void main(String[] args) {
        int[] test = new int[] {-2, 2, 3};
        System.out.println(test[0]); // outputs -2

        incrementFirstItem(test);
        System.out.println(test[0]); //outputs -1
    }
}
