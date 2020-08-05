package TransitiveClosure;

import Digraph.Digraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        Digraph G = new Digraph(new In(args[0]));
        TransitiveClosure tc = new TransitiveClosure(G);

        while (!StdIn.isEmpty()) {
            int v = StdIn.readInt();
            int w = StdIn.readInt();
            StdOut.println(v + " reachable to " + w + " -> " + tc.reachable(v, w));
        }
    }
}