package E_4_1_13;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        Graph G = new Graph(new In(args[0]));
        BreadthFirstSearch bfs = new BreadthFirstSearch(G, 0);
        StdOut.println("0 to 12 -> " + bfs.pathTo(12));
        StdOut.println("0 to 12 dist -> " + bfs.distTo(12));
        StdOut.println("0 to 4 -> " + bfs.pathTo(4));
        StdOut.println("0 to 4 dist -> " + bfs.distTo(4));
        StdOut.println("0 to 3 -> " + bfs.pathTo(3));
        StdOut.println("0 to 3 dist -> " + bfs.distTo(3));
    }
}