package E_4_1_3;

public class CopyGraph {
    public static Graph copy(Graph G) {
        int V = G.V();
        Graph newG = new Graph(V);
        for (int i = 0; i < V; i++) {
            for (int w : G.adj(i)) {
                newG.addEdge(i, w);
            }
        }
        return newG;
    }
}