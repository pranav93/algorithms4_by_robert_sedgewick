package E_2_2_9;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class MergeSortAux {
    MergeSortAux(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, 0, a.length - 1, aux);
    }

    private void sort(Comparable[] a, int lo, int hi, Comparable[] aux) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid, aux);
        sort(a, mid + 1, hi, aux);
        merge(a, lo, mid, hi, aux);
    }

    private void merge(Comparable[] a, int lo, int mid, int hi, Comparable[] aux) {
        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
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

    public static void show (Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public static void main(String[] args) {
        String[] s = StdIn.readStrings();
        MergeSortAux m = new MergeSortAux(s);
        assert m.isSorted(s);
        m.show(s);
    }
}