package E_3_2_7;

import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        String[] strArr = "S E A R C H E X A M P L E".split(" ");
        BST<String, Integer> bst = new BST<String, Integer>();
        for (int i = 0; i < strArr.length; i++) {
            bst.put(strArr[i], i);
        }
        StdOut.println("E -> " + bst.get("E"));
        StdOut.println("size -> " + bst.size());
        StdOut.println("height -> " + bst.height());
        StdOut.println("avgCompares -> " + bst.avgCompares());
    }
}