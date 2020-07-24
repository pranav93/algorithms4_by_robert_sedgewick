package DepthFirstSearch;

import Graph.Graph;

public class DepthFirstSearch {
    private boolean[] marked;
    private int count;

    public DepthFirstSearch(Graph G, int s) {
        this.marked = new boolean[G.V()];
        this.dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        this.marked[v] = true;
        this.count++;
        for (int w : G.adj(v)) {
            if (!this.marked[w]) {
                dfs(G, w);
            }
        }
    }

    public boolean marked(int w) {
        return this.marked[w];
    }

    public int count() {
        return this.count;
    }
}