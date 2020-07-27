package E_4_1_4;

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

        StdOut.println("8 has edge with 9? -> " + G.hasEdge(8, 9));
        StdOut.println("6 has edge with 4? -> " + G.hasEdge(6, 4));
    }
}