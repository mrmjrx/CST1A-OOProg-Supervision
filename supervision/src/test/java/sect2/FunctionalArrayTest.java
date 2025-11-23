package sect2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import uk.ac.cam.mr2083.sect2.FunctionalArray;

public class FunctionalArrayTest {
    @Test
    void functionalArrayTest() {
        FunctionalArray functionalArray = new FunctionalArray(5);

        assertEquals(0, functionalArray.get(0));
        assertEquals(0, functionalArray.get(1));
        assertEquals(0, functionalArray.get(2));
        assertEquals(0, functionalArray.get(3));
        assertEquals(0, functionalArray.get(4));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> functionalArray.get(5));

        functionalArray.set(3, -1);
        assertEquals(-1, functionalArray.get(3));

    }
}
