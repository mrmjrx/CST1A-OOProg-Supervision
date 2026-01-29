package uk.ac.cam.mr2083.sect10.shape;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Screen {
    private final int width;
    private final int height;

    private char[][] screenBuffer;

    private List<Shape> shapes = new LinkedList<>();

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;
        this.screenBuffer = new char[height][width];

        this.clearBuffer(); // sets buffer to all empty colour
    }

    public void setPixel(int x, int y, char color) {
        this.screenBuffer[y][x] = color;
    }

    public char getPixel(int x, int y) {
        return this.screenBuffer[y][x];
    }

    public String display() {
        StringBuilder display = new StringBuilder();
        display.ensureCapacity(this.screenBuffer.length * (this.screenBuffer[0].length + 1));

        for (char[] row : this.screenBuffer) {
            for (char colour : row) {
                display.append(colour);
            }
            display.append("\n");
        }
        return display.toString();
    }

    public void addShape(Shape shape) {
        this.shapes.add(shape);
    }

    public void removeShape(Shape shape) {
        this.shapes.remove(shape);
    }

    private void clearBuffer() {
        for (int i = 0; i < height; i++) {
            Arrays.fill(this.screenBuffer[i], '.');
        }
    }

    public void clear() {
        this.shapes.clear();
        this.clearBuffer();
    }

    public void renderToScreen() {
        for (Shape shape : this.shapes) {
            shape.draw(this);
        }
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public static void main(String[] args) {
        System.out.println(" --- BASIC TEST --- ");
        Screen screen = new Screen(25, 10);
        screen.addShape(new Circle(12, 5, 2, 'R'));
        screen.addShape(new Rectangle(5, 5, 2, 2, 'Y'));
        screen.renderToScreen();

        System.out.println(screen.display());
        screen.clear();

        System.out.println("\n\n --- CANVAS TEST ---");
        Canvas canvas = new Canvas();
        canvas.addShape(new Circle(12, 5, 5, 'B'));
        canvas.addShape(new Circle(12, 5, 3, 'R'));
        screen.addShape(canvas);

        canvas.addShape(new Rectangle(5, 5, 4, 2, 'Y'));
        screen.renderToScreen();
        System.out.println(screen.display());
        screen.clear();

        System.out.println("\n\n --- BORDERING TEST ---");
        Rectangle rectangle = new Rectangle(5, 5, 4, 2, 'Y');
        screen.addShape(new BorderedShape(rectangle));
        screen.addShape(new Rectangle(0, 0, 3, 3, 'G'));
        screen.addShape(new BorderedShape(new Circle(12, 5, 3, 'R')));

        screen.renderToScreen();
        System.out.println(screen.display());
        screen.clear();
    }
}
