package E_1_4_11;

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

        StaticSetofInts s = new StaticSetofInts(a);
        StdOut.println("Enter a key");
        int key = StdIn.readInt();
        int o = s.occurs(key);
        StdOut.printf("Occurrences -> %d\n", o);
    }
}