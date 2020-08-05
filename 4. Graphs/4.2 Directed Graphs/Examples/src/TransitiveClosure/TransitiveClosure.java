package TransitiveClosure;

import Digraph.Digraph;
import DirectedDFS.DirectedDFS;

public class TransitiveClosure {
    private DirectedDFS[] all;

    TransitiveClosure(Digraph G) {
        this.all = new DirectedDFS[G.V()];
        for (int i = 0; i < G.V(); i++) {
            this.all[i] = new DirectedDFS(G, i);
        }
    }

    public boolean reachable(int v, int w) {
        return this.all[v].marked(w);
    }
}