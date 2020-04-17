package app.E_1_1_19;

import java.util.HashMap;
import java.util.Map;

import edu.princeton.cs.algs4.StdOut;

public class Fibonacci {
    static Map<Integer, Long> map = new HashMap<Integer, Long>();

    public static long F(int N) {
        Long val = map.get(N);
        if (val != null) {
            return val;
        }

        if (N == 0)
            return 0;
        if (N == 1)
            return 1;
        val = F(N - 1) + F(N - 2);
        map.put(N, val);
        return val;
    }

    public static void main(String[] args) {
        for (int N = 0; N < 100; N++)
            StdOut.println(N + " " + F(N));
    }
}