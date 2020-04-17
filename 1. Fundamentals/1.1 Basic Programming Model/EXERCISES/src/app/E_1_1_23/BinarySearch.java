package app.E_1_1_23;

import java.util.Arrays;

import edu.princeton.cs.algs4.*;

public class BinarySearch {
    public static int rank(int key, int[] a) { // Array must be sorted.
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) { // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid])
                hi = mid - 1;
            else if (key > a[mid])
                lo = mid + 1;
            else
                return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] whitelist = In.readInts(args[0]);
        String s = args[1];
        Arrays.sort(whitelist);
        while (!StdIn.isEmpty()) { // Read key, print if not in whitelist.
            int key = StdIn.readInt();
            if (rank(key, whitelist) < 0) {
                if (s.equals("+")) {
                    StdOut.println(key);
                }
            } else {
                if (s.equals("-")) {
                    StdOut.println(key);
                }
            }
        }
    }
}