package app.E_1_2_2;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Interval1DClient {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        Interval1D[] intervalArr = new Interval1D[N];

        for (int i = 0; i < N; i++) {
            StdOut.println(i);
            double lo = StdIn.readDouble();
            double hi = StdIn.readDouble();
            Interval1D interval = new Interval1D(lo, hi);
            StdOut.println(interval.toString());
            intervalArr[i] = interval;
        }

        // Brute Force
        for (int i = 0; i < intervalArr.length; i++) {
            for (int j = i + 1; j < intervalArr.length; j++) {
                boolean doesInt = intervalArr[i].intersects(intervalArr[j]);
                if (doesInt) {
                    StdOut.printf("%s intersects with %s\n", intervalArr[i].toString(), intervalArr[j].toString());
                }
            }
        }

        StdDraw.setXscale(0, 100);
        StdDraw.setYscale(0, 1);
        for (int i = 0; i < intervalArr.length; i++) {
            intervalArr[i].draw();
        }
    }
}