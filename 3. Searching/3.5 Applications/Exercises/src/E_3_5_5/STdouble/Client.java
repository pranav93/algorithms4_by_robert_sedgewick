package E_3_5_5.STdouble;

import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {

        int N = 5;
        SparseVector[] a = new SparseVector[N];
        for (int i = 0; i < a.length; i++) {
            a[i] = new SparseVector();
        }
        double[] x;
        double[] b = new double[N];

        a[0].put(1, 0.90);
        a[1].put(2, 0.36);
        a[1].put(3, 0.36);
        a[1].put(4, 0.18);
        a[2].put(3, 0.90);
        a[3].put(0, 0.90);
        a[4].put(0, 0.47);
        a[4].put(2, 0.47);

        x = new double[] { 0.05, 0.04, 0.36, 0.37, 0.19 };

        for (int i = 0; i < N; i++) {
            b[i] = a[i].dot(x);
        }

        for (int i = 0; i < b.length; i++) {
            StdOut.println(b[i]);
        }

    }
}