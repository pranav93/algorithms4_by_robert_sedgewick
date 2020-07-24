package CC;

import Graph.Graph;

public class CC {
    private boolean[] marked;
    private int[] connectedCompIds;
    private int count;

    public CC(Graph G) {
        this.count = 0;
        this.marked = new boolean[G.V()];
        this.connectedCompIds = new int[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!this.marked[v]) {
                this.dfs(G, v);
                count++;
            }
        }
    }

    private void dfs(Graph G, int v) {
        this.marked[v] = true;
        this.connectedCompIds[v] = count;
        for (int i : G.adj(v)) {
            if (!this.marked[i]) {
                this.dfs(G, i);
            }
        }
    }

    public boolean connected(int v, int w) {
        return this.connectedCompIds[v] == this.connectedCompIds[w];
    }

    public int id(int v) {
        return this.connectedCompIds[v];
    }

    public int count() {
        return this.count;
    }
}