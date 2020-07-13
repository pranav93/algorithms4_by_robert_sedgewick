package E_3_4_3;

import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        String[] strArr = "E A S Y Q U T I O N".split(" ");
        SeqChainHash<String, Integer> st = new SeqChainHash<String, Integer>(5);
        for (int i = 0; i < strArr.length; i++) {
            st.put(strArr[i], i);
        }

        for (String string : st.keys()) {
            StdOut.println(string);
        }
        st.delete("Q");
        st.delete("A");
        st.delete("N");
        StdOut.println("----------------------");
        for (String string : st.keys()) {
            StdOut.println(string);
        }

        st.deleteSeq(4);
        StdOut.println("----------------------");
        for (String string : st.keys()) {
            StdOut.println(string);
        }
    }
}