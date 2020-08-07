package E_4_2_5;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        Digraph dg = new Digraph(new In(args[0]));
        StdOut.println(dg);
        StdOut.println("11 has edge with 8? -> " + dg.hasEdge(11, 8));
        StdOut.println("11 has edge with 1? -> " + dg.hasEdge(11, 1));
        StdOut.println("1 has edge with 11? -> " + dg.hasEdge(1, 11));
    }
}