package E_4_1_10;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        Graph G = new Graph(new In(args[0]));
        DepthFirstSearch dfs = new DepthFirstSearch(G, 0);
        StdOut.println(dfs.allNeighboursMarked());
    }
}