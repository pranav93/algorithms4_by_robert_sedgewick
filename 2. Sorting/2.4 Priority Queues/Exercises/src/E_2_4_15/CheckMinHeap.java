package E_2_4_15;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class CheckMinHeap {
    public static void main(String[] args) {
        String[] input = StdIn.readStrings();
        boolean result = checkMinHeap(input);
        StdOut.println(result);
    }

    private static boolean checkMinHeap(String[] input) {
        int N = input.length;
        int k = 0;
        while (2 * k + 1 < N) {
            int j = 2 * k + 1;

            if (!less(input, k, j)) {
                return false;
            }
            if (j + 1 < N && !less(input, k, ++j)) {
                return false;
            }
            k++;
        }
        return true;
    }

    private static boolean less(String[] input, int k, int j) {
        return input[k].compareTo(input[j]) < 0;
    }
}