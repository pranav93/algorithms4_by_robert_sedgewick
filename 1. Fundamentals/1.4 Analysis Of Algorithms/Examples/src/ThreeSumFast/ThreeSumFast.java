package ThreeSumFast;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class ThreeSumFast {

    public static void main(String[] args) {
        int a[] = In.readInts(args[0]);
        Arrays.sort(a);

        int N = a.length;
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int item = a[i] + a[j];
                int index = BinarySearch.rank(a, -1 * item);
                if (index > j) {
                    count++;
                }
            }
        }

        StdOut.println(count);
    }
}