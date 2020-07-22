package E_3_5_13;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class LookupCSV {
    public static void main(String[] args) {
        In in = new In(args[0]);
        int keyField = Integer.parseInt(args[1]);
        int valField = Integer.parseInt(args[2]);
        ST<String, String> st = new ST<String, String>();

        while (in.hasNextLine()) {
            String line = in.readLine();
            String[] tokens = line.split(",");
            String key = tokens[keyField];
            String val = tokens[valField];
            st.put(key, val);
        }

        for (String string : st.keys()) {
            StdOut.println(string);
        }

        StdOut.println("=======================");
        for (String string : st.keys("Aspartic Acid", "Threonine")) {
            StdOut.println(string);
        }

    }
}