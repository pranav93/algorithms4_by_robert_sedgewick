package E_4_1_22;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class BreadthFirstSearch {
    private final int V;
    Graph G;
    private boolean[] marked;
    private int[] edgeTo;
    private final int source;

    BreadthFirstSearch(Graph G, int s) {
        this.source = s;
        this.G = G;
        this.V = G.V();
        this.marked = new boolean[this.V];
        this.edgeTo = new int[this.V];

        this.bfs();
    }

    private void bfs() {
        Queue<Integer> q = new Queue<Integer>();
        this.marked[this.source] = true;
        this.edgeTo[this.source] = this.source;
        q.enqueue(this.source);

        while (!q.isEmpty()) {
            int v = q.dequeue();
            for (int w : this.G.adj(v)) {
                if (!this.marked[w]) {
                    this.marked[w] = true;
                    this.edgeTo[w] = v;
                    q.enqueue(w);
                }
            }
        }
    }

    public Iterable<Integer> pathTo(int v) {
        Stack<Integer> stack = new Stack<Integer>();
        while (v != this.edgeTo[v]) {
            stack.push(v);
            v = this.edgeTo[v];
        }
        if (v == this.source) {
            stack.push(this.source);
            return stack;
        }
        return null;
    }
}