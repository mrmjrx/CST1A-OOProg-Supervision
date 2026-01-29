package sect9;

import org.junit.jupiter.api.Test;
import uk.ac.cam.mr2083.sect9.SqrtCalculator;

import static org.junit.jupiter.api.Assertions.*;

public class SqrtCalculatorTest {
    @Test
    public void sqrtCalculatorTest() {
        assertThrows(IllegalArgumentException.class, () -> SqrtCalculator.sqrt(-1));
        assertThrows(IllegalArgumentException.class, () -> SqrtCalculator.sqrt(-10000));

        assertEquals(0, SqrtCalculator.sqrt(0));
        assertEquals(1, SqrtCalculator.sqrt(1));

        assertTrue(Math.abs(SqrtCalculator.sqrt(13) - Math.sqrt(13)) < 0.000001);
        assertTrue(Math.abs(SqrtCalculator.sqrt(29) - Math.sqrt(29)) < 0.000001);
        assertTrue(Math.abs(SqrtCalculator.sqrt(6) - Math.sqrt(6)) < 0.000001);
        assertTrue(Math.abs(SqrtCalculator.sqrt(113) - Math.sqrt(113)) < 0.000001);
    }
}
