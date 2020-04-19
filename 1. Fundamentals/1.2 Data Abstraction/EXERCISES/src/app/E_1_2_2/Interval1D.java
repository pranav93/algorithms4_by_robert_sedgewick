package app.E_1_2_2;

import edu.princeton.cs.algs4.StdDraw;

public class Interval1D {
    final double lo;
    final double hi;

    public Interval1D(double lo, double hi) {
        if (hi <= lo) {
            throw new IllegalArgumentException("Hi is less than or equal to low");
        }
        this.lo = lo;
        this.hi = hi;
    }

    public double length() {
        return this.hi - this.lo;
    }

    public boolean contains(double x) {
        return this.lo <= x && x <= this.hi;
    }

    public boolean intersects(Interval1D that) {
        if (this.lo > that.hi) {
            return false;
        }
        if (this.hi < that.lo) {
            return false;
        }
        return true;
    }

    public void draw() {
        StdDraw.line(this.lo, 0.5, this.hi, 0.5);
    }

    public String toString() {
        return "lo -> " + this.lo + " | hi -> " + this.hi;
    }
}