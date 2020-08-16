package E_4_2_7;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Digraph {
    int V;
    int E;
    Bag<Integer>[] adj;
    Digraph GRev;

    Digraph(int v) {
        this.V = v;
        this.adj = (Bag<Integer>[]) new Bag[this.V];

        for (int i = 0; i < this.V; i++) {
            this.adj[i] = new Bag<Integer>();
        }
    }

    Digraph(In in) {
        this(in.readInt());
        int e = in.readInt();
        for (int i = 0; i < e; i++) {
            int v = in.readInt();
            int w = in.readInt();
            this.addEdge(v, w);
        }
        this.reverseDigraph();
    }

    private void reverseDigraph() {
        this.GRev = new Digraph(this.V);

        for (int i = 0; i < this.V; i++) {
            for (int w : this.adj[i]) {
                this.GRev.addEdge(w, i);
            }
        }
    }

    private void addEdge(int v, int w) {
        if (v == w) {
            StdOut.println("Self loop is not allowed for " + v + " -> " + w);
            return;
        } else if (this.hasEdge(v, w)) {
            StdOut.println("Parallel edges are not allowed for " + v + " -> " + w);
            return;
        }
        this.adj[v].add(w);
        this.E++;
    }

    public Digraph reverse() {
        return this.GRev;
    }

    public Iterable<Integer> adj(int v) {
        return this.adj[v];
    }

    @Override
    public String toString() {
        String out = "Graph with " + this.V + " vertices and " + this.E + " edges\n";

        for (int v = 0; v < this.V; v++) {
            out += v + " ->";
            for (int w : this.adj[v]) {
                out += " " + w;
            }
            out += "\n";
        }

        return out;
    }

    public boolean hasEdge(int v, int w) {
        for (int i : this.adj[v]) {
            if (i == w) {
                return true;
            }
        }
        return false;
    }

}