package BreadthFirstPaths;

import Graph.Graph;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class BreathFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    int s;

    public BreathFirstPaths(Graph G, int s) {
        this.s = s;
        this.marked = new boolean[G.V()];
        this.edgeTo = new int[G.V()];
        this.bfs(G, s);
    }

    private void bfs(Graph G, int s) {
        Queue<Integer> q = new Queue<Integer>();
        this.marked[s] = true;
        q.enqueue(s);

        while (!q.isEmpty()) {
            int current = q.dequeue();
            for (int i : G.adj(current)) {
                if (!this.marked[i]) {
                    this.edgeTo[i] = current;
                    this.marked[i] = true;
                    q.enqueue(i);
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return this.marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!this.hasPathTo(v)) {
            return null;
        }
        Stack<Integer> path = new Stack<Integer>();
        for (int i = v; i != s; i = this.edgeTo[i]) {
            path.push(i);
        }
        path.push(s);
        return path;
    }
}