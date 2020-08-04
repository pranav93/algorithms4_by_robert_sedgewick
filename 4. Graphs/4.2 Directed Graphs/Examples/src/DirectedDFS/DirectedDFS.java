package DirectedDFS;

import Digraph.Digraph;

public class DirectedDFS {
    private boolean[] marked;

    public DirectedDFS(Digraph G, int s) {
        this.marked = new boolean[G.V()];
        this.dfs(G, s);
    }

    public DirectedDFS(Digraph G, Iterable<Integer> sources) {
        this.marked = new boolean[G.V()];
        for (int s : sources) {
            if (!this.marked[s]) {
                this.dfs(G, s);
            }
        }
    }

    private void dfs(Digraph G, int v) {
        this.marked[v] = true;

        for (int w : G.adj(v)) {
            if (!this.marked[w]) {
                this.dfs(G, w);
            }
        }
    }

    public boolean marked(int v) {
        return this.marked[v];
    }
}