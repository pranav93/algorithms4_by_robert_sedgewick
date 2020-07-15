package E_3_4_18;

import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        String[] strArr = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z".split(" ");
        SeparateChainingHashST<String, Integer> st = new SeparateChainingHashST<String, Integer>(5);
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].equals("Q")) {
                StdOut.println("debug here");
            }
            st.put(strArr[i], i);
        }

        for (String string : st.keys()) {
            StdOut.println(string);
        }
        StdOut.println("------------------------");
        StdOut.println("size -> " + st.size());

    }
}