package E_3_5_11;

import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        int[] keys = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 9, 8, 7, 6, 5, 4, 3, 2, 1, 2, 3, 4, 2, 3, 4, 6, 7, 8, 8,
                6, 4 };
        MultiSET<Integer> set = new MultiSET<Integer>();
        for (int i = 0; i < keys.length; i++) {
            set.add(keys[i]);
        }
        StdOut.println("set size -> " + set.size());

        int[] distKey = new int[] { 0, 11, 100 };
        for (int i = 0; i < distKey.length; i++) {
            StdOut.println(distKey[i] + " -> " + set.contains(distKey[i]));
        }

        for (int i : set.keys()) {
            StdOut.println(i);
        }
        StdOut.println("-------");
        StdOut.println("size -> " + set.size());
        StdOut.println("==================================");
        set.remove(1);
        for (int i : set.keys()) {
            StdOut.println(i);
        }
        StdOut.println("-------");
        StdOut.println("size -> " + set.size());
        StdOut.println("==================================");
        set.remove(2);
        for (int i : set.keys()) {
            StdOut.println(i);
        }
        StdOut.println("-------");
        StdOut.println("size -> " + set.size());
        StdOut.println("==================================");
    }
}