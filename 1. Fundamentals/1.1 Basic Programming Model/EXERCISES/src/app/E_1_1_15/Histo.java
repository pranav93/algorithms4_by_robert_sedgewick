package app.E_1_1_15;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdOut;

/*
1.1.15 Write a static method histogram() that takes an array a[] of int values and
an integer M as arguments and returns an array of length M whose ith entry is the number
of times the integer i appeared in the argument array. If the values in a[] are all
between 0 and M–1, the sum of the values in the returned array should be equal to
a.length.
*/

public class Histo {
    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 3, 3, 4, 5, 6, 7, 8 };
        int m = 9;
        int[] res = histogram(arr, m);

        StdOut.println(Arrays.toString(res));

        StdOut.println(arr.length);
        StdOut.println(sum(res));
    }

    private static int[] histogram(int[] arr, int m) {
        int[] h = new int[m];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < m) {
                h[arr[i]]++;
            }
        }

        return h;
    }

    private static int sum(int[] arr) {
        int s = 0;
        for (int i = 0; i < arr.length; i++) {
            s += arr[i];
        }
        return s;
    }
}