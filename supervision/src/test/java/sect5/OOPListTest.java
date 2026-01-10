package sect5;

import org.junit.jupiter.api.Test;
import uk.ac.cam.mr2083.sect5.oopdatastructures.OOPArrayList;
import uk.ac.cam.mr2083.sect5.oopdatastructures.OOPLinkedList;
import uk.ac.cam.mr2083.sect5.oopdatastructures.OOPList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class OOPListTest {
    public void listTest(OOPList list) {
        assertTrue(list.isEmpty());
        assertEquals(0, list.length());

        list.append(2);
        assertFalse(list.isEmpty());
        assertEquals(1, list.length());

        list.append(3);
        assertEquals(2, list.length());

        list.insert(1);
        assertEquals(3, list.length());

        list.append(4);
        assertEquals(4, list.length());

        list.append(5);
        assertEquals(5, list.length());

        list.append(6);
        assertEquals(6, list.length());

        list.insert(0);
        assertEquals(7, list.length());


        for (int i = 0; i < list.length(); i++) assertEquals(i, list.get(i));

        for (int i = 0; i < 7; i++) assertEquals(i, list.popFront());
    }

    @Test
    public void linkedListTest() {
        listTest(new OOPLinkedList());
    }

    @Test
    public void arrayListTest() {
        listTest(new OOPArrayList());
    }
}
