package app.E_1_2_9;

import java.util.Arrays;

import edu.princeton.cs.algs4.Counter;

public class BinarySearch {
    int[] myArr;
    int length;

    BinarySearch(int[] arr) {
        this.length = arr.length;
        this.myArr = new int[this.length];
        for (int i = 0; i < this.length; i++) {
            this.myArr[i] = arr[i];
        }
        Arrays.sort(this.myArr);
    }

    public int rank(int lo, int hi, int key, Counter counter) {
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            counter.increment();
            if (key == this.myArr[mid]) {
                return mid;
            }
            if (key < this.myArr[mid]) {
                hi = mid - 1;
            }
            if (key > this.myArr[lo]) {
                lo = mid + 1;
            }
        }
        return -1;
    }

    public int rank(int key, Counter counter) {
        int hi = this.length - 1;
        int lo = 0;
        return rank(lo, hi, key, counter);
    }
}