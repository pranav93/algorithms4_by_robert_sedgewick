package E_4_1_10;

import edu.princeton.cs.algs4.SET;

public class DepthFirstSearch {
    SET<Integer> allNeighboursMarked = new SET<Integer>();
    int source;
    boolean[] marked;
    Graph G;

    DepthFirstSearch(Graph G, int s) {
        this.G = G;
        this.source = s;
        this.marked = new boolean[this.G.V()];
        this.dfs(this.source);
    }

    private void dfs(int v) {
        this.marked[v] = true;
        boolean allMarked = true;
        for (int w : this.G.adj(v)) {
            if (!this.marked[w]) {
                allMarked = false;
            }
        }
        if (allMarked) {
            this.allNeighboursMarked.add(v);
        }
        for (int w : this.G.adj(v)) {
            if (!this.marked[w]) {
                this.dfs(w);
            }
        }
    }

    public Iterable<Integer> allNeighboursMarked() {
        return this.allNeighboursMarked;
    }
}