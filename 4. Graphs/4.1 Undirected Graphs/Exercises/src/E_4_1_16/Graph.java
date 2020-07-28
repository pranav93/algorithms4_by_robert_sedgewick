package E_4_1_16;

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
        in.readLine();
        while (in.hasNextLine()) {
            String line = in.readLine();
            String[] inpArr = line.split(" ");
            int v = Integer.parseInt(inpArr[0]);
            for (int i = 1; i < inpArr.length; i++) {
                int w = Integer.parseInt(inpArr[i]);
                this.addEdge(v, w);
            }
        }
    }

    public void addEdge(int v, int w) {
        // SET avoids parallel edges
        if (v == w) {
            // Avoids self loop
            return;
        }
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
}