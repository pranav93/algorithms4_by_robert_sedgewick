package E_3_2_10;

import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        BST<String, Integer> st = new BST<String, Integer>();

        for (int i = 0; i < args.length; i++) {
            String key = args[i];
            st.put(key, i);
        }

        String[] kArr = new String[st.size()];
        int j = 0;
        for (String k : st.keys()) {
            kArr[j++] = k;
            StdOut.print(k + " ");
        }
        StdOut.println();
        StdOut.println("min -> " + st.min());
        StdOut.println("max -> " + st.max());

        String[] arr = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z".split(" ");

        for (int i = 0; i < arr.length; i++) {
            StdOut.println("floor(" + arr[i] + ") -> " + st.floor(arr[i]));
        }

        for (int i = 0; i < arr.length; i++) {
            StdOut.println("ceiling(" + arr[i] + ") -> " + st.ceiling(arr[i]));
        }

        for (int i = 0; i < j; i++) {
            StdOut.println("select(" + i + ") -> " + st.select(i));
        }

        for (int i = 0; i < j; i++) {
            StdOut.println("rank(" + kArr[i] + ") -> " + st.rank(kArr[i]));
        }
        StdOut.println("Rank of Z -> " + st.rank("Z"));

        for (int i = 0; i < j; i++) {
            StdOut.println("Min -> " + st.min());
            st.deleteMin();
        }
        StdOut.println("Min -> " + st.min());

        for (int i = 0; i < args.length; i++) {
            String key = args[i];
            st.put(key, i);
        }

        for (int i = 0; i < j; i++) {
            StdOut.println("Max -> " + st.max());
            st.deleteMax();
        }
        StdOut.println("Max -> " + st.max());

    }
}