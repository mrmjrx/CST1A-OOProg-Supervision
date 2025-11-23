package sect2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import uk.ac.cam.mr2083.sect2.OOPLinkedList;

public class OOPLinkedListTest {
    @Test
    void linkedListTest() {
        assertTrue((new OOPLinkedList()).isEmpty());

        OOPLinkedList list = new OOPLinkedList(new int[]{1, 2, 3, 4, 5});
        assertEquals(5, list.length());
        assertFalse(list.isEmpty());

        assertEquals(3, list.get(2));
        assertEquals(1, list.pop());
        assertEquals(4, list.length());

        list.insert(6);
        assertEquals(6, list.get(4));
        assertEquals(5, list.length());

        list.push(-1);
        assertEquals(-1, list.peek());
        assertEquals(6, list.length());
        assertEquals(-1, list.pop());
    }
}
