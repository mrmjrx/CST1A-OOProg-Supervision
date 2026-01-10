package sect4;

import org.junit.jupiter.api.Test;
import uk.ac.cam.mr2083.sect2.OOPLinkedList;
import uk.ac.cam.mr2083.sect4.OOPLazySortedLinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OOPLazySortedLinkedListTest {
    @Test
    public void sortedListTest() {
        OOPLinkedList list = new OOPLazySortedLinkedList();
        list.insert(5);
        list.insert(3);
        list.insert(4);
        list.insert(1);
        list.insert(2);
        list.insert(6);

        for (int i = 1; i <= 6; i++) {
            assertEquals(i, list.get(i - 1));
        }
    }
}