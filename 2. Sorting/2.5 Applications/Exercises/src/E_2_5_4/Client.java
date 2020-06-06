package E_2_5_4;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        String[] arr = StdIn.readStrings();
        StdOut.println(Arrays.toString(arr));
        Quick3Way.sort(arr);
        StdOut.println(Arrays.toString(arr));
        dedup(arr);
    }

    private static void dedup(String[] arr) {
        int N = arr.length;
        StdOut.print("[ ");
        StdOut.print(arr[0] + ", ");
        for (int i = 1; i < N; i++) {
            if (arr[i].compareTo(arr[i - 1]) != 0) {
                StdOut.print(arr[i] + ", ");
            }
        }
        StdOut.print("\b\b ]\n");
    }
}