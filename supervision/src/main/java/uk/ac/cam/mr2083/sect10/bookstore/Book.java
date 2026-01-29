package uk.ac.cam.mr2083.sect10.bookstore;

public class Book extends BaseBook implements Sellable {
    private final int cost;
    private final String name;

    public Book(int cost, String name) {
        super();
        this.cost = cost;
        this.name = name;
    }

    @Override
    public int cost() {
        return this.cost;
    }

    @Override
    public String name() {
        return this.name;
    }
}
