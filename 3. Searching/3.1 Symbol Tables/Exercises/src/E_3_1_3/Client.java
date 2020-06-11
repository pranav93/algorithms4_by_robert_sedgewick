package E_3_1_3;

import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        OrderedSequentialSearchST<String, String> st = new OrderedSequentialSearchST<String, String>();
        st.put("Martial", "ST");
        st.put("Rashford", "LW");
        st.put("James", "RW");
        st.put("Pogba", "LM");
        st.put("Fernandes", "RM");

        StdOut.println("--------------------------------------------");

        StdOut.println("Martial -> " + st.get("Martial"));
        StdOut.println("Rashford -> " + st.get("Rashford"));
        StdOut.println("James -> " + st.get("James"));
        StdOut.println("Pogba -> " + st.get("Pogba"));
        StdOut.println("Fernandes -> " + st.get("Fernandes"));
        StdOut.println("DeGea -> " + st.get("DeGea"));

        StdOut.println("--------------------------------------------");
        StdOut.println("size -> " + st.size());
        StdOut.println("isEmpty -> " + st.isEmpty());

        StdOut.println("--------------------------------------------");
        StdOut.println("Printing all players");
        for (String player : st.keys()) {
            StdOut.println(player);
        }
        StdOut.println("--------------------------------------------");
        StdOut.println("Deleting all players");
        StdOut.println("size -> " + st.size());
        for (String player : st.keys()) {
            StdOut.println(player);
            st.delete(player);
            StdOut.println("size -> " + st.size());
        }
        StdOut.println("isEmpty -> " + st.isEmpty());
    }
}