package E_3_1_8;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FrequencyCounter {
    public static void main(String[] args) {
        ST<String, Integer> st = new ST<String, Integer>();
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

        int maxVal = 0;
        String maxStr = "";
        for (String string : st) {
            int val = st.get(string);
            StdOut.println(string + " -> " + val);
            if (val > maxVal) {
                maxVal = val;
                maxStr = string;
            }
        }
        StdOut.println("Frequently used string is \"" + maxStr + "\" with frequency " + maxVal);
    }
}