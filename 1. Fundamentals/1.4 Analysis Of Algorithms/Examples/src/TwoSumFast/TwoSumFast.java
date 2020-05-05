package TwoSumFast;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class TwoSumFast {
    public static void main(String[] args) {
        int a[] = In.readInts(args[0]);
        Arrays.sort(a);
        int N = a.length;
        int count = 0;

        for (int i = 0; i < N; i++) {
            int item = a[i];
            int j = BinarySearch.rank(a, -1 * item);
            if (j > i) {
                count++;
            }
        }

        StdOut.println(count);
    }
}