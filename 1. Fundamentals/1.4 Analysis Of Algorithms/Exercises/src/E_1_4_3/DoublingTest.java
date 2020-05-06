package E_1_4_3;

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
        StdDraw.setXscale(-100, 16000);
        StdDraw.setYscale(-1, 50);
        StdDraw.setPenRadius(0.01);
        StdDraw.line(-1, 0, 16000, 0);
        StdDraw.line(0, -1, 0, 50);

        double prevX = 0;
        double prevY = 0;
        for (int N = 250; true; N += N) {
            double time = timeTrial(N);
            StdOut.printf("%7d %5.1f\n", N, time);
            StdDraw.setPenRadius(0.05);
            StdDraw.setPenColor(StdDraw.BOOK_BLUE);
            StdDraw.point(N, time);

            StdDraw.setPenRadius(0.01);
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.line(prevX, prevY, N, time);
            prevX = N;
            prevY = time;
        }
    }
}