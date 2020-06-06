package E_2_5_2;

import java.util.Comparator;

import edu.princeton.cs.algs4.StdRandom;

public class QuickSort {
    public static void sort(String[] arr, Comparator<String> c) {
        StdRandom.shuffle(arr);
        sort(arr, 0, arr.length - 1, c);
    }

    private static void sort(String[] arr, int lo, int hi, Comparator<String> c) {
        if (hi <= lo) {
            return;
        }
        int j = partition(arr, lo, hi, c);
        sort(arr, lo, j - 1, c);
        sort(arr, j + 1, hi, c);
    }

    private static int partition(String[] arr, int lo, int hi, Comparator<String> c) {
        int i = lo;
        int j = hi + 1;
        String v = arr[lo];

        while (true) {
            while (less(arr[++i], v, c)) {
                if (i == hi) {
                    break;
                }
            }
            while (less(v, arr[--j], c) && j > lo) {
                if (i == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exch(arr, i, j);
        }
        exch(arr, lo, j);
        return j;
    }

    private static void exch(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static boolean less(String s1, String s2, Comparator<String> c) {
        return c.compare(s1, s2) < 0;
    }
}