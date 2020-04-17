package app.E_1_1_20;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Facto {
    public static void main(String[] args) {
        int num = StdIn.readInt();
        long res = fact(num);
        StdOut.println(res);
    }

    private static long fact(int num) {
        long res = 1;
        while (num > 0) {
            res *= num;
            num--;
        }
        return res;
    }
}