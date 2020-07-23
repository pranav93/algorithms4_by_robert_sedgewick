package Graph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

public class Graph {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public Graph(int V) {
        this.V = V;
        this.E = 0;
        this.adj = (Bag<Integer>[]) new Bag[this.V];
        for (int i = 0; i < this.V; i++) {
            this.adj[i] = new Bag<Integer>();
        }
    }

    public Graph(In in) {
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

    public int V() {
        return this.V;
    }

    public int E() {
        return this.E;
    }

    public Iterable<Integer> adj(int v) {
        return this.adj[v];
    }

    public String toString() {
        String out = this.V + " vertices and " + this.E + " edges\n";
        for (int i = 0; i < this.V; i++) {
            out += i + " : ";
            for (int adjVert : this.adj[i]) {
                out += adjVert + " ";
            }
            out += "\n";
        }
        return out;
    }
}