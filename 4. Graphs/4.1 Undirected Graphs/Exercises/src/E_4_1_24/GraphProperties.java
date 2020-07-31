package E_4_1_24;

import edu.princeton.cs.algs4.StdOut;

class GraphProperties {
    private final ConnectedComponents connectedComponents;
    private int V;
    private int compId;
    private Graph G;
    private int compSize;

    GraphProperties(ConnectedComponents connectedComponents, int compId) {
        this.connectedComponents = connectedComponents;
        this.G = this.connectedComponents.G;
        this.V = this.connectedComponents.V;
        this.compSize = this.connectedComponents.componentSize(compId);
        this.compId = compId;
    }

    public int eccentricity(int v) {
        int maxDist = Integer.MIN_VALUE;
        BreadthFirstSearch bfs = new BreadthFirstSearch(this.G, v);

        for (int i = 0; i < this.V; i++) {
            if (this.connectedComponents.connections[i] == compId) {
                int dist = bfs.distance(i);

                if (dist > maxDist) {
                    maxDist = dist;
                }
            }
        }
        return maxDist;
    }

    public int[] props() {
        int maxEcc = Integer.MIN_VALUE;
        int minEcc = Integer.MAX_VALUE;
        int[] out = new int[3];

        int count = 0;
        int chunk = 500;
        for (int i = 0; i < this.V; i++) {
            if (this.connectedComponents.connections[i] == compId) {
                int ecci = this.eccentricity(i);
                count++;
                if (ecci > maxEcc) {
                    maxEcc = ecci;
                }
                if (ecci < minEcc) {
                    minEcc = ecci;
                }

                if (count % chunk == 0) {
                    StdOut.println("processed percent -> " + ((double) count * 100 / this.compSize));
                }
            }
        }
        out[0] = minEcc;
        out[1] = maxEcc;
        out[2] = this.center(minEcc);
        StdOut.println("------------------------");
        return out;
    }

    public int center(int radius) {
        for (int i = 0; i < this.V; i++) {
            if (this.connectedComponents.connections[i] == compId) {
                int ecci = this.eccentricity(i);
                if (ecci == radius) {
                    return i;
                }

            }
        }
        return Integer.MIN_VALUE;
    }

}