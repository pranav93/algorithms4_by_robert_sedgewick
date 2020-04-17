package app.E_1_1_13;

import edu.princeton.cs.algs4.StdOut;

/*
1.1.13 Write a code fragment to print the transposition (rows and columns changed)
of a two-dimensional array with M rows and N columns.
*/

public class Transpose {

    public static void main(String[] args) {
        int[][] a = { { 1, 2, 3, 4, 17 }, { 5, 6, 7, 8, 18 }, { 9, 10, 11, 12, 19 }, { 13, 14, 15, 16, 20 } };

        int rows = 4;
        int columns = 5;

        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                StdOut.printf("%d\t", a[j][i]);
            }
            StdOut.printf("\n");
        }
    }
}