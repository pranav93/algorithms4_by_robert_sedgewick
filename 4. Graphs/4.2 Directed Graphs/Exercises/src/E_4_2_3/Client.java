package E_4_2_3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        Digraph dg = new Digraph(new In(args[0]));
        StdOut.println(dg);
        StdOut.println("===========================");
        StdOut.println(dg.reverse());
    }
}