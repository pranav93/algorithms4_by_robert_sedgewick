package E_4_1_8;

import edu.princeton.cs.algs4.UF;

public class Search {
    UF uf;
    int source;

    Search(Graph G, int s) {
        this.source = s;
        int vertices = G.V();
        this.uf = new UF(vertices);

        for (int i = 0; i < vertices; i++) {
            for (int w : G.adj(i)) {
                this.uf.union(i, w);
            }
        }
    }

    boolean marked(int v) {
        return this.uf.connected(this.source, v);
    }

    int count() {
        return this.uf.count();
    }
}