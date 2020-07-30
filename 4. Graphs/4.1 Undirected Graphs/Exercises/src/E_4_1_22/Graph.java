package E_4_1_22;

import java.util.HashSet;

public class Graph {
    private final int V;
    private HashSet<Integer>[] adj;
    private int E;

    Graph(int v) {
        this.V = v;
        this.adj = (HashSet<Integer>[]) new HashSet[this.V];
        for (int i = 0; i < this.V; i++) {
            this.adj[i] = new HashSet<Integer>();
        }
    }

    public void addEdge(int v, int w) {
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

    @Override
    public String toString() {
        String out = "";
        for (int i = 0; i < V; i++) {
            out += (i + " ->");
            for (int w : this.adj(i)) {
                out += (" " + w);
            }
            out += "\n";
        }
        return out;
    }

    public Iterable<Integer> adj(int v) {
        return this.adj[v];
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