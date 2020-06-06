package E_2_5_4;

import edu.princeton.cs.algs4.StdRandom;

public class Quick3Way {
    public static void sort(String[] arr) {
        StdRandom.shuffle(arr);
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(String[] arr, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        
        // 3 way partition
        int lt = lo;
        int gt = hi;
        String v = arr[lo];
        int i = lo + 1;
        while (i <= gt) {
            int cmp = arr[i].compareTo(v);
            if (cmp < 0) {
                exch(arr, lt++, i++);
            } else if (cmp > 0) {
                exch(arr, i, gt--);
            } else {
                i++;
            }
        }

        sort(arr, lo, lt - 1);
        sort(arr, gt + 1, hi);
    }

    private static void exch(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}