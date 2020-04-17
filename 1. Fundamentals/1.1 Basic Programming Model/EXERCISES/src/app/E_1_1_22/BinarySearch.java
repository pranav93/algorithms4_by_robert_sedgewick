package app.E_1_1_22;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
1.1.22 Write a version of BinarySearch that uses the recursive rank() given on page
25 and traces the method calls. Each time the recursive method is called, print the argument
values lo and hi, indented by the depth of the recursion. Hint: Add an argument
to the recursive method that keeps track of the depth.
*/

public class BinarySearch {

    static int[] arr;

    private static int rank(int key, int hi, int lo, int depth) {

        StdOut.printf("hi = %d\t lo = %d\t depth = %d\n", hi, lo, depth++);

        if (lo <= hi) { // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if (key < arr[mid]) {
                hi = mid - 1;
                return rank(key, hi, lo, depth);
            } else if (key > arr[mid]) {
                lo = mid + 1;
                return rank(key, hi, lo, depth);
            } else
                return mid;
        }
        return -1;
    }

    public static int rank_runner(int key, int[] whitelist) { // Array must be sorted.
        int lo = 0;
        int hi = whitelist.length - 1;

        arr = whitelist;
        int depth = 0;
        return rank(key, hi, lo, depth);
    }

    public static void main(String[] args) {
        int[] whitelist = In.readInts(args[0]);
        Arrays.sort(whitelist);
        int key = StdIn.readInt();
        if (rank_runner(key, whitelist) < 0) {
            StdOut.println("Not Found");
        } else {
            StdOut.println("Found");
        }
    }
}