package E_2_2_6;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class MergeSortTD {
    Comparable[] aux;
    public int accesses = 0;

    public MergeSortTD(Comparable[] a) {
        this.aux = new Comparable[a.length];
        int arrAccesses = 0;
        arrAccesses = this.sort(a, 0, a.length - 1, arrAccesses);
        this.accesses = arrAccesses;
    }

    private int sort(Comparable[] a, int lo, int hi, int arrAccesses) {
        if (hi <= lo) {
            return 0;
        }
        int mid = lo + (hi - lo) / 2;
        int arrAccessesSort1 = this.sort(a, lo, mid, arrAccesses);
        int arrAccessesSort2 = this.sort(a, mid + 1, hi, arrAccesses);
        arrAccesses = arrAccesses + arrAccessesSort1 + arrAccessesSort2;
        arrAccesses = this.merge(a, lo, mid, hi, arrAccesses);
        return arrAccesses;
    }

    private int merge(Comparable[] a, int lo, int mid, int hi, int arrAccesses) {
        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            this.aux[k] = a[k];
            arrAccesses += 2;
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = this.aux[j++];
                arrAccesses += 2;
            } else if (j > hi) {
                a[k] = this.aux[i++];
                arrAccesses += 2;
            } else if (this.less(this.aux[j], this.aux[i])) {
                a[k] = this.aux[j++];
                arrAccesses += 4;
            } else {
                a[k] = this.aux[i++];
                arrAccesses += 4;
            }
        }

        return arrAccesses;
    }

    private boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public void show(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
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