package app.E_1_1_14;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Base2 {
    public static void main(String[] args) {
        int num = StdIn.readInt();
        int steps = 0;

        while (num > 1) {
            num /= 2;
            steps++;
        }

        StdOut.println(steps);
    }
}