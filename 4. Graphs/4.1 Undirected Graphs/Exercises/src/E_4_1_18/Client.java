package E_4_1_18;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        Graph G = new Graph(new In(args[0]));
        StdOut.println(G);

        for (int i = 0; i < G.V(); i++) {
            FindSmallestCycle fg = new FindSmallestCycle(G, i);
            StdOut.println("path -> " + fg.path());
            StdOut.println("cycleSize -> " + fg.cycleSize());
            StdOut.println("-------------------------------");
        }
    }
}