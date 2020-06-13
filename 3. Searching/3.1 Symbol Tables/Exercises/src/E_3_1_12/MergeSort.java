package E_3_1_12;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class MergeSort<SortItem extends Comparable<SortItem>> {
    SortItem[] arrAux;

    MergeSort(SortItem[] arr) {
        int length = arr.length;
        this.arrAux = (SortItem[]) new Comparable[length];
        sort(arr, 0, length - 1);
    }

    private void sort(SortItem[] arr, int lo, int hi) {
        if (hi <= lo) {
            return;
        }

        int mid = lo + (hi - lo) / 2;
        sort(arr, lo, mid);
        sort(arr, mid + 1, hi);

        for (int k = lo; k <= hi; k++) {
            this.arrAux[k] = arr[k];
        }

        for (int k = lo, i = lo, j = mid + 1; k <= hi; k++) {
            if (i > mid) {
                arr[k] = this.arrAux[j++];
            } else if (j > hi) {
                arr[k] = this.arrAux[i++];
            } else if (less(this.arrAux[j], this.arrAux[i])) {
                arr[k] = this.arrAux[j++];
            } else {
                arr[k] = this.arrAux[i++];
            }
        }
    }

    private boolean less(SortItem item, SortItem item2) {
        return item.compareTo(item2) < 0;
    }

    public static void main(String[] args) {
        String[] strArr = StdIn.readStrings();
        new MergeSort<String>(strArr);
        StdOut.println(Arrays.toString(strArr));
    }
}