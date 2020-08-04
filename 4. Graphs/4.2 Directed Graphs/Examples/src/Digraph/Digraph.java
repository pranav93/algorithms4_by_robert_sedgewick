package Digraph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

public class Digraph {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    Digraph(int v) {
        this.V = v;
        this.E = 0;
        this.adj = (Bag<Integer>[]) new Bag[this.V];
        for (int i = 0; i < this.V; i++) {
            this.adj[i] = new Bag<Integer>();
        }
    }

    public Digraph(In in) {
        this(in.readInt());
        int e = in.readInt();
        for (int i = 0; i < e; i++) {
            int v = in.readInt();
            int w = in.readInt();
            this.addEdge(v, w);
        }
    }

    public int V() {
        return this.V;
    }

    public int E() {
        return this.E;
    }

    public void addEdge(int v, int w) {
        this.adj[v].add(w);
        this.E++;
    }

    public Iterable<Integer> adj(int v) {
        return this.adj[v];
    }

    public Digraph reverse() {
        Digraph R = new Digraph(this.V);
        for (int i = 0; i < this.V; i++) {
            for (int w : this.adj(i)) {
                R.addEdge(w, i);
            }
        }
        return R;
    }

    @Override
    public String toString() {
        String out = "Directed Graph with vertices " + this.V + " and edges " + this.E + "\n";
        for (int i = 0; i < this.V; i++) {
            out += i + " ->";
            for (int w : this.adj(i)) {
                out += " " + w;
            }
            out += "\n";
        }
        return out;
    }
}