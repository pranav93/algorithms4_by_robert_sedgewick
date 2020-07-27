package E_4_1_5;

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
    }
}