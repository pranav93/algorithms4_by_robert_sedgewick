package E_2_5_8;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        String[] arr = StdIn.readStrings();
        new MergeSort(arr);
        StdOut.println(Arrays.toString(arr));
        freqCount(arr);
    }

    private static void freqCount(String[] a) {
        int N = a.length;
        String[] aUnique = new String[N];
        int[] freq = new int[N];
        int j = 0;

        freq[j]++;
        aUnique[j] = a[0];

        for (int i = 1; i < N; i++) {
            if (a[i].compareTo(a[i - 1]) != 0) {
                aUnique[++j] = a[i];
            }
            freq[j]++;
        }

        StdOut.println(Arrays.toString(aUnique));
        StdOut.println(Arrays.toString(freq));
    }
}