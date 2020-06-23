package E_3_2_13;

import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        String[] strInput = "S E A R C H E X A M P L E".split(" ");
        BST<String, Integer> st = new BST<String, Integer>();

        for (int i = 0; i < strInput.length; i++) {
            StdOut.println("Putting " + strInput[i] + " -> " + i);
            st.put(strInput[i], i);
        }

        for (int i = 0; i < strInput.length; i++) {
            StdOut.println("get(" + strInput[i] + ") -> " + st.get(strInput[i]));
        }
    }
}