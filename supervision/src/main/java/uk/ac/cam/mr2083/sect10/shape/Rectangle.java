package uk.ac.cam.mr2083.sect10.shape;

public class Rectangle extends UnitShape {
    private final double width;
    private final double height;

    public Rectangle(int x, int y, double width, double height, char colour) {
        super(x, y, colour);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public void draw(Screen screen) {
        for (int i = 0; i < width; i++) {
            int x = this.getX() + i;

            if (x < 0 || x >= screen.getWidth()) continue;

            for (int j = 0; j < height; j++) {
                int y = this.getY() + j;

                if (y < 0 || y >= screen.getHeight()) continue;

                screen.setPixel(x, y, getColour());
            }
        }
    }
}
