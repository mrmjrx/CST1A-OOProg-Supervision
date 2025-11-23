package sect1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import uk.ac.cam.mr2083.sect1.LowestCommon;

public class LowestCommonTest {
    @Test
    void lowestCommonSuccessTest() {
        assertEquals(3, LowestCommon.lowestCommon(14, 25));
    }

    @Test
    void lowestCommonFailureTest() {
        // test 14 against bitwise-not 14
        assertEquals(-1, LowestCommon.lowestCommon(14, ~14));
    }
}
