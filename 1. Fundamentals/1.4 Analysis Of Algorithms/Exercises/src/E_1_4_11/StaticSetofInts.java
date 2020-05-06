package E_1_4_11;

import java.util.Arrays;

public class StaticSetofInts {
    private int[] a;

    public StaticSetofInts(int[] keys) {
        this.a = new int[keys.length];
        for (int i = 0; i < keys.length; i++) {
            this.a[i] = keys[i];
        }
        Arrays.sort(this.a);
    }

    public boolean contains(int key) {
        return rank(key) != -1;
    }

    private int rank(int key) {
        int lo = 0;
        int hi = this.a.length - 1;
        int mid = 0;

        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (key < this.a[mid]) {
                hi = mid - 1;
            } else if (key < this.a[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public int occurs(int key) {
        int lo = 0;
        int hi = this.a.length - 1;
        return occurs(key, lo, hi);
    }

    private int occurs(int key, int lo, int hi) {
        int mid = 0;

        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (key < this.a[mid]) {
                hi = mid - 1;
            } else if (key > this.a[mid]) {
                lo = mid + 1;
            } else {
                int o1 = occurs(key, lo, mid - 1);
                int o2 = occurs(key, mid + 1, hi);
                return 1 + o1 + o2;
            }
        }

        return 0;
    }
}