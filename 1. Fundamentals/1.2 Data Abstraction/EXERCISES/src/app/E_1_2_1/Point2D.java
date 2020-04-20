package app.E_1_2_1;

import edu.princeton.cs.algs4.StdDraw;

public class Point2D {
    private final double x;
    private final double y;

    Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double x() {
        return this.x;
    }

    public double y() {
        return this.y;
    }

    public double theta() {
        return Math.atan2(this.y, this.x);
    }

    public double r() {
        return Math.sqrt(this.y * this.y + this.x * this.x);
    }

    public double distTo(Point2D that) {
        double diffX = that.x() - this.x;
        double diffY = that.y() - this.y;
        return Math.sqrt(diffX * diffX + diffY * diffY);
    }

    public void draw() {
        StdDraw.point(this.x, this.y);
    }

    public String toString() {
        return "( " + this.x + " , " + this.y + " )";
    }
}