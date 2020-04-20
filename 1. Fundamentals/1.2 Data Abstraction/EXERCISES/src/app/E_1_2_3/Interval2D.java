package app.E_1_2_3;

import app.E_1_2_1.Point2D;
import app.E_1_2_2.Interval1D;
import edu.princeton.cs.algs4.StdDraw;

public class Interval2D {
    private final Interval1D xInterval;
    private final Interval1D yInterval;

    Interval2D(Interval1D x, Interval1D y) {
        this.xInterval = x;
        this.yInterval = y;
    }

    public Interval1D xInterval() {
        return this.xInterval;
    }

    public Interval1D yInterval() {
        return this.yInterval;
    }

    public double area() {
        return this.xInterval.length() * this.yInterval.length();
    }

    public boolean contains(Point2D p) {
        return this.xInterval.contains(p.x()) && this.yInterval.contains(p.y());
    }

    public boolean intersects(Interval2D that) {
        return this.xInterval.intersects(that.xInterval()) && this.yInterval.intersects(that.yInterval());
    }

    void draw() {
        StdDraw.rectangle(this.xInterval.lo() + this.xInterval.hi() / 2, this.yInterval.lo() + this.yInterval.hi() / 2,
                this.xInterval.length() / 2, this.yInterval.length() / 2);
    }
}