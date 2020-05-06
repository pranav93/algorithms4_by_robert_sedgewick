package E_1_4_10;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        StdOut.println("Enter a size of array");
        int N = StdIn.readInt();
        int[] a = new int[N];

        for (int i = 0; i < N; i++) {
            a[i] = StdIn.readInt();
        }

        Arrays.sort(a);
        StdOut.println("Enter a key to search");
        int key = StdIn.readInt();

        int index = BinarySearch.rank(a, key);
        StdOut.printf("Index -> %d\n", index);
    }
}