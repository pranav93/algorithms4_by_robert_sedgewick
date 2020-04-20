package app.E_1_2_3;

import app.E_1_2_2.Interval1D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Interval2DClient {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        Interval2D[] interval2DArr = new Interval2D[N];

        StdDraw.setCanvasSize(1800, 900);
        StdDraw.setXscale(-1, 2);
        StdDraw.setYscale(-1, 2);

        StdDraw.line(0, -1, 0, 2);
        StdDraw.line(-1, 0, 2, 0);

        for (int i = 0; i < N; i++) {
            double hi = StdRandom.uniform(0.1, 1);
            double lo = StdRandom.uniform(0.1, hi);
            Interval1D xInterval1d = new Interval1D(lo, hi);
            hi = StdRandom.uniform(0.1, 1);
            lo = StdRandom.uniform(0.1, hi);
            Interval1D yInterval1d = new Interval1D(lo, hi);
            Interval2D interval2d = new Interval2D(xInterval1d, yInterval1d);
            interval2d.draw();
            interval2DArr[i] = interval2d;
        }

        // Brute Force
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (interval2DArr[i].intersects(interval2DArr[j])) {
                    StdOut.println(i + " " + j + " intersect.");
                }
            }
        }
    }
}