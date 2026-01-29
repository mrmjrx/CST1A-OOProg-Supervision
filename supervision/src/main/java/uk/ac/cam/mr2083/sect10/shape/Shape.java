package uk.ac.cam.mr2083.sect10.shape;

public abstract class Shape {
    private final int x;
    private final int y;
    private final char colour;

    public Shape(int x, int y, char colour) {
        this.x = x;
        this.y = y;
        this.colour = colour;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getColour() {
        return colour;
    }

    public abstract void draw(Screen screen);
}
