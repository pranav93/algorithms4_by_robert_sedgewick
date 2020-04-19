package app.E_1_2_1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class Point2DClient {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        Point2D[] pArr = new Point2D[N];

        StdDraw.setXscale(-1, 2);
        StdDraw.setYscale(-1, 2);
        StdDraw.setPenColor(StdDraw.MAGENTA);
        StdDraw.square(0.5, 0.5, 0.5);
        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        StdDraw.setPenRadius(0.01);

        for (int i = 0; i < N; i++) {
            double x = Math.random();
            double y = Math.random();
            Point2D p = new Point2D(x, y);
            p.draw();
            pArr[i] = p;
        }

        // Brute Force
        double minDist = Double.POSITIVE_INFINITY;
        Point2D minPoint1 = new Point2D(-1, -1);
        Point2D minPoint2 = new Point2D(-1, -1);
        for (int i = 0; i < pArr.length; i++) {
            for (int j = i + 1; j < pArr.length; j++) {
                if (i == j) {
                    continue;
                }
                double dist = pArr[i].distTo(pArr[j]);
                if (dist < minDist) {
                    minDist = dist;
                    minPoint1 = pArr[i];
                    minPoint2 = pArr[j];
                }
            }
        }
        StdOut.printf("minDist %f\n-> ", minDist);
        StdOut.printf("minPoint1 %s\n-> ", minPoint1.toString());
        StdOut.printf("minPoint2 %s\n-> ", minPoint2.toString());
        StdDraw.setPenColor(StdDraw.ORANGE);
        StdDraw.setPenRadius(0.02);
        minPoint1.draw();
        minPoint2.draw();
    }
}