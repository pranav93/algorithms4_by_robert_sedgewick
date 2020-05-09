package QuickFind;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UnionFind {
    private int[] id;
    private int count;

    public UnionFind(int N) {
        this.count = N;
        id = new int[N];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    public int count() {
        return this.count;
    }

    public boolean connected(int p, int q) {
        return this.find(p) == this.find(q);
    }

    public int find(int p) {
        return this.id[p];
    }

    public void union(int p, int q) {
        int pId = this.find(p);
        int qId = this.find(q);

        if (pId == qId) {
            return;
        }

        for (int i = 0; i < this.id.length; i++) {
            if (this.id[i] == pId) {
                this.id[i] = qId;
            }
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