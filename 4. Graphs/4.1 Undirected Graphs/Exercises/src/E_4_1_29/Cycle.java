package E_4_1_29;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.SET;

public class Cycle {
    private boolean[] marked;
    private boolean hasCycle;
    private boolean parallelEdge;
    private boolean selfLoop;

    Cycle(Graph G) {
        this.marked = new boolean[G.V()];
        this.findLoopParallelEdge(G);
        if (this.hasCycle) {
            return;
        }
        for (int v = 0; v < G.V(); v++) {
            if (!this.marked[v]) {
                this.dfs(G, v);
            }
        }
    }

    private void findLoopParallelEdge(Graph G) {
        for (int i = 0; i < G.V(); i++) {
            SET<Integer> adjSet = new SET<Integer>();
            for (int w : G.adj(i)) {
                if (w == i) {
                    // self loop found
                    this.hasCycle = true;
                    this.selfLoop = true;
                    return;
                }
                if (!adjSet.contains(w)) {
                    adjSet.add(w);
                } else {
                    // parallel edge found
                    this.parallelEdge = true;
                    this.hasCycle = true;
                    return;
                }
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

    public boolean parallelEdge() {
        return this.parallelEdge;
    }

    public boolean selfLoop() {
        return this.selfLoop;
    }
}