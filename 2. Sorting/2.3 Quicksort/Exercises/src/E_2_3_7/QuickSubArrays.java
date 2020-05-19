package E_2_3_7;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class QuickSubArrays {
    public static int[] sort(Comparable[] a) {
        int[] compArr = new int[3];
        sort(a, 0, a.length - 1, compArr);
        return compArr;
    }

    private static void sort(Comparable[] a, int lo, int hi, int[] compArr) {
        if (hi <= lo) {
            return;
        }

        int sz = hi - lo;
        if (sz < 3) {
            compArr[sz]++;
        }

        int j = partition(a, lo, hi);
        sort(a, lo, j - 1, compArr);
        sort(a, j + 1, hi, compArr);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        Comparable v = a[lo];
        int i = lo;
        int j = hi + 1;

        while (true) {
            while (less(a[++i], v)) {
                if (i == hi) {
                    break;
                }
            }
            while (less(v, a[--j])) {
                if (j == lo) {
                    break;
                }
            }
            if (j <= i) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void main(String[] args) {
        for (int N = 10; N <= 1000000; N *= 10) {
            Double[] a = new Double[N];
            for (int i = 0; i < N; i++) {
                a[i] = StdRandom.uniform();
            }
            int[] compA = sort(a);
            StdOut.printf("Size -> %d | arraySize -> %s\n", N, Arrays.toString(compA));
        }
    }
}