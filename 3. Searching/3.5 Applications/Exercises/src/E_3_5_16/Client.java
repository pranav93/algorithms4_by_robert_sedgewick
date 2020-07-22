package E_3_5_16;

import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        int N = 5;
        SparseVector[] a = new SparseVector[N];
        for (int i = 0; i < a.length; i++) {
            a[i] = new SparseVector();
        }
        a[0].put(1, 0.90);
        a[1].put(2, 0.36);
        a[1].put(3, 0.36);
        a[1].put(4, 0.18);
        a[2].put(3, 0.90);
        a[3].put(0, 0.90);
        a[4].put(0, 0.47);
        a[4].put(2, 0.47);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                StdOut.print("\t[" + i + "][" + j + "] => " + a[i].get(j));
            }
            StdOut.println();
        }
        StdOut.println("-----------------------------------------------");

        SparseVector[] b = new SparseVector[N];
        for (int i = 0; i < b.length; i++) {
            b[i] = new SparseVector();
        }
        b[0].put(1, -0.50);
        b[1].put(2, 0.36);
        b[1].put(0, 0.36);
        b[1].put(4, 0.18);
        b[2].put(3, 0.90);
        b[3].put(1, 0.90);
        b[4].put(0, -0.47);
        b[4].put(3, 0.47);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                StdOut.print("\t[" + i + "][" + j + "] => " + b[i].get(j));
            }
            StdOut.println();
        }
        StdOut.println("-----------------------------------------------");

        SparseVector[] sum = new SparseVector[N];
        for (int i = 0; i < sum.length; i++) {
            sum[i] = a[i].add(b[i]);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                StdOut.print("\t[" + i + "][" + j + "] => " + sum[i].get(j));
            }
            StdOut.println();
        }
    }
}