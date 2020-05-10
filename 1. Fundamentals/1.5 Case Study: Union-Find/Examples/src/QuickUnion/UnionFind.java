package QuickUnion;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UnionFind {
    private int count;
    private int[] id;

    public UnionFind(int N) {
        this.id = new int[N];
        this.count = N;
        for (int i = 0; i < id.length; i++) {
            this.id[i] = i;
        }
    }

    public int find(int p) {
        while (p != this.id[p]) {
            p = this.id[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ) {
            return;
        }

        this.id[rootP] = rootQ;
        this.count--;
    }

    public int count() {
        return this.count;
    }

    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        return rootP == rootQ;
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