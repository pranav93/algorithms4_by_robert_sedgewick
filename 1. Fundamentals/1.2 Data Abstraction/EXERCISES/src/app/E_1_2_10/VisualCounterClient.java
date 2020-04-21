package app.E_1_2_10;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class VisualCounterClient {
    public static void main(String[] args) {
        int max = Integer.parseInt(args[0]);
        int N = Integer.parseInt(args[1]);

        VisualCounter vc = new VisualCounter("myVisCounter", max);

        StdDraw.setCanvasSize(1800, 1000);
        StdDraw.setXscale(-1, N + 1);
        StdDraw.setYscale(-1, max + 1);
        StdDraw.setPenColor(StdDraw.BLACK);

        StdDraw.line(0, -1, 0, max + 1);
        StdDraw.line(-1, 0, N + 1, 0);

        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.setPenRadius(0.005);
        for (int i = 0; i < N; i++) {
            if (StdRandom.bernoulli()) {
                vc.increment();
            } else {
                vc.decrement();
            }
        }
    }
}