package sect1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import uk.ac.cam.mr2083.sect1.MathUtil;

public class MathUtilTest {
    @Test
    void intMax() {
        assertEquals(1, MathUtil.max(-1, 1));
    }

    @Test
    void doubleMax() {
        assertEquals(Math.PI, MathUtil.max(Math.PI, Math.sqrt(2)));
    }

}
