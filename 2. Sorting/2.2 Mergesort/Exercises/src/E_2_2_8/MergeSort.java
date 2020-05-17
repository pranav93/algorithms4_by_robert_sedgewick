package E_2_2_8;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class MergeSort {
    Comparable[] aux;
    public int compares;

    MergeSort(Comparable[] a) {
        this.aux = new Comparable[a.length];
        int compares = 0;
        compares = this.sort(a, 0, a.length - 1, compares);
        this.compares = compares;
    }

    private int sort(Comparable[] a, int lo, int hi, int compares) {
        if (hi <= lo) {
            return compares;
        }
        int mid = lo + (hi - lo) / 2;
        int compares1 = this.sort(a, lo, mid, compares);
        int compares2 = this.sort(a, mid + 1, hi, compares);
        compares = compares1 + compares2;
        compares = this.merge(a, lo, mid, hi, compares);
        return compares;
    }

    private int merge(Comparable[] a, int lo, int mid, int hi, int compares) {
        int i = lo;
        int j = mid + 1;

        if (this.less(a[mid], a[j])) {
            return ++compares;
        }

        for (int k = lo; k <= hi; k++) {
            this.aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = this.aux[j++];
            } else if (j > hi) {
                a[k] = this.aux[i++];
            } else if (this.less(this.aux[j], this.aux[i])) {
                a[k] = this.aux[j++];
                ++compares;
            } else {
                a[k] = this.aux[i++];
                ++compares;
            }
        }

        return compares;
    }

    private boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public boolean isSorted(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            if (this.less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public void show(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public static void main(String[] args) {
        String[] a = StdIn.readStrings();
        MergeSort m = new MergeSort(a);
        assert m.isSorted(a);
        m.show(a);
        StdOut.printf("Compares -> %d\n", m.compares);
    }
}