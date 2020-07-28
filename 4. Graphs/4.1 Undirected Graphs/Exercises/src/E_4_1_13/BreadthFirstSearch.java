package E_4_1_13;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class BreadthFirstSearch {
    private boolean[] marked;
    private int[] edgeTo;
    private int source;
    private Graph G;

    BreadthFirstSearch(Graph G, int s) {
        int vertices = G.V();
        this.G = G;
        this.source = s;
        this.marked = new boolean[vertices];
        this.edgeTo = new int[vertices];
        bfs(G, s);
    }

    public void bfs(Graph G, int s) {
        this.marked[s] = true;
        Queue<Integer> q = new Queue<Integer>();

        this.marked[s] = true;
        this.edgeTo[s] = s;
        q.enqueue(s);

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
        if (!this.marked[v]) {
            return null;
        }
        Stack<Integer> s = new Stack<Integer>();
        while (v != this.edgeTo[v]) {
            s.push(v);
            v = this.edgeTo[v];
        }
        s.push(this.source);
        return s;
    }

    public int distTo(int v) {
        if (!this.marked[v]) {
            return -1;
        }
        int dist = 0;
        while (v != this.edgeTo[v]) {
            v = this.edgeTo[v];
            dist++;
        }
        return dist;
    }
}