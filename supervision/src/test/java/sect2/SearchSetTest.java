package sect2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import uk.ac.cam.mr2083.sect2.SearchSet;

public class SearchSetTest {
    private final int SET_SIZE = 250;
    @Test
    public void setTest() {
        SearchSet set = new SearchSet();
        assertEquals(0, set.getNumElements());
        assertFalse(set.contains(0));
        assertFalse(set.contains(-1));

        set.insert(3);
        set.insert(1);
        set.insert(2);
        set.insert(4);
        set.insert(5);

        assertEquals(5, set.getNumElements());
        assertTrue(set.contains(1));
        assertTrue(set.contains(2));
        assertTrue(set.contains(3));
        assertTrue(set.contains(4));
        assertTrue(set.contains(5));

        assertFalse(set.contains(6));
        assertFalse(set.contains(0));

    }
}

