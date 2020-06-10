package BinarySearchST;

import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        ST<String, String> st = new ST<String, String>(10);
        st.put("Martial", "ST");
        st.put("Rashford", "LW");
        st.put("James", "RW");
        st.put("Pogba", "LM");
        st.put("Fernandes", "RM");
        StdOut.println("Martial -> " + st.get("Martial"));
        StdOut.println("Rashford -> " + st.get("Rashford"));
        StdOut.println("DeGea -> " + st.get("DeGea"));
        StdOut.println("size -> " + st.size());
        StdOut.println("------------------------------------------------------------");

        StdOut.println("Printing all players");
        for (String k : st.keys("A", "Z")) {
            StdOut.println(k);
        }

        StdOut.println("------------------------------------------------------------");
        st.put("Rashford", "ST");
        st.put("Martial", "LM");
        st.put("DeGea", "GK");
        StdOut.println("Martial -> " + st.get("Martial"));
        StdOut.println("Rashford -> " + st.get("Rashford"));
        StdOut.println("DeGea -> " + st.get("DeGea"));
        StdOut.println("------------------------------------------------------------");

        StdOut.println("Size -> " + st.size());
        for (String k : st.keys("A", "Z")) {
            StdOut.println("Deleting key -> " + k);
            st.delete(k);
            StdOut.println("Size -> " + st.size());
        }
        StdOut.println("Is empty -> " + st.isEmpty());
        StdOut.println("------------------------------------------------------------");
    }
}