package E_2_5_6;

import java.util.Arrays;

import E_2_5_4.Quick3Way;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        int[] arr = StdIn.readInts();
        int index = 14;
        StdOut.println(Arrays.toString(arr));
        int item = QuickSelect.select(arr, index);
        StdOut.println(Arrays.toString(arr));
        StdOut.println(item);

        Arrays.sort(arr);
        StdOut.println(Arrays.toString(arr));
        StdOut.println(arr[index]);
    }
}