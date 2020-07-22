package E_3_5_14;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class LookupIndex {
    public static void main(String[] args) {
        In in = new In(args[0]);
        String sp = args[1];
        ST<String, Bag<String>> st = new ST<String, Bag<String>>();

        while (in.hasNextLine()) {
            String[] a = in.readLine().split(sp);
            String key = a[0];
            if (!st.contains(key)) {
                st.put(key, new Bag<String>());
            }

            for (int i = 1; i < a.length; i++) {
                String val = a[i];
                st.get(key).add(val);
            }
        }

        ST<String, Bag<String>> ts = new ST<String, Bag<String>>();
        for (String key : st.keys()) {
            for (String val : st.get(key)) {
                if (!ts.contains(val)) {
                    ts.put(val, new Bag<String>());
                }
                ts.get(val).add(key);
            }
        }

        while (!StdIn.isEmpty()) {
            String query = StdIn.readLine();
            if (st.contains(query)) {
                for (String string : st.get(query)) {
                    StdOut.println(" " + string);
                }
            }
            if (ts.contains(query)) {
                for (String string : ts.get(query)) {
                    StdOut.println(" " + string);
                }
            }
            StdOut.println("============================");
        }
    }
}