package uk.ac.cam.mr2083.sect10.shape;

public class BorderedShape extends Shape {
    private Canvas canvas;

    public BorderedShape(UnitShape shape) {
        this(shape, 'B');
    }

    public BorderedShape(UnitShape shape, char borderColour) {
        super(shape.getX(), shape.getY(), shape.getColour());
        this.canvas = new Canvas();

        if (shape instanceof Rectangle rectangle) {
            Rectangle border = new Rectangle(
                    rectangle.getX() - 1,
                    rectangle.getY() - 1,
                    rectangle.getWidth() + 2,
                    rectangle.getHeight() + 2,
                    borderColour
            );

            this.canvas.addShape(border);
            this.canvas.addShape(rectangle);
        }
        if (shape instanceof Circle circle) {
            Circle border = new Circle(
                    circle.getX(),
                    circle.getY(),
                    circle.getRadius() + 2,
                    borderColour
            );

            this.canvas.addShape(border);
            this.canvas.addShape(circle);
        }
    }

    @Override
    public void draw(Screen screen) {
        this.canvas.draw(screen);
    }
}
