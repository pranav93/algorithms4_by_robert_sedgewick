package E_3_5_8;

import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        LinearProbingHashST<Integer, String> st = new LinearProbingHashST<Integer, String>();
        st.put(1, "1-one");
        st.put(1, "1-two");
        st.put(1, "1-three");
        StdOut.println(st.get(1));
        st.put(2, "2-two");
        st.put(2, "2-one");
        StdOut.println(st.get(2));
        st.put(3, "3-three");
        st.put(3, "3-one");
        st.put(3, "3-two");
        StdOut.println(st.get(3));
        st.put(4, "4-four");
        st.put(4, "4-one");
        st.put(4, "4-two");
        st.put(4, "4-three");
        StdOut.println(st.get(4));
    }
}