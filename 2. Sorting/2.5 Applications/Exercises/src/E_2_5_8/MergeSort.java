package E_2_5_8;

public class MergeSort {
    String[] aux;

    MergeSort(String[] a) {
        int N = a.length;
        this.aux = new String[N];
        sort(a, 0, N - 1);
    }

    private void sort(String[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    private void merge(String[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            this.aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = this.aux[j++];
            } else if (j > hi) {
                a[k] = this.aux[i++];
            } else if (less(this.aux[i], this.aux[j])) {
                a[k] = this.aux[i++];
            } else {
                a[k] = this.aux[j++];
            }
        }
    }

    private boolean less(String string, String string2) {
        return string.compareTo(string2) < 0;
    }
}