package E_4_1_26;

import java.util.Iterator;

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

        this.dfs(this.source);
    }

    private void dfs(int v) {
        this.marked[v] = true;
        this.edgeTo[v] = v;

        Stack<Integer> stack = new Stack<Integer>();
        Stack<Iterator<Integer>> stackitV = new Stack<Iterator<Integer>>();
        Iterator<Integer> itV = this.G.adj(v).iterator();
        stackitV.push(itV);
        stack.push(v);

        while (!stack.isEmpty()) {
            v = stack.peek();
            itV = stackitV.peek();
            while (itV.hasNext()) {
                int w = itV.next();
                if (!this.marked[w]) {
                    this.marked[w] = true;
                    this.edgeTo[w] = v;
                    stack.push(w);
                    stackitV.push(this.G.adj(w).iterator());
                    v = w;
                    itV = stackitV.peek();
                }
            }
            v = stack.pop();
            itV = stackitV.pop();
        }
    }

    public boolean hasPathTo(int v) {
        boolean[] alreadyVisited = new boolean[this.G.V()];
        while (v != this.edgeTo[v]) {
            if (!alreadyVisited[v]) {
                alreadyVisited[v] = true;
            } else {
                break;
            }
            v = this.edgeTo[v];
            StdOut.println(this.SG.name(v));
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
