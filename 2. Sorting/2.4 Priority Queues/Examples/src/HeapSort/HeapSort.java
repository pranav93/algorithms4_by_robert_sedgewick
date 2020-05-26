package HeapSort;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class HeapSort {
    public static void main(String[] args) {
        String[] input = StdIn.readLine().split(" ");
        int size = input.length;
        String[] s = new String[size + 1];

        for (int i = 1; i <= size; i++) {
            s[i] = input[i - 1];
        }

        sort(s);
        show(s);
    }

    private static void sort(String[] arr) {
        int N = arr.length - 1;
        for (int i = N / 2; i >= 1; i--) {
            sink(arr, i, N);
        }
        while (N > 1) {
            exch(arr, 1, N--);
            sink(arr, 1, N);
        }
    }

    private static void exch(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void sink(String[] arr, int k, int N) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(arr, j, j + 1)) {
                j++;
            }
            if (less(arr, k, j)) {
                exch(arr, k, j);
            }
            k = j;
        }
    }

    private static boolean less(String[] arr, int i, int j) {
        return arr[i].compareTo(arr[j]) < 0;
    }

    private static void show(String[] arr) {
        int N = arr.length;
        for (int i = 1; i < N; i++) {
            StdOut.print(arr[i] + " ");
        }
        StdOut.println();
    }
}
