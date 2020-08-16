package E_4_2_7;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Queue;

public class Degrees {
    private Digraph G;
    private int V;
    private int[] indegree;
    private int[] outdegree;
    private boolean[] marked;

    Degrees(Digraph G) {
        this.G = G;
        this.V = G.V;
        this.marked = new boolean[V];
        this.outdegree = new int[V];
        this.indegree = new int[V];
        for (int i = 0; i < V; i++) {
            if (!marked[i]) {
                bfs(i);                
            }
        }
    }

    private void bfs(int s) {
        Queue<Integer> q = new Queue<>();
        q.enqueue(s);

        while (!q.isEmpty()) {
            int v = q.dequeue();
            if (this.marked[v]) {
                continue;
            }
            this.marked[v] = true;
            
            for (int w : G.adj(v)) {
                if (v == w) {
                    // self loop
                    continue;
                }
                this.outdegree[v]++;
                q.enqueue(w);
                this.indegree[w]++;
            }
        }
    }

    int indegree(int v) {
        return this.indegree[v];
    }

    int outdegree(int v) {
        return this.outdegree[v];
    }

    Iterable<Integer> sources() {
        Bag<Integer> out = new Bag<Integer>();
        for (int i = 0; i < this.V; i++) {
            if (this.indegree[i] == 0) {
                out.add(i);
            }
        }
        return out;
    }

    Iterable<Integer> sinks() {
        Bag<Integer> in = new Bag<Integer>();
        for (int i = 0; i < this.V; i++) {
            if (this.outdegree[i] == 0) {
                in.add(i);
            }
        }
        return in;
    }

    boolean isMap() {
        for (int i = 0; i < this.V; i++) {
            if (this.outdegree[i] != 1) {
                return false;
            }
        }
        return true;
    }
}