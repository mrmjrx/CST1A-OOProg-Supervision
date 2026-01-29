package sect7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import uk.ac.cam.mr2083.sect7.Point3D;


public class PointTest {
    @Test
    public void orderingTest() {
        Point3D p1 = new Point3D(1, 2, 4);
        Point3D p2 = new Point3D(1, 2, 3);
        Point3D p3 = new Point3D(1, 2, 2);

        assertTrue(p1.compareTo(p2) > 0);
        assertTrue(p2.compareTo(p3) > 0);

        Point3D p4 = new Point3D(1, 3, 3);
        Point3D p5 = new Point3D(1, 2, 3);
        Point3D p6 = new Point3D(1, 1, 3);

        assertTrue(p4.compareTo(p5) > 0);
        assertTrue(p5.compareTo(p6) > 0);

        Point3D p7 = new Point3D(2, 2, 3);
        Point3D p8 = new Point3D(1, 2, 3);
        Point3D p9 = new Point3D(0, 2, 3);

        assertTrue(p7.compareTo(p8) > 0);
        assertTrue(p8.compareTo(p9) > 0);

        Point3D p10 = new Point3D(0, 0, 1);
        Point3D p11 = new Point3D(100, 100, 0);

        assertTrue(p10.compareTo(p11) > 0);
    }

}
