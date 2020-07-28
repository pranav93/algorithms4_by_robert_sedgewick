package E_4_1_16;

public class GraphProperties {
    private Graph G;
    private final int vertices;

    GraphProperties(Graph G) {
        this.G = G;
        this.vertices = this.G.V();
    }

    int eccentricity(int v) {
        int maxDist = Integer.MIN_VALUE;
        for (int i = 0; i < this.vertices; i++) {
            int dist = this.distance(v, i);
            if (dist > maxDist) {
                maxDist = dist;
            }
        }
        return maxDist;
    }

    private int distance(int s, int v) {
        BreadthFirstSearch bfs = new BreadthFirstSearch(G, s);
        return bfs.distance(v);
    }

    int diameter() {
        int maxEcc = Integer.MIN_VALUE;
        for (int i = 0; i < this.G.V(); i++) {
            int ecci = this.eccentricity(i);
            if (ecci > maxEcc) {
                maxEcc = ecci;
            }
        }
        return maxEcc;
    }

    public int radius() {
        int minEcc = Integer.MAX_VALUE;
        for (int i = 0; i < this.G.V(); i++) {
            int ecci = this.eccentricity(i);
            if (ecci < minEcc) {
                minEcc = ecci;
            }
        }
        return minEcc;
    }

    public int center() {
        int radius = this.radius();
        for (int i = 0; i < this.G.V(); i++) {
            int ecci = this.eccentricity(i);
            if (ecci == radius) {
                return i;
            }
        }
        return Integer.MIN_VALUE;
    }
}