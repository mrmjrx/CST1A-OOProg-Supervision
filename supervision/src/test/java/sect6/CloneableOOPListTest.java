package sect6;

import org.junit.jupiter.api.Test;
import uk.ac.cam.mr2083.sect6.CloneableOOPLinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CloneableOOPListTest {
    @Test
    public void cloneTest() {
        CloneableOOPLinkedList list = new CloneableOOPLinkedList();

        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);

        CloneableOOPLinkedList list2 = list.clone();

        assertEquals(1, list.popFront());
        assertEquals(2, list.popFront());

        assertEquals(1, list2.popFront());

        assertEquals(3, list.popFront());

        assertEquals(2, list2.popFront());
        assertEquals(3, list2.popFront());

        assertEquals(4, list2.popFront());
        assertEquals(5, list2.popFront());

        assertEquals(4, list.popFront());
        assertEquals(5, list.popFront());


    }
}
