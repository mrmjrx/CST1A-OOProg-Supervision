package sect8;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import uk.ac.cam.mr2083.sect8.CollectionArrayList;

import java.util.List;

public class CollectionArrayListTest {
    @Test
    public void collectionArrayListTest() {
        List<Integer> intList = new CollectionArrayList<Integer>();

        intList.add(16);
        intList.add(25);
        intList.add(36);
        intList.add(4);
        intList.add(45);
        intList.add(64);
        intList.add(9);

        assertArrayEquals(new Integer[]{16, 25, 36, 4, 45, 64, 9}, intList.toArray());

        assertEquals(45, intList.remove(4));
        assertArrayEquals(new Integer[]{16, 25, 36, 4, 64, 9}, intList.toArray());

        intList.sort(Integer::compareTo); // I didn't implement sort - this comes from AbstractList
        assertArrayEquals(new Integer[]{4, 9, 16, 25, 36, 64}, intList.toArray());
    }
}
