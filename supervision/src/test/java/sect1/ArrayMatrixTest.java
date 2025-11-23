package sect1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import uk.ac.cam.mr2083.sect1.ArrayMatrix;

public class ArrayMatrixTest {
    public static void assertMatricesEqual(float[][] correctMatrix, float[][] generatedMatrix) {
        assertEquals(correctMatrix.length, generatedMatrix.length);

        for (int i = 0; i < correctMatrix.length; i++) {
            assertEquals(correctMatrix[i].length, generatedMatrix[i].length);

            for (int j = 0; j < correctMatrix[i].length; j++) {
                assertEquals(correctMatrix[i][j], generatedMatrix[i][j], 0.0001f);
            }
        }
    }

    @Test
    void identityTest() {
        float[][] matrix = ArrayMatrix.identity(3);
        float[][] identityMatrix = new float[][] {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};

        assertMatricesEqual(identityMatrix, matrix);
    }

    @Test
    void transposeTest() {
        float[][] m1 = new float[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        float[][] m1Transposed = new float[][] {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};

        ArrayMatrix.transpose(m1);
        assertMatricesEqual(m1Transposed, m1);
    }
}
