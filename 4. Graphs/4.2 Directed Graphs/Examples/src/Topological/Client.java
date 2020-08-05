package Topological;

import SymbolDigraph.SymbolDigraph;
import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        String filename = args[0];
        String separator = args[1];

        SymbolDigraph sdg = new SymbolDigraph(filename, separator);
        Topological top = new Topological(sdg.G());

        StdOut.println("Is the graph DAG? -> " + top.isDAG());

        for (int i : top.order()) {
            StdOut.println(sdg.name(i));
        }
    }
}