package KosarajuSCC;

import Digraph.Digraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        Digraph G = new Digraph(new In(args[0]));
        KosarajuSCC scc = new KosarajuSCC(G);

        StdOut.println("Number of strongly connected components -> " + scc.count());
        for (int i = 0; i < scc.count(); i++) {
            StdOut.println("Component id [" + i + "] ->");
            for (int j = 0; j < G.V(); j++) {
                if (scc.id(j) == i) {
                    StdOut.print(" " + j);
                }
            }
            StdOut.println();
        }
    }
}