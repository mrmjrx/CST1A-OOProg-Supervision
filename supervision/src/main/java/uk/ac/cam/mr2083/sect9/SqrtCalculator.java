package uk.ac.cam.mr2083.sect9;

public class SqrtCalculator {
    public static final int ITERATIONS = 25;

    public static double sqrt(double n) {
        // x^2 = n => x^2 - n = 0
        // f(x) = x^2 - n
        // f'(x) = 2x
        // f'(x)/f(x) = 2x/x^2 - n
        // x_{n+1} = x_n - f'(x)/f(x)

        if (n < 0) {
            throw new IllegalArgumentException("sqrt(n) not defined for n < 0");
        }

        if (n == 0 || n == 1) return n;

        double x = n;

        for (int i = 0; i < SqrtCalculator.ITERATIONS; i++) {
            x -= (x * x - n) / (2.0 * x);
        }

        return x;
    }
}
