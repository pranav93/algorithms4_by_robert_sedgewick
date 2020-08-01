package DFSWithStack;

import edu.princeton.cs.algs4.In;

import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        In in = new In(args[0]);
        Graph G = new Graph(in);
        int s = Integer.parseInt(args[1]);

        DepthFirstSearch search = new DepthFirstSearch(G, s);

        for (int i = 0; i < G.V(); i++) {
            if (search.marked(i)) {
                StdOut.print(i + " ");
            }
        }
        StdOut.println();

        if (search.count() != G.V()) {
            StdOut.print("NOT ");
        }
        StdOut.println("connected");
        int[] edgeTo = search.edgeTo();

        for (int i = 0; i < edgeTo.length; i++) {
            StdOut.println(i + " -> " + edgeTo[i]);
        }

    }
}