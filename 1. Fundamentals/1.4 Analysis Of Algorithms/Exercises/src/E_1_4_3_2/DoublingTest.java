package E_1_4_3_2;

import ThreeSum.ThreeSum;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class DoublingTest {
    public static double timeTrial(int N) {
        int MAX = 1000000;
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(-MAX, MAX);
        }
        Stopwatch timer = new Stopwatch();
        int cnt = ThreeSum.count(a);
        return timer.elapsedTime();
    }

    public static void main(String[] args) {
        StdDraw.setCanvasSize(1800, 900);
        StdDraw.setXscale(-1, 20);
        StdDraw.setYscale(-5, 10);
        StdDraw.setPenRadius(0.01);
        StdDraw.line(-1, 0, 20, 0);
        StdDraw.line(0, -5, 0, 10);

        double prevX = 0;
        double prevY = 0;
        for (int N = 250; true; N += N) {
            double time = timeTrial(N);
            double logN = Math.log(N);
            double logT = Math.log(time);
            StdOut.printf("%5.1f %5.1f\n", logN, logT);
            StdDraw.setPenRadius(0.05);
            StdDraw.setPenColor(StdDraw.BOOK_BLUE);
            StdDraw.point(logN, logT);

            StdDraw.setPenRadius(0.01);
            StdDraw.setPenColor(StdDraw.RED);

            if (N == 250) {
                prevX = logN;
                prevY = logT;
                continue;                    
            }
            StdDraw.line(prevX, prevY, logN, logT);
            prevX = logN;
            prevY = logT;
        }
    }
}