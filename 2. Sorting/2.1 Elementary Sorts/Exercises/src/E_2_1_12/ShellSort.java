package E_2_1_12;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class ShellSort {
    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;

        while (h < N / 3) {
            h = 3 * h + 1;
        }

        double exchanges = 0;
        double arrSize = 0;
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                arrSize += ((N - i) / h);
                for (int j = i; j >= h; j -= h) {
                    if (less(a[j], a[j - h])) {
                        exch(a, j, j - h);
                    }
                    exchanges += 1;
                }
            }
            h /= 3;
        }
        StdOut.print("arr size = N = -> " + N);
        StdOut.println(" | ratio -> " + exchanges / arrSize);
    }

    private static void exch(Comparable[] a, int j, int i) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static boolean isSorted(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static void show(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public static void main(String[] args) {
        int size = 10;
        while (true) {
            Double[] arr = new Double[size];
            StdOut.println("size -> " + size);
            for (int i = 0; i < size; i++) {
                arr[i] = StdRandom.uniform();
            }
            sort(arr);
            StdOut.println("done -> " + size);
            size *= 10;
        }
    }
}