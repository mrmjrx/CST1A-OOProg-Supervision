package uk.ac.cam.mr2083.sect10.shape;

import java.util.LinkedList;
import java.util.List;

public class Canvas extends Shape {
    private List<Shape> shapes = new LinkedList<>();

    public Canvas() {
        super(0, 0, '.');
    }

    public void addShape(Shape shape) {
        this.shapes.add(shape);
    }

    public void clear() {
        this.shapes.clear();
    }

    @Override
    public void draw(Screen screen) {
        for (Shape shape : shapes) {
            shape.draw(screen);
        }
    }
}
