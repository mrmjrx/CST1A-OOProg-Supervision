package sect7;

import org.junit.jupiter.api.Test;
import uk.ac.cam.mr2083.sect7.NumberFileReader;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberFileReaderTest {
    @Test
    public void testNumberFileReader() {
        NumberFileReader reader = new NumberFileReader();
        PrintStream systemOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        assertDoesNotThrow(() -> reader.processFile("src/test/java/sect7/numberFileReader-content.txt"));

        assertEquals("1 1\n1 2\n1 3\n2 0\n2 1\n2 2\n3 4\n7 20\n8 42\n20 7", outputStream.toString().trim());

        System.setOut(systemOut);
    }
}
