package sect11;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import uk.ac.cam.mr2083.sect11.Book;
import uk.ac.cam.mr2083.sect11.Library;


import java.util.List;

public class LibraryTest {
    @Test
    public void testLibrary() {
        Library library = new Library(List.of(
                new Book("Moby Dick", "Herman Melville", 720),
                new Book("War and Peace", "Leo Tolstoy", 1225),
                new Book("1984", "George Orwell", 328),
                new Book("Ulysses", "James Joyce", 730)
        ));

        assertEquals(List.of("Moby Dick", "Ulysses", "War and Peace"), library.getLongBookTitles());
    }
}
