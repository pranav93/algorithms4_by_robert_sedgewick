package E_4_1_24;

public class ConnectedComponents {
    int V;
    Graph G;
    int[] connections;
    private boolean[] marked;
    private int componentCount;
    private int[] componentSize;

    ConnectedComponents(Graph G) {
        this.G = G;
        this.V = G.V();
        this.connections = new int[this.V];
        this.marked = new boolean[this.V];

        for (int i = 0; i < this.V; i++) {
            if (!this.marked[i]) {
                this.dfs(i);
                this.componentCount++;
            }
        }

        this.componentSize = new int[this.componentCount];
        for (int i = 0; i < this.componentCount; i++) {
            this.componentSize[i] = 0;
            for (int j = 0; j < this.V; j++) {
                if (this.connections[j] == i) {
                    this.componentSize[i]++;
                }
            }
        }
    }

    private void dfs(int v) {
        this.marked[v] = true;
        this.connections[v] = this.componentCount;

        for (int w : this.G.adj(v)) {
            if (!this.marked[w]) {
                this.dfs(w);
            }
        }
    }

    public int count() {
        return this.componentCount;
    }

    public int componentSize(int id) {
        return this.componentSize[id];
    }

    public int getVertexFromCompId(int compId) {
        for (int i = 0; i < this.V; i++) {
            if (this.connections[i] == compId) {
                return i;
            }
        }
        return -1;
    }

    public boolean checkVertexInComponent(int v, int compId) {
        return this.connections[v] == compId;
    }

}