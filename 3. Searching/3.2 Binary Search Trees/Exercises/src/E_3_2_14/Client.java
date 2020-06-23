package E_3_2_14;

import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        String[] strInput = "S E R C H E X M P L E".split(" ");
        BST<String, Integer> st = new BST<String, Integer>();

        for (int i = 0; i < strInput.length; i++) {
            StdOut.println("Putting " + strInput[i] + " -> " + i);
            st.put(strInput[i], i);
        }

        for (int i = 0; i < strInput.length; i++) {
            StdOut.println("get(" + strInput[i] + ") -> " + st.get(strInput[i]));
        }

        StdOut.println("min() -> " + st.min());
        StdOut.println("max() -> " + st.max());

        String[] strArr = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z".split(" ");
        for (int i = 0; i < strArr.length; i++) {
            StdOut.println("floor(" + strArr[i] + ") -> " + st.floor(strArr[i]));
        }
        for (int i = 0; i < strArr.length; i++) {
            StdOut.println("ceiling(" + strArr[i] + ") -> " + st.ceiling(strArr[i]));
        }

        for (String k : st.keys()) {
            StdOut.println("rank(" + k + ") -> " + st.rank(k));
        }
        StdOut.println("rank(" + "Z" + ") -> " + st.rank("Z"));

        int sz = st.size();
        for (int i = 0; i < sz; i++) {
            StdOut.println("select(" + i + ") -> " + st.select(i));
        }
        StdOut.println("select(" + 11 + ") -> " + st.select(11));
    }

}