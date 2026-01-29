package uk.ac.cam.mr2083.sect11;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();

    public Library(List<Book> books) {
        this.books = books;
    }

    public Library() {}

    public void addBook(Book book) {
        this.books.add(book);
    }

    private List<String> getLongBookTitles(int pageCountCutoff) {
        return this.books.stream()
                .filter(book -> book.pages() > pageCountCutoff)
                .map(Book::title)
                .sorted()
                .toList();
    }

    public List<String> getLongBookTitles() {
        return this.getLongBookTitles(500);
    }
}
