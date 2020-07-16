package E_3_4_20;

import edu.princeton.cs.algs4.StdIn;

public class Client {
    public static void main(String[] args) {
        LinProbeHash<String, Integer> st = new LinProbeHash<String, Integer>();
        int minlength = 8;
        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            if (word.length() < minlength) {
                continue;
            }
            Integer wc = st.get(word);
            if (wc == null) {
                st.put(word, 1);
            } else {
                st.put(word, wc + 1);
            }
        }
        st.searchHit();
    }
}