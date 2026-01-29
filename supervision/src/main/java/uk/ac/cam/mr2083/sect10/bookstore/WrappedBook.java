package uk.ac.cam.mr2083.sect10.bookstore;

public class WrappedBook extends BaseBook implements Sellable {
    public static final int WRAPPED_SURCHARGE = 5;

    private final Book book;

    public WrappedBook(Book book) {
        super();
        this.book = book;
    }

    public Book unwrap() {
        return this.book;
    }

    @Override
    public String name() {
        return this.book.name() + " (Wrapped)";
    }

    @Override
    public int cost() {
        return this.book.cost() + WrappedBook.WRAPPED_SURCHARGE;
    }
}
