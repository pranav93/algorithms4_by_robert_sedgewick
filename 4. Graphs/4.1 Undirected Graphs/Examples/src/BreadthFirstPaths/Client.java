package BreadthFirstPaths;

import Graph.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        In in = new In(args[0]);
        Graph G = new Graph(in);
        int s = Integer.parseInt(args[1]);

        BreathFirstPaths search = new BreathFirstPaths(G, s);

        for (int i = 0; i < G.V(); i++) {
            StdOut.print(s + " to " + i + " : ");
            if (search.hasPathTo(i)) {
                for (int j : search.pathTo(i)) {
                    if (j == i) {
                        StdOut.print(j);
                    } else {
                        StdOut.print(j + "-");
                    }
                }
            }
            StdOut.println();
        }
    }
}