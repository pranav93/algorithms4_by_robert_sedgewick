package E_4_1_10;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.SET;

public class Graph {
    private final int V;
    public int E;
    private SET<Integer>[] adj;

    Graph(int v) {
        this.V = v;
        this.adj = (SET<Integer>[]) new SET[this.V];

        for (int i = 0; i < this.V; i++) {
            this.adj[i] = new SET<Integer>();
        }
    }

    Graph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
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

    public int E() {
        return this.E;
    }

    public int V() {
        return this.V;
    }

    public Iterable<Integer> adj(int v) {
        return this.adj[v];
    }
}