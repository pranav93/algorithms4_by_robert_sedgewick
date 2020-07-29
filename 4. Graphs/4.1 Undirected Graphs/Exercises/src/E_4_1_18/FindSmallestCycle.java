package E_4_1_18;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class FindSmallestCycle {
    private final int V;
    private Graph G;
    private boolean[] marked;
    private int[] edgeTo;
    private int[] weights;
    private int source;
    private Queue<Integer> path = new Queue<Integer>();
    private int cycleSize;

    FindSmallestCycle(Graph G, int i) {
        this.source = i;
        this.G = G;
        this.V = G.V();
        this.marked = new boolean[this.V];
        this.edgeTo = new int[this.V];
        this.weights = new int[this.V];
        this.findGirth();
        // assuming a connected graph
    }

    private void findGirth() {
        Queue<Integer> q = new Queue<Integer>();

        this.marked[source] = true;
        this.edgeTo[source] = this.source;
        this.weights[source] = 0;
        q.enqueue(source);

        while (!q.isEmpty()) {
            int v = q.dequeue();
            for (int w : this.G.adj(v)) {
                if (!this.marked[w]) {
                    this.marked[w] = true;
                    this.edgeTo[w] = v;
                    this.weights[w] += this.weights[v] + 1;
                    q.enqueue(w);
                } else {
                    boolean[] markCycle = new boolean[this.V];
                    this.cycleSize = this.weights[v] + this.weights[w] + 1;
                    int x = v;
                    Stack<Integer> s = new Stack<Integer>();
                    while (x != this.edgeTo[x]) {
                        markCycle[x] = true;
                        s.push(x);
                        x = this.edgeTo[x];
                    }
                    markCycle[x] = true;
                    s.push(x);
                    x = w;
                    while (x != this.edgeTo[x]) {
                        this.path.enqueue(x);
                        x = this.edgeTo[x];
                    }
                    if (this.path.isEmpty()) {
                        continue;
                    }
                    while (!s.isEmpty()) {
                        this.path.enqueue(s.pop());
                    }
                    return;
                }
            }
        }
    }

    public int cycleSize() {
        return this.cycleSize;
    }

    public Iterable<Integer> path() {
        return this.path;
    }
}