package Cycle;

import Graph.Graph;

public class Cycle {
    private boolean[] marked;
    private boolean hasCycle;

    Cycle(Graph G) {
        this.marked = new boolean[G.V()];

        for (int v = 0; v < G.V(); v++) {
            if (!this.marked[v]) {
                this.dfs(G, v);
            }
        }
    }

    private void dfs(Graph G, int v) {
        this.marked[v] = true;
        for (int w : G.adj(v)) {
            if (!this.marked[w]) {
                this.dfs(G, w);
            } else if (w != v) {
                this.hasCycle = true;
            }
        }
    }

    public boolean hasCycle() {
        return this.hasCycle;
    }
}