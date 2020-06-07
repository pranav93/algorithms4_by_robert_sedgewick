package E_2_5_6;

import edu.princeton.cs.algs4.StdRandom;

public class QuickSelect {
    public static int select(int[] arr, int index) {
        if (index < 0 && index >= arr.length) {
            throw new IllegalArgumentException("Invalid index");
        }
        StdRandom.shuffle(arr);
        int item = select(arr, index, 0, arr.length - 1);
        return item;
    }

    private static int select(int[] arr, int index, int lo, int hi) {
        if (hi <= lo) {
            return arr[lo];
        }
        int j = partition(arr, lo, hi);
        if (j < index) {
            return select(arr, index, j + 1, hi);
        } else if (j > index) {
            return select(arr, index, lo, j - 1);
        } else {
            return arr[index];
        }
    }

    private static int partition(int[] arr, int lo, int hi) {
        int v = arr[lo];
        int i = lo;
        int j = hi + 1;
        while (true) {
            while (less(arr[++i], v)) {
                if (i == hi) {
                    break;
                }
            }
            while (less(v, arr[--j])) {
                if (j == lo) {
                    break;
                }
            }
            if (j <= i) {
                break;
            }
            exch(arr, i, j);
        }
        exch(arr, lo, j);
        return j;
    }

    private static void exch(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static boolean less(int i1, int i2) {
        return i1 < i2;
    }
}