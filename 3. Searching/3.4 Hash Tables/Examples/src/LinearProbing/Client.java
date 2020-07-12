package LinearProbing;

import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        LinearProbingHashST<String, Integer> st = new LinearProbingHashST<String, Integer>();
        String[] strArr = "S E A R C H E X A M P L E".split(" ");
        for (int i = 0; i < strArr.length; i++) {
            st.put(strArr[i], i);
        }
        StdOut.println("Debug here");

        for (String str : st.keys()) {
            StdOut.print(str + " -> " + st.get(str) + " |");
        }
        StdOut.println();

        st.delete("R");
        for (String str : st.keys()) {
            StdOut.print(str + " -> " + st.get(str) + " |");
        }
        StdOut.println();

        st.delete("S");
        for (String str : st.keys()) {
            StdOut.print(str + " -> " + st.get(str) + " |");
        }
        StdOut.println();

        st.delete("E");
        for (String str : st.keys()) {
            StdOut.print(str + " -> " + st.get(str) + " |");
        }
        StdOut.println();
    }
}