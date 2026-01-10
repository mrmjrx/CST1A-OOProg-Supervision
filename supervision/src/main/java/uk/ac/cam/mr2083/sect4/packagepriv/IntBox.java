package uk.ac.cam.mr2083.sect4.packagepriv;

public class IntBox {
    int val;

    private class Calculator {
        public void add(int d) {
            val += d;
        }
    }

    private void increment() {
        val++;
    }
}
