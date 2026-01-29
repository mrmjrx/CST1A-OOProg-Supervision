package uk.ac.cam.mr2083.sect10.shape;

public class Circle extends UnitShape {
    private final int radius;

    public Circle(int x, int y, int radius, char colour) {
        super(x, y, colour);
        this.radius = radius;
    }

    protected boolean isInCircle(int x, int y) {
        int dx = x - this.getX();
        int dy = y - this.getY();

        return (double) (dx * dx + dy * dy) <= (double) (radius * radius) / 4.0;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public void draw(Screen screen) {
        int leftX = Math.max(this.getX() - radius, 0);
        int rightX = Math.min(this.getX() + radius, screen.getWidth() - 1);
        int topY = Math.max(this.getY() - this.radius, 0);
        int bottomY = Math.min(this.getY() + this.radius, screen.getHeight() - 1);

        for (int x = leftX; x <= rightX; x++) {
            if (x >= screen.getWidth()) continue;

            for (int y = topY; y <= bottomY; y++) {
                if (!this.isInCircle(x, y)) continue;

                screen.setPixel(x, y, getColour());
            }
        }
    }
}
