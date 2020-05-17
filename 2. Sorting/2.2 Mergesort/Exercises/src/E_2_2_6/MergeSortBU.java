package E_2_2_6;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class MergeSortBU {
    Comparable[] aux;

    MergeSortBU(Comparable[] a) {
        this.aux = new Comparable[a.length];
        this.sort(a);
    }

    private void sort(Comparable[] a) {
        int N = a.length;

        for (int sz = 2; sz < N; sz *= 2) {
            for (int lo = 0; lo < N; lo += (sz * 2)) {
                this.merge(a, lo, lo + sz - 1, lo + (sz * 2));
            }
        }
    }

    private void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = hi;

        for (int k = lo; k <= hi; i++) {
            this.aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = this.aux[j++];
            } else if (j > hi) {
                a[k] = this.aux[i++];
            } else if (this.less(this.aux[j], this.aux[i])) {
                a[k] = this.aux[j++];
            } else {
                a[k] = this.aux[i++];
            }
        }
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
        String[] s = StdIn.readStrings();
        MergeSortTD m = new MergeSortTD(s);
        assert m.isSorted(s);
        m.show(s);
    }
}