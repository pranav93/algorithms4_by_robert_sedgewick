package E_4_1_26;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class DepthFirstPaths {
    private int source;
    private int[] edgeTo;
    private boolean[] marked;
    private Graph G;
    private int V;
    private SymbolGraph SG;

    DepthFirstPaths(Graph G, int s, SymbolGraph SG) {
        this.SG = SG;
        this.G = G;
        this.V = G.V();
        this.source = s;

        this.marked = new boolean[this.V];
        this.edgeTo = new int[this.V];

        this.dfs();
    }

    private void dfs() {
        this.marked[this.source] = true;
        this.edgeTo[this.source] = this.source;
        int v = this.source;

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(this.source);

        for (int w : this.G.adj(v)) {
            if (!this.marked[w]) {
                this.marked[w] = true;
                this.edgeTo[w] = v;
                stack.push(w);
                StdOut.println(this.SG.name(v));
                v = w;
            } else {
                v = stack.pop();
            }
        }
    }

    public boolean hasPathTo(int v) {
        while (v != this.edgeTo[v]) {
            v = this.edgeTo[v];
        }
        return v == this.source;
    }

    public Iterable<Integer> pathTo(int v) {
        Stack<Integer> s = new Stack<Integer>();
        while (v != this.edgeTo[v]) {
            s.push(v);
            v = this.edgeTo[v];
        }
        if (v == this.source) {
            s.push(v);
            return s;
        }
        return null;
    }
}
