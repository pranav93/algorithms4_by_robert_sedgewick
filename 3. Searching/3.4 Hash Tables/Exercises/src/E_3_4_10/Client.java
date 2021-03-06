package E_3_4_10;

import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        String[] strArr = "E A S Y Q U T I O N".split(" ");
        LinProbeHash<Integer> st = new LinProbeHash<Integer>();
        for (int i = 0; i < strArr.length; i++) {
            st.put(strArr[i], i);
        }

        for (String string : st.keys()) {
            StdOut.println(string + " -> " + st.get(string));
        }
        StdOut.println("------------------------");
        StdOut.println("size -> " + st.size());

        for (String string : st.keys()) {
            StdOut.println(string + " -> " + st.get(string));
            StdOut.println("deleting " + string);
            st.delete(string);
            StdOut.println(string + " -> " + st.get(string));
            StdOut.println("size -> " + st.size());
            StdOut.println("****************");
        }
    }
}