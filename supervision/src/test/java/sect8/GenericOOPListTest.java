package sect8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import uk.ac.cam.mr2083.sect8.OOPLinkedList;
import uk.ac.cam.mr2083.sect8.OOPList;

public class GenericOOPListTest {
    @Test
    public void genericOOPListTest() {
        OOPList<Double> list = new OOPLinkedList<>();

        list.append(2.0);

        list.insert(0.9);
        list.insert(1.0);

        list.append(2.3);

        assertEquals(1.0, list.get(0));
        assertEquals(0.9, list.get(1));
        assertEquals(2.0, list.get(2));
        assertEquals(2.3, list.get(3));

        assertEquals(1.0, list.popFront());
        assertEquals(0.9, list.popFront());
        assertEquals(2.0, list.popFront());
        assertEquals(2.3, list.popFront());
    }
}
