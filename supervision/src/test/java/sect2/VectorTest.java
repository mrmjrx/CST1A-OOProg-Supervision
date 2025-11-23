package sect2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import uk.ac.cam.mr2083.sect2.Vector2D;

public class VectorTest {
    @Test
    void vecTest() {
        Vector2D v1 = new Vector2D();
        assertEquals(new Vector2D(0, 0), v1);
        assertEquals(0, v1.magnitude());

        v1.add(new Vector2D(3, 4));
        assertEquals(5, v1.magnitude());

        v1.scale(2);
        assertEquals(new Vector2D(6, 8), v1);
        assertEquals(10, v1.magnitude());

        v1.normalise();
        assertEquals(new Vector2D(0.6f, 0.8f), v1);

        Vector2D v2 = new Vector2D(3f);
        assertEquals(new Vector2D(3f, 3f), v2);
        assertEquals(3 * Math.sqrt(2), v2.magnitude(), 0.001);

        assertEquals(4.2, Vector2D.dot(v1, v2), 0.001);
    }
}
