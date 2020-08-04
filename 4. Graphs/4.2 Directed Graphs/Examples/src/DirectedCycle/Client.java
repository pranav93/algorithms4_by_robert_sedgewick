package DirectedCycle;

import Digraph.Digraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        Digraph DG = new Digraph(new In(args[0]));
        DirectedCycle DC = new DirectedCycle(DG);

        if (DC.hasCycle()) {
            StdOut.println("Graph has cycle");
            StdOut.println(DC.cycle());
        } else {
            StdOut.println("Graph does not have cycle");
        }
    }
}