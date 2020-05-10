package WeightedQuickUnion;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UnionFind {
    int[] id;
    int count;
    int[] sz;

    public UnionFind(int N) {
        this.count = N;
        this.id = new int[N];
        this.sz = new int[N];
        for (int i = 0; i < N; i++) {
            this.id[i] = i;
            this.sz[i] = 1;
        }
    }

    public int count() {
        return this.count;
    }

    public int find(int p) {
        while (p != this.id[p]) {
            p = this.id[p];
        }
        return p;
    }

    public boolean connected(int p, int q) {
        int rootP = this.find(p);
        int rootQ = this.find(q);
        return rootP == rootQ;
    }

    public void union(int p, int q) {
        int rootP = this.find(p);
        int rootQ = this.find(q);

        if (rootP == rootQ) {
            return;
        }

        if (this.sz[rootP] < this.sz[rootQ]) {
            this.id[rootP] = rootQ;
            this.sz[rootQ] += this.sz[rootP];
        } else {
            this.id[rootQ] = rootP;
            this.sz[rootP] += this.sz[rootQ];
        }
        this.count--;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        UnionFind uf = new UnionFind(N);

        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) {
                continue;
            }
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }

        StdOut.println(uf.count() + " components");
    }
}