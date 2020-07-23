package Graph;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        In in = new In(args[0]);
        Graph g = new Graph(in);
        StdOut.println(g.toString());
    }
}