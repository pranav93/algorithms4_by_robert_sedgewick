package E_3_5_1.HashSET;

import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        String[] strArr = "S E A R C H E X A M P L E".split(" ");
        HashSET<String> set = new HashSET<String>();

        for (int i = 0; i < strArr.length; i++) {
            set.add(strArr[i]);
        }

        for (String string : set.keys()) {
            StdOut.print("\t" + string);
        }
        StdOut.println();
        for (String string : set.keys()) {
            StdOut.println("contains " + string + " -> " + set.contains(string));
        }
        StdOut.println();
        StdOut.println("size -> " + set.size());

        for (String string : set.keys()) {
            set.remove(string);
        }

        for (String string : set.keys()) {
            StdOut.print("\t" + string);
        }
        StdOut.println();
        StdOut.println("size -> " + set.size());
        StdOut.println("Z -> " + set.contains("Z"));
    }
}