package app.E_1_1_11;

import edu.princeton.cs.algs4.StdOut;

/*
1.1.11 Write a code fragment that prints the contents of a two-dimensional boolean
array, using * to represent true and a space to represent false. Include row and column
numbers.
*/

public class Print2DB {
    public static void main(String[] args) {
        Boolean[][] bArray2D = {
            {true, false, false, true, false, true},
            {false, true, false, true, false, false},
            {true, false, true, false, true, false},
            {false, true, true, false, false, true},
        };

        for (int i = 0; i < bArray2D.length; i++) {
            if (i == 0) {
                // Print column numbers
                int arrLen = bArray2D[i].length;
                int k = 0;
                StdOut.printf("\t");
                while (k < arrLen) {
                    StdOut.printf("%d\t", k);
                    k++;
                }
                StdOut.printf("\n");
            }
            StdOut.printf("%d   ", i);
            for (int j = 0; j < bArray2D[i].length; j++) {

                // Print row numbers

                if (bArray2D[i][j]) {
                    StdOut.printf("\t%s", " ");           
                } else {
                    StdOut.printf("\t%s", "*");
                }
            }
            StdOut.printf("\n");
        }
    }
}