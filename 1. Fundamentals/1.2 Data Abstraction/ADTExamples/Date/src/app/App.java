package app;

import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.StdOut;

public class App {
    public static void main(String[] args) throws Exception {
        int m = Integer.parseInt(args[0]);
        int d = Integer.parseInt(args[1]);
        int y = Integer.parseInt(args[2]);
        Date date = new Date(m, d, y);
        StdOut.println(date);
    }
}