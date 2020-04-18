package app.E_1_1_28;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Dedup {
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
        Arrays.sort(whitelist);
        StdOut.println(Arrays.toString(whitelist));

        whitelist = deduplicate(whitelist);
        StdOut.println(Arrays.toString(whitelist));

        while (!StdIn.isEmpty()) { // Read key, print if not in whitelist.
            int key = StdIn.readInt();
            if (rank(key, whitelist) < 0)
                StdOut.println(key);
        }
    }

    private static int[] deduplicate(int[] whitelist) {
        int l = whitelist.length;
        int[] whitelistNew = new int[l];

        int i = 0;
        int j = 0;
        Integer currentElement = null;
        Integer prevElement = null;

        while (i < l) {
            currentElement = whitelist[i];

            if (currentElement == prevElement) {
                i++;
                continue;
            }
            whitelistNew[j++] = currentElement;
            prevElement = currentElement;
            i++;
        }

        int[] anotherWhitelist = new int[j];

        for (int k = 0; k < j; k++) {
            anotherWhitelist[k] = whitelistNew[k];
        }

        return anotherWhitelist;
    }
}