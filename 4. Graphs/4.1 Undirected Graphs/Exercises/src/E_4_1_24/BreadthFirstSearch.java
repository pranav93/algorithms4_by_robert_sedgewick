package E_4_1_24;

import edu.princeton.cs.algs4.Queue;

public class BreadthFirstSearch {
    private Graph G;
    private final int source;
    private final int vertices;
    boolean[] marked;
    int[] edgeTo;

    BreadthFirstSearch(Graph G, int s) {
        this.G = G;
        this.source = s;
        this.vertices = G.V();

        this.bfs();
    }

    private void bfs() {
        this.edgeTo = new int[this.vertices];
        this.marked = new boolean[this.vertices];

        Queue<Integer> q = new Queue<Integer>();
        edgeTo[this.source] = this.source;
        this.marked[this.source] = true;
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

    public int distance(int v) {
        if (!this.marked[v]) {
            return Integer.MAX_VALUE;
        }
        int depth = 0;
        while (this.source != this.edgeTo[v]) {
            depth++;
            v = this.edgeTo[v];
        }
        depth++;
        return depth;
    }
}