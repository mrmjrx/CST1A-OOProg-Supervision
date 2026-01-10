package sect6;

import org.junit.jupiter.api.Test;
import uk.ac.cam.mr2083.sect6.MyClass;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MyClassTest {
    @Test
    public void myClassTest() {
        MyClass m1 = new MyClass("Max", new int[]{-1, 1, 3, 5, 7});
        MyClass m2 = new MyClass("Max", new int[]{-1, 1, 3, 5, 7});

        assertEquals(m1, m2);

        MyClass m3 = new MyClass("Max", new int[]{1, 2, 3, 4, 5});
        assertNotEquals(m1, m3);

        MyClass m4 = new MyClass(m1);
        assertEquals(m1, m4);

        MyClass m5 = m1.clone();
        assertEquals(m1, m5);
    }
}
