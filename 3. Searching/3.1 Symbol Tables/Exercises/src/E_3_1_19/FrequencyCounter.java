package E_3_1_19;

import E_3_1_12.BinarySearchST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FrequencyCounter {
    public static void main(String[] args) {
        BinarySearchST<String, Integer> st = new BinarySearchST<String, Integer>();
        while (!StdIn.isEmpty()) {
            String str = StdIn.readString();
            str = str.trim();
            str = str.replaceAll("[.\"?,.;]", "");
            if (str.length() < 10) {
                continue;
            }
            Integer val = st.get(str);
            if (val != null) {
                st.put(str, val + 1);
            } else {
                st.put(str, 1);
            }
        }

        for (String k : st.keys()) {
            StdOut.println(k + " -> " + st.get(k));
        }
    }
}