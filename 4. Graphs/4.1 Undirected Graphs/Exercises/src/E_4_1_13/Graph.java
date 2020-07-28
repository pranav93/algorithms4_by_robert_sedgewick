package E_4_1_13;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.SET;

public class Graph {
    private final int V;
    private SET<Integer>[] adj;
    private int E;

    Graph(int v) {
        this.V = v;
        this.adj = (SET<Integer>[]) new SET[this.V];
        for (int i = 0; i < this.V; i++) {
            this.adj[i] = new SET<Integer>();
        }
    }

    Graph(In in) {
        this(in.readInt());
        int e = in.readInt();
        for (int i = 0; i < e; i++) {
            int v = in.readInt();
            int w = in.readInt();
            this.addEdge(v, w);
        }
    }

    private void addEdge(int v, int w) {
        this.adj[v].add(w);
        this.adj[w].add(v);
        this.E++;
    }

    public Iterable<Integer> adj(int v) {
        return this.adj[v];
    }

    public int V() {
        return this.V;
    }

    public int E() {
        return this.E;
    }
}