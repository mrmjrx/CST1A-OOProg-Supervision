package sect7;

import org.junit.jupiter.api.Test;
import uk.ac.cam.mr2083.sect7.Car;
import uk.ac.cam.mr2083.sect7.CarComparator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarComparisonTest {
    @Test
    public void carComparisonTest() {
        Car c1 = new Car("VW", 1);
        Car c2 = new Car("VW", 2);
        Car c3 = new Car("Mini", 25);
        Car c4 = new Car("Mini", 25);

        Car c5 = new Car("VW", 72);

        assertEquals(0, c1.compareTo(c2));
        assertEquals(0, c3.compareTo(c4));
        assertTrue(c1.compareTo(c3) > 0);
        assertTrue(c2.compareTo(c4) > 0);

        CarComparator comparator = new CarComparator();
        assertTrue(comparator.compare(c1, c2) < 0);
        assertEquals(0, comparator.compare(c3, c4));
        assertTrue(comparator.compare(c1, c3) > 0);
        assertTrue(comparator.compare(c5, c1) > 0);
    }
}
