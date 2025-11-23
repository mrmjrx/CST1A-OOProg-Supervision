package uk.ac.cam.mr2083.sect2;

public class Vector2D {
    float x = 0;
    float y = 0;

    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D() {
        this(0);
    }

    public Vector2D(float uniform) {
        this(uniform, uniform);
    }

    public void scale(float scaleAmount) {
        this.x *= scaleAmount;
        this.y *= scaleAmount;
    }

    public void add(Vector2D v) {
        this.x += v.x;
        this.y += v.y;
    }

    public void sub(Vector2D v) {
        this.x -= v.x;
        this.y -= v.y;
    }

    public static float dot(Vector2D v1, Vector2D v2) {
        return v1.x * v2.x + v1.y * v2.y;
    }

    public float magnitude() {
        return (float) Math.sqrt(dot(this, this));
    }


    public void normalise() {
        this.scale(1 / magnitude());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Vector2D v) {
            return x == v.x && y == v.y;
        }

        return false;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
