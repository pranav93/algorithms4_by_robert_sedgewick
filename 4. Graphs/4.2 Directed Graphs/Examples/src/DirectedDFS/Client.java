package DirectedDFS;

import Digraph.Digraph;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        Digraph DG = new Digraph(new In(args[0]));

        Bag<Integer> bag = new Bag<Integer>();
        for (int i = 1; i < args.length; i++) {
            bag.add(Integer.parseInt(args[i]));
        }
        DirectedDFS dfs = new DirectedDFS(DG, bag);
        for (int i = 0; i < DG.V(); i++) {
            if (dfs.marked(i)) {
                StdOut.print(i + " ");
            }
        }
        StdOut.println();
    }
}