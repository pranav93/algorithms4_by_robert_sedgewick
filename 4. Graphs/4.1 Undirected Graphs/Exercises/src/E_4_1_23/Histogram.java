package E_4_1_23;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.ST;

public class Histogram {
    private final int source;
    private final int V;
    private boolean[] marked;
    private ST<Integer, SET<Integer>> histogramSt;
    private ST<Integer, Integer> histogramCountSt;
    private int[] depth; // depth of vertex from source
    private int[] actorNumber; // Bacon number
    private Graph G;

    public Histogram(Graph G, int s) {
        this.G = G;
        this.source = s;
        this.V = G.V();
        this.marked = new boolean[this.V];
        this.depth = new int[this.V];
        this.actorNumber = new int[this.V];
        this.histogramSt = new ST<Integer, SET<Integer>>();
        this.histogramCountSt = new ST<Integer, Integer>();

        this.bfs();
    }

    private void bfs() {
        Queue<Integer> q = new Queue<Integer>();

        this.marked[this.source] = true;
        this.depth[this.source] = 0;
        q.enqueue(this.source);

        while (!q.isEmpty()) {
            int v = q.dequeue();
            for (int w : this.G.adj(v)) {
                if (!this.marked[w]) {
                    this.marked[w] = true;
                    this.depth[w] = this.depth[v] + 1;
                    q.enqueue(w);
                }
            }
        }

        this.histogramSt = new ST<Integer, SET<Integer>>();

        // this is bipartite graph. So the bacon number is (depth / 2)
        for (int i = 0; i < this.V; i++) {
            if (this.marked[i]) {
                // marked vertices are connected to source
                int depth = this.depth[i];
                if (depth % 2 == 0) {
                    // These are actors
                    this.actorNumber[i] = this.depth[i] / 2;
                    // populate histogram
                    if (this.histogramSt.contains(this.actorNumber[i])) {
                        this.histogramSt.get(this.actorNumber[i]).add(i);
                    } else {
                        SET<Integer> histVal = new SET<Integer>();
                        histVal.add(i);
                        this.histogramSt.put(this.actorNumber[i], histVal);
                    }
                } else {
                    // These are movies
                    this.actorNumber[i] = Integer.MIN_VALUE;
                }
            } else {
                // unmarked marked vertices are not connected to source
                this.actorNumber[i] = Integer.MAX_VALUE;
                if (this.histogramSt.contains(this.actorNumber[i])) {
                    this.histogramSt.get(this.actorNumber[i]).add(i);
                } else {
                    SET<Integer> histVal = new SET<Integer>();
                    histVal.add(i);
                    this.histogramSt.put(this.actorNumber[i], histVal);
                }
            }
        }

        for (Integer i : this.histogramSt.keys()) {
            this.histogramCountSt.put(i, this.histogramSt.get(i).size());
        }
    }

    public ST<Integer, SET<Integer>> histogram() {
        return this.histogramSt;
    }

    public ST<Integer, Integer> histogramCount() {
        return this.histogramCountSt;
    }
}