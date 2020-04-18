package app.E_1_1_30;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class RelPrime {
    public static void main(String[] args) {
        int size = StdIn.readInt();
        boolean[][] arr = new boolean[size][size];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = isRelPrime(i + 1, j + 1);
                StdOut.printf("%b\t", arr[i][j]);
            }
            StdOut.println();
        }
    }

    private static boolean isRelPrime(int i, int j) {
        int g = gcd(i, j);
        return (g == i) || (g == j);
    }

    private static int gcd(int i, int j) {
        int mod = i % j;
        if (mod == 0) {
            return j;
        }
        return gcd(j, mod);
    }
}