package TwoColor;

import Graph.Graph;

public class TwoColor {
    private boolean[] marked;
    private boolean[] vertexColor;
    private boolean isBipartite = true;

    TwoColor(Graph G) {
        this.marked = new boolean[G.V()];
        this.vertexColor = new boolean[G.V()];
        for (int i = 0; i < G.V(); i++) {
            if (!this.marked[i]) {
                this.dfs(G, i);
            }
        }
    }

    private void dfs(Graph G, int v) {
        this.marked[v] = true;

        for (int w : G.adj(v)) {
            if (!this.marked[w]) {
                this.vertexColor[w] = !this.vertexColor[v];
                this.dfs(G, w);
            } else if (this.vertexColor[w] == this.vertexColor[v]) {
                this.isBipartite = false;
            }
        }
    }

    public boolean isBipartite() {
        return this.isBipartite;
    }
}