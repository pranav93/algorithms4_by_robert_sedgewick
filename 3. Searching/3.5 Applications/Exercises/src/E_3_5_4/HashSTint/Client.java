package E_3_5_4.HashSTint;

import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        int[] strArr = new int[] { 11, 22, 33, 44, 55, 66, 77, 88, 99, 100 };
        HashSTint set = new HashSTint();

        for (int i = 0; i < strArr.length; i++) {
            set.add(strArr[i]);
        }

        for (int i : set.keys()) {
            StdOut.print("\t" + i);
        }
        StdOut.println();
        for (int i : set.keys()) {
            StdOut.println("contains " + i + " -> " + set.contains(i));
        }
        StdOut.println();
        StdOut.println("size -> " + set.size());

        set.remove(22);
        set.remove(55);
        for (int i : set.keys()) {
            StdOut.print("\t" + i);
        }
        StdOut.println();
        StdOut.println("size -> " + set.size());
        StdOut.println("2000 -> " + set.contains(2000));
    }
}