package app.E_1_1_29;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Eq {
    public static int rank(int key, int[] a) { // Array must be sorted.
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) { // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid])
                hi = mid - 1;
            else if (key > a[mid])
                lo = mid + 1;
            else {
                // return mid;
                return findLess(mid, a);
            }
        }
        return -1;
    }

    public static int count(int key, int[] a) { // Array must be sorted.
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) { // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid])
                hi = mid - 1;
            else if (key > a[mid])
                lo = mid + 1;
            else {
                // return mid;
                return findCount(mid, a);
            }
        }
        return -1;
    }

    private static int findCount(int mid, int[] a) {
        int l = a.length;
        int midCount = 0;

        int mid1 = mid;
        while(mid1 > 0 && a[mid1] == a[mid1 - 1]) {
            mid1--;
            midCount++;
        }

        int mid2 = mid;
        while(mid2 < l && a[mid2] == a[mid2 + 1]) {
            mid2++;
            midCount++;
        }

        return ++midCount;
    }

    private static int findLess(int mid, int[] a) {
        while(mid > 0 && a[mid] == a[mid - 1]) {
            mid--;
        }
        return mid;
    }

    public static void main(String[] args) {
        int[] whitelist = In.readInts(args[0]);
        Arrays.sort(whitelist);
        StdOut.println(Arrays.toString(whitelist));

        while (!StdIn.isEmpty()) { // Read key, print if not in whitelist.
            int key = StdIn.readInt();
            int ind = rank(key, whitelist);
            int equalCount = count(key, whitelist);
            StdOut.printf("index -> %d\n", ind);
            StdOut.printf("equalCount -> %d\n", equalCount);
        }
    }

}