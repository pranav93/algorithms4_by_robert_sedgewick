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

    public int diameter() {
        int maxEcc = Integer.MIN_VALUE;
        int count = 0;
        int chunk = 100;
        for (int i = 0; i < this.V; i++) {
            if (this.connectedComponents.connections[i] == compId) {
                int ecci = this.eccentricity(i);
                count++;
                if (ecci > maxEcc) {
                    maxEcc = ecci;
                }
                if (count % chunk == 0) {
                    StdOut.println("processed count -> " + count + " / " + this.compSize);
                }
            }
        }
        StdOut.println("------------------------");
        return maxEcc;
    }

    public int radius() {
        int minEcc = Integer.MAX_VALUE;
        int count = 0;
        int chunk = 100;
        for (int i = 0; i < this.V; i++) {
            if (this.connectedComponents.connections[i] == compId) {
                int ecci = this.eccentricity(i);
                count++;
                if (ecci < minEcc) {
                    minEcc = ecci;
                }
                if (count % chunk == 0) {
                    StdOut.println("processed count -> " + count + " / " + this.compSize);
                }
            }
        }
        return minEcc;
    }

    public int center() {
        int radius = this.radius();
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