package Topological;

import DepthFirstOrder.DepthFirstOrder;
import Digraph.Digraph;
import DirectedCycle.DirectedCycle;

public class Topological {
    private Iterable<Integer> order;

    public Topological(Digraph G) {
        DirectedCycle DC = new DirectedCycle(G);
        if (!DC.hasCycle()) {
            DepthFirstOrder dfo = new DepthFirstOrder(G);
            this.order = dfo.reversePost();
        }
    }

    public Iterable<Integer> order() {
        return this.order;
    }

    public boolean isDAG() {
        return this.order != null;
    }
}