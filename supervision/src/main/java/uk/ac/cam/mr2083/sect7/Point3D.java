package uk.ac.cam.mr2083.sect7;

import org.jetbrains.annotations.NotNull;

public class Point3D implements Cloneable, Comparable<Point3D> {
    private double x;
    private double y;
    private double z;

    public Point3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getZ() {
        return this.z;
    }

    @Override
    public int compareTo(@NotNull Point3D o) {
        int zComparison = Double.compare(this.z, o.z);
        if (zComparison != 0) return zComparison;

        int yComparison = Double.compare(this.y, o.y);
        if (yComparison != 0) return yComparison;

        return Double.compare(this.x, o.x);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Point3D point)) return false;

        return this.x == point.x && this.y == point.y && this.z == point.z;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
