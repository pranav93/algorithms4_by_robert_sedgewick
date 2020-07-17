package InvIndex;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class LookupIndex {
    public static void main(String[] args) {
        In in = new In(args[0]);
        String sp = args[1];
        ST<String, Queue<String>> st = new ST<String, Queue<String>>();
        ST<String, Queue<String>> ts = new ST<String, Queue<String>>();

        while (in.hasNextLine()) {
            String[] a = in.readLine().split(sp);
            String key = a[0];
            if (!st.contains(key)) {
                st.put(key, new Queue<String>());
            }

            for (int i = 1; i < a.length; i++) {
                String val = a[i];
                if (!ts.contains(val)) {
                    ts.put(val, new Queue<String>());
                }
                st.get(key).enqueue(val);
                ts.get(val).enqueue(key);
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
        }
    }
}