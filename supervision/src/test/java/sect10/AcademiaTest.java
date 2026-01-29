package sect10;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import uk.ac.cam.mr2083.sect10.academia.Academic;
import uk.ac.cam.mr2083.sect10.academia.Lecturer;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AcademiaTest {
    @Test
    public void academiaTest() {
        PrintStream systemOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Academic academic = new Academic("Max Verstappen", new Lecturer());
        assertEquals(25, academic.calculatePay(5)); // Lecturer base pay is 5 per hour

        academic.lecture();
        assertEquals("Exhaling slightly less information...", outputStream.toString().trim());
        outputStream.reset();

        academic.research();
        assertEquals("Researching instead of sleeping...", outputStream.toString().trim());
        outputStream.reset();

        academic.promote();

        assertEquals(250, academic.calculatePay(5)); // Promotion increases the pay rate by 10x

        academic.lecture();
        assertEquals("Exhaling a textbook of information...", outputStream.toString().trim());
        outputStream.reset();

        academic.research();
        assertEquals("Prodding lecturers to write papers...", outputStream.toString().trim());
        outputStream.reset();

        System.setOut(systemOut);
    }
}
