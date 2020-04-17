package app.E_1_1_24;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class GCD {
    public static void main(String[] args) {
        int num1 = StdIn.readInt();
        int num2 = StdIn.readInt();
        int gcd = calculateGCD(num1, num2);
        StdOut.println(gcd);
    }

    private static int calculateGCD(int num1, int num2) {
        int mod = num1 % num2;
        if (mod == 0) {
            return num2;
        }
        return calculateGCD(num2, mod);
    }
}