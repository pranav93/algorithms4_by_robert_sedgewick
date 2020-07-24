package TwoColor;

import Graph.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        In in = new In(args[0]);
        Graph G = new Graph(in);
        TwoColor tw = new TwoColor(G);

        StdOut.println("Is graph bipartite? -> " + tw.isBipartite());
    }
}