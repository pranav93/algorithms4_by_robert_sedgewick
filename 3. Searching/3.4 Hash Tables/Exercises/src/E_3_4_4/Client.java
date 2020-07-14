package E_3_4_4;

import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        String[] strArr = "E A S Y Q U T I O N".split(" ");
        SeqChainHash<Integer> st = new SeqChainHash<Integer>(17);
        for (int i = 0; i < strArr.length; i++) {
            st.put(strArr[i], i);
        }

        for (String string : st.keys()) {
            StdOut.println(string);
        }
    }
}