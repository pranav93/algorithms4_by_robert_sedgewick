package app.E_1_1_31;

import java.util.Random;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class RandomCon {
    public static void main(String[] args) {
        int N = StdIn.readInt();
        double p = StdIn.readDouble();

        StdOut.println(N);
        StdOut.println(p);

        double radius = 0.4;

        double[] xPoints = new double[N];
        double[] yPoints = new double[N];

        StdDraw.setPenRadius(0.001);
        StdDraw.setPenColor(StdDraw.MAGENTA);
        StdDraw.point(0.5, 0.5);
        StdDraw.circle(0.5, 0.5, radius);

        StdDraw.setPenRadius(0.01);
        for (int i = 0; i < N; i++) {
            double angle = i * 2 * Math.PI / N;
            double x = radius * Math.cos(angle);
            double y = radius * Math.sin(angle);
            xPoints[i] = 0.5 + x;
            yPoints[i] = 0.5 + y;
            StdDraw.point(xPoints[i], yPoints[i]);
        }

        for (int i = 0; i < N - 1; i++) {
            if (new Random().nextDouble() <= p) {
                StdDraw.line(xPoints[i], yPoints[i], xPoints[i + 1], yPoints[i + 1]);
            }
        }
    }
}