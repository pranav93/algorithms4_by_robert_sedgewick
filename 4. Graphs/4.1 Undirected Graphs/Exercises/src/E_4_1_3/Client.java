package E_4_1_3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        Graph G = new Graph(new In(args[0]));
        int V = G.V();

        for (int i = 0; i < V; i++) {
            StdOut.print(i + " ->");
            for (int w : G.adj(i)) {
                StdOut.print(" " + w);
            }
            StdOut.println();
        }

        StdOut.println("---------------");
        Graph G2 = CopyGraph.copy(G);
        G2.addEdge(8, 9);

        V = G2.V();
        for (int i = 0; i < V; i++) {
            StdOut.print(i + " ->");
            for (int w : G2.adj(i)) {
                StdOut.print(" " + w);
            }
            StdOut.println();
        }
        StdOut.println("---------------");
    }
}