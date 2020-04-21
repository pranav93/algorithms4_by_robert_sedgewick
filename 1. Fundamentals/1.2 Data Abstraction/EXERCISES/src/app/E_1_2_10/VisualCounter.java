package app.E_1_2_10;

import edu.princeton.cs.algs4.StdDraw;

public class VisualCounter {
    private int count;
    private final String name;
    private final int max;
    private int operations;

    VisualCounter(String name, int max) {
        this.name = name;
        this.count = 0;
        this.max = max;
    }

    public void increment() {
        if (this.count < this.max) {
            this.count++;
        }
        drawPoint();
    }

    public void decrement() {
        if (this.count > 0) {
            this.count--;
        }
        drawPoint();
    }

    private void drawPoint() {
        this.operations++;
        StdDraw.point(this.operations, this.count);
        StdDraw.line(this.operations, 0, this.operations, this.count);
    }

    public String toString() {
        return this.count + " " + this.name;
    }
}