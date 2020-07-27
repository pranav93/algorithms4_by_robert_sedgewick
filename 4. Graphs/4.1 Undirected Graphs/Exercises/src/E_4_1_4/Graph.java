package E_4_1_4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.SET;

public class Graph {
    private final int V;
    private int E;
    private SET<Integer>[] adj;

    Graph(int V) {
        this.V = V;
        this.E = 0;
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

    public void addEdge(int v, int w) {
        this.adj[v].add(w);
        this.adj[w].add(v);
        this.E++;
    }

    public int V() {
        return this.V;
    }

    public int E() {
        return this.E;
    }

    public Iterable<Integer> adj(int v) {
        return this.adj[v];
    }

    public boolean hasEdge(int v, int w) {
        for (int setVal : this.adj[v]) {
            if (setVal == w) {
                return true;
            }
        }
        return false;
    }
}