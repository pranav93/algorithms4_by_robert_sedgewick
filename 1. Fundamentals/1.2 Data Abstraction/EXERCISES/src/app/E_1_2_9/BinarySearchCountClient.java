package app.E_1_2_9;

import java.util.Random;

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.StdOut;

public class BinarySearchCountClient {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int key = Integer.parseInt(args[1]);

        Random r = new Random();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = r.nextInt(100);
        }

        Counter counter = new Counter("SearchCount");

        BinarySearch bs = new BinarySearch(arr);
        int res = bs.rank(key, counter);

        StdOut.printf("res -> %d\n", res);
        StdOut.printf("counter -> %s\n", counter.toString());
    }
}