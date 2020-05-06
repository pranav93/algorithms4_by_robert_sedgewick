package E_1_4_8;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class EqualPairs {
    public static void main(String[] args) {
        int[] a = StdIn.readInts();
        int count = 0;
        Arrays.sort(a);

        for (int i = 0; i < a.length; i++) {
            int item = a[i];
            int index = BinarySearch.rank(a, i + 1, item);
            if (index > i) {
                count++;
            }
        }

        StdOut.println(count);
    }
}