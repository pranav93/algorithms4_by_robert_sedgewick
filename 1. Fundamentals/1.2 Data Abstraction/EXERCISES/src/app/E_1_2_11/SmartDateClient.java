package app.E_1_2_11;

import edu.princeton.cs.algs4.StdOut;

public class SmartDateClient {
    public static void main(String[] args) {
        SmartDate sd1 = new SmartDate(01, 01, 1901);
        StdOut.println(sd1);
        StdOut.println(sd1.dayOfTheWeek());
    }
}