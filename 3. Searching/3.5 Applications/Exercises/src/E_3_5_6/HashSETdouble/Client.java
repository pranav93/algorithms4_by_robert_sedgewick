package E_3_5_6.HashSETdouble;

import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        double[] strArr = new double[] { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7, 8.8, 9.9, 10.0 };
        HashSTdouble set = new HashSTdouble();

        for (int i = 0; i < strArr.length; i++) {
            set.add(strArr[i]);
        }

        for (double i : set.keys()) {
            StdOut.print("\t" + i);
        }
        StdOut.println();
        for (double i : set.keys()) {
            StdOut.println("contains " + i + " -> " + set.contains(i));
        }
        StdOut.println();
        StdOut.println("size -> " + set.size());

        set.remove(2.2);
        set.remove(5.5);
        for (double i : set.keys()) {
            StdOut.print("\t" + i);
        }
        StdOut.println();
        StdOut.println("size -> " + set.size());
        StdOut.println("2000 -> " + set.contains(2000));
    }
}