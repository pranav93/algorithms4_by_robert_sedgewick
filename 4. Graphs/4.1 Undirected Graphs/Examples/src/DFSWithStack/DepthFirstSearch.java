package DFSWithStack;

import java.util.Iterator;

import edu.princeton.cs.algs4.Stack;

public class DepthFirstSearch {
    private boolean[] marked;
    private int count;
    private int[] edgeTo;

    public DepthFirstSearch(Graph G, int s) {
        this.marked = new boolean[G.V()];
        this.edgeTo = new int[G.V()];
        this.dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        this.marked[v] = true;
        this.count++;

        Stack<Integer> stack = new Stack<Integer>();
        Stack<Iterator<Integer>> stackitV = new Stack<Iterator<Integer>>();
        Iterator<Integer> itV = G.adj(v).iterator();
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
                    this.count++;
                    stack.push(w);
                    stackitV.push(G.adj(w).iterator());
                    v = w;
                    itV = stackitV.peek();
                }
            }
            v = stack.pop();
            itV = stackitV.pop();
        }
    }

    public boolean marked(int w) {
        return this.marked[w];
    }

    public int count() {
        return this.count;
    }

    public int[] edgeTo() {
        return this.edgeTo;
    }
}