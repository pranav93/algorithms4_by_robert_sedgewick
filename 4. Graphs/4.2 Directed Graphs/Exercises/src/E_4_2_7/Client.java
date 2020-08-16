package E_4_2_7;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        Digraph G = new Digraph(new In(args[0]));
        StdOut.println(G);
        Degrees dg = new Degrees(G);
        for (int i = 0; i < G.V; i++) {
            StdOut.println(i + " -> outdegree is "+ dg.outdegree(i));
        }
        for (int i = 0; i < G.V; i++) {
            StdOut.println(i + " -> indegree is "+ dg.indegree(i));
        }

        StdOut.print("Sources ->");
        for (int i : dg.sources()) {
            StdOut.print(" " + i);            
        }
        StdOut.println();

        StdOut.print("Sinks ->");
        for (int i : dg.sinks()) {
            StdOut.print(" " + i);            
        }
        StdOut.println();
    }
}