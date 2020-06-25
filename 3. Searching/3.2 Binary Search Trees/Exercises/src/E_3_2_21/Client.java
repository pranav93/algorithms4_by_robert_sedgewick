package E_3_2_21;

import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        String[] strInput = "S E R C H E X M P L E".split(" ");
        BST<String, Integer> st = new BST<String, Integer>();

        for (int i = 0; i < strInput.length; i++) {
            StdOut.println("Putting " + strInput[i] + " -> " + i);
            st.put(strInput[i], i);
        }

        StdOut.println("RandInt -> " + st.selectRandom());
    }
}