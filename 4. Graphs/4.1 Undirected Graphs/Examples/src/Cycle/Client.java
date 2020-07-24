package Cycle;

import Graph.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        In in = new In(args[0]);
        Graph G = new Graph(in);
        Cycle c = new Cycle(G);

        StdOut.println("hasCycle -> " + c.hasCycle());
    }
}