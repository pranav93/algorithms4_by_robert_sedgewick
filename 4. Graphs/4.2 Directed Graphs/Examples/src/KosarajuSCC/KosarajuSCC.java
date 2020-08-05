package KosarajuSCC;

import DepthFirstOrder.DepthFirstOrder;
import Digraph.Digraph;

public class KosarajuSCC {
    private boolean[] marked;
    private int[] id;
    private int count;

    public KosarajuSCC(Digraph G) {
        this.marked = new boolean[G.V()];
        this.id = new int[G.V()];
        this.count = 0;

        DepthFirstOrder dfo = new DepthFirstOrder(G.reverse());
        for (int i : dfo.reversePost()) {
            if (!this.marked[i]) {
                this.dfs(G, i);
                this.count++;
            }
        }
    }

    private void dfs(Digraph G, int v) {
        this.marked[v] = true;
        this.id[v] = this.count;

        for (int w : G.adj(v)) {
            if (!this.marked[w]) {
                this.dfs(G, w);
            }
        }
    }

    public int id(int v) {
        return this.id[v];
    }

    public int count() {
        return this.count;
    }

    public boolean stronglyConnected(int v, int w) {
        return this.id[v] == this.id[w];
    }
}