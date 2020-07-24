package CC;

import Graph.Graph;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        In in = new In(args[0]);
        Graph G = new Graph(in);
        CC cc = new CC(G);

        int M = cc.count();
        StdOut.println("component count -> " + M);
        Bag<Integer>[] comps = (Bag<Integer>[]) new Bag[M];
        for (int i = 0; i < M; i++) {
            comps[i] = new Bag<Integer>();
        }
        for (int i = 0; i < G.V(); i++) {
            comps[cc.id(i)].add(i);
        }

        for (int i = 0; i < M; i++) {
            StdOut.print(i + " ->");
            for (int j : comps[i]) {
                StdOut.print(" " + j);
            }
            StdOut.println();
        }
    }
}