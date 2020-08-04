package DirectedCycle;

import Digraph.Digraph;
import edu.princeton.cs.algs4.Stack;

public class DirectedCycle {
    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;
    private boolean[] onStack;

    public DirectedCycle(Digraph DG) {
        this.onStack = new boolean[DG.V()];
        this.edgeTo = new int[DG.V()];
        this.marked = new boolean[DG.V()];

        for (int i = 0; i < DG.V(); i++) {
            if (!this.marked[i]) {
                this.edgeTo[i] = i;
                this.dfs(DG, i);
            }
        }
    }

    private void dfs(Digraph DG, int v) {
        this.marked[v] = true;
        this.onStack[v] = true;

        for (int w : DG.adj(v)) {
            if (this.hasCycle()) {
                return;
            } else if (!this.marked[w]) {
                this.edgeTo[w] = v;
                this.dfs(DG, w);
            } else if (this.onStack[w]) {
                this.cycle = new Stack<Integer>();
                for (int x = v; x != w; x = this.edgeTo[x]) {
                    this.cycle.push(x);
                }
                this.cycle.push(w);
                this.cycle.push(v);
            }
        }

        this.onStack[v] = false;
    }

    public boolean hasCycle() {
        return this.cycle != null;
    }

    public Iterable<Integer> cycle() {
        return this.cycle;
    }
}