package White;

import Hashset.Hashset;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Whitefilter {
    public static void main(String[] args) {
        Hashset<String> set = new Hashset<String>();
        In in = new In(args[0]);
        while (!in.isEmpty()) {
            String key = in.readString();
            if (!set.contains(key)) {
                set.add(key);
                StdOut.println(key);
            }
        }
        while (!StdIn.isEmpty()) {
            String key = StdIn.readString();
            if (set.contains(key)) {
                StdOut.println("Set contains key -> " + key);
            }
        }

    }
}