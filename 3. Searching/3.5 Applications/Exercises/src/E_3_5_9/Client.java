package E_3_5_9;

import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        BST<Integer, String> st = new BST<Integer, String>();
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

        for (int i : st.keys()) {
            StdOut.println(i + " -> " + st.get(i));
        }

        st.delete(3);
        StdOut.println(st.get(3));
        st.put(3, "3-one");
        st.put(3, "3-two");
        StdOut.println(st.get(3));

        for (int i : st.keys()) {
            StdOut.println(i + " -> " + st.get(i));
        }
    }
}