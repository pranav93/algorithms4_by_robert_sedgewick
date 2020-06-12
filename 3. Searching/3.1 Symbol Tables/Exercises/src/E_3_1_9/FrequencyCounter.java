package E_3_1_9;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FrequencyCounter {
    public static void main(String[] args) {
        ST<String, Integer> st = new ST<String, Integer>();
        ST<String, Integer> stInsertProcessedWords = new ST<String, Integer>();

        String lastInsert = "";
        int wc = 0;

        while (!StdIn.isEmpty()) {
            String str = StdIn.readString();
            str = str.trim();
            str = str.replaceAll("[.\"?,.;]", "");
            if (str.length() < 10) {
                continue;
            }
            wc++;
            Integer val = st.get(str);
            if (val != null) {
                st.put(str, val + 1);
            } else {
                lastInsert = str;
                stInsertProcessedWords.put("lastInsert", wc);
                st.put(str, 1);
            }
        }
        StdOut.println("Last inserted string is -> " + lastInsert);
        StdOut.println(
                "Words processed before Last inserted string are -> " + stInsertProcessedWords.get("lastInsert"));
    }
}