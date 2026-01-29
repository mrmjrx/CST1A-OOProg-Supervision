package sect10;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import uk.ac.cam.mr2083.sect10.bookstore.BaseBook;
import uk.ac.cam.mr2083.sect10.bookstore.Book;
import uk.ac.cam.mr2083.sect10.bookstore.WrappedBook;

public class BookstoreTest {
    @Test
    public void bookstoreTest() {
        Book book = new Book(10, "Introduction to Algorithms");

        assertEquals(10, book.cost());
        assertEquals("Introduction to Algorithms", book.name());

        WrappedBook wrappedBook = new WrappedBook(book);
        assertEquals(15, wrappedBook.cost());
        assertEquals("Introduction to Algorithms (Wrapped)", wrappedBook.name());

        book = wrappedBook.unwrap();

        assertEquals(10, book.cost());
        assertEquals("Introduction to Algorithms", book.name());
    }
}
