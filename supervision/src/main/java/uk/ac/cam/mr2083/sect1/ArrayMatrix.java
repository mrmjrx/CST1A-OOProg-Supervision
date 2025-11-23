package uk.ac.cam.mr2083.sect1;


public final class ArrayMatrix {
    public static float[][] identity(int n) {
        float[][] matrix = new float[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i][i] = 1f;
        }

        return matrix;
    }

    public static void transpose(float[][] matrix) {
        final int matrix_size = matrix.length;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length != matrix_size)
                throw new RuntimeException("matrix is not square (should be " + matrix_size + " x " + matrix_size + ")");

            for (int j = i; j < matrix_size; j++) {
                float temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
