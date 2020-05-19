package E_2_3_6;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class QuickComp {
    public static int sort(Comparable[] a) {
        int compares = 0;
        StdRandom.shuffle(a);
        compares = sort(a, 0, a.length - 1, compares);
        return compares;
    }

    private static int sort(Comparable[] a, int lo, int hi, int compares) {
        if (hi <= lo) {
            return compares;
        }
        int[] res = partition(a, lo, hi, compares);
        int j = res[0];
        int comparesP = res[1];
        int compare1 = sort(a, lo, j - 1, compares);
        int compare2 = sort(a, j + 1, hi, compares);
        compares += comparesP;
        compares += compare1;
        compares += compare2;
        return compares;
    }

    private static int[] partition(Comparable[] a, int lo, int hi, int compares) {
        Comparable v = a[lo];
        int i = lo;
        int j = hi + 1;
        while (true) {
            while (less(a[++i], v)) {
                compares++;
                if (i == hi) {
                    break;
                }
            }
            while (less(v, a[--j])) {
                compares++;
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
        return new int[] { j, compares };
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void show(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public static void main(String[] args) {
        for (int N = 10; N <= 10000; N *= 10) {
            Double[] a = new Double[N];
            for (int i = 0; i < N; i++) {
                a[i] = StdRandom.uniform();
            }
            int compares = sort(a);
            StdOut.printf("Size -> %d | Compares -> %d | 2N*log(N) -> %f\n", N, compares,
                    2 * N * Math.log(N) / Math.log(2));
        }
    }
}