package E_2_2_6;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class MergeSortBU {
    Comparable[] aux;
    int accesses;

    MergeSortBU(Comparable[] a) {
        this.aux = new Comparable[a.length];
        int accesses = 0;
        accesses = this.sort(a, accesses);
        this.accesses = accesses;
    }

    private int sort(Comparable[] a, int accesses) {
        int N = a.length;

        for (int sz = 2; sz < N; sz *= 2) {
            for (int lo = 0; lo < N; lo += (sz * 2)) {
                accesses += this.merge(a, lo, lo + sz - 1, lo + (sz * 2), accesses);
            }
        }

        return accesses;
    }

    private int merge(Comparable[] a, int lo, int mid, int hi, int accesses) {
        int i = lo;
        int j = hi;

        for (int k = lo; k <= hi; i++) {
            this.aux[k] = a[k];
            accesses += 2;
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = this.aux[j++];
                accesses += 2;
            } else if (j > hi) {
                a[k] = this.aux[i++];
                accesses += 2;
            } else if (this.less(this.aux[j], this.aux[i])) {
                a[k] = this.aux[j++];
                accesses += 4;
            } else {
                a[k] = this.aux[i++];
                accesses += 4;
            }
        }

        return accesses;
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
        StdDraw.setCanvasSize(1000, 1000);
        StdDraw.setXscale(-1, 513);
        StdDraw.setYscale(-1, 28000);
        StdDraw.line(0, -1, 0, 28000);
        StdDraw.line(-1, 0, 512, 0);

        StdDraw.setPenRadius(0.01);

        for (int sz = 1; sz <= 512; sz++) {
            Double[] s = new Double[sz];
            for (int i = 0; i < sz; i++) {
                s[i] = StdRandom.uniform();
            }
            MergeSortTD m = new MergeSortTD(s);
            assert m.isSorted(s);
            // m.show(s);
            double formulae = 6 * sz * Math.log(sz) / Math.log(2);
            StdOut.printf("Size -> %d | Accesses -> %d | 6 * N * lgN -> %f \n", sz, m.accesses, formulae);

            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.point(sz, formulae);
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.point(sz, m.accesses);
        }
    }
}