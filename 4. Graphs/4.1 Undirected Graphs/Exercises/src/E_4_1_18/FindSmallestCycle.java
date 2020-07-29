package E_4_1_18;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class FindSmallestCycle {
    private final int V;
    private Graph G;
    private boolean[] marked;
    private int[] edgeTo;
    private int[] weights;
    private int source;

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
                    int girth = this.weights[v] + this.weights[w] + 1;
                    // if (girth == 5) {
                    // StdOut.println("debug here");
                    // }
                    int x = v;
                    SET<Integer> ancestorV = new SET<Integer>();
                    Stack<Integer> s = new Stack<Integer>();
                    while (x != this.edgeTo[x]) {
                        markCycle[x] = true;
                        s.push(x);
                        x = this.edgeTo[x];
                        ancestorV.add(x);
                    }
                    markCycle[x] = true;
                    s.push(x);
                    x = w;
                    Queue<Integer> qp = new Queue<Integer>();
                    int commonAncestor = source;
                    while (x != this.edgeTo[x]) {
                        if (!ancestorV.contains(x)) {
                            qp.enqueue(x);
                        } else {
                            commonAncestor = x;
                            while (s.peek() != x) {
                                s.pop();
                            }
                            while (!s.isEmpty()) {
                                qp.enqueue(s.pop());
                            }
                            break;
                        }
                        x = this.edgeTo[x];
                    }
                    if (qp.isEmpty()) {
                        continue;
                    }

                    for (int i : s) {
                        StdOut.print(" " + i);
                    }
                    for (int i : qp) {
                        StdOut.print(" " + i);
                    }
                    StdOut.println();
                    StdOut.println("Common ancestor " + commonAncestor);
                    StdOut.println("girth -> " + girth);
                    StdOut.println(
                            "commonAncestor this.weights[" + commonAncestor + "] -> " + this.weights[commonAncestor]);
                    StdOut.println("girth - commonAncestor weight -> " + (girth - 2 * this.weights[commonAncestor]));
                    StdOut.println("----------------------------------");
                    return;
                }
            }
        }
    }
}