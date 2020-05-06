package E_1_4_12;

import edu.princeton.cs.algs4.StdOut;

public class Common {
    public static void main(String[] args) {
        int[] a = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 12, 15, 19 };
        int[] b = new int[] { 3, 4, 5, 8, 10, 11, 12, 13, 14, 15, 16 };

        int Na = a.length;
        int Nb = b.length;
        int i = 0;
        int j = 0;

        while (i < Na && j < Nb) {
            if (a[i] < b[j]) {
                i++;
            } else if (a[i] > b[j]) {
                j++;
            } else {
                StdOut.printf("%d\t", a[i]);
                i++;
                j++;
            }
        }

        StdOut.println();
    }
}