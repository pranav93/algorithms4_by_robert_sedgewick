package E_3_2_6;

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

        StdOut.println("height S -> " + bst.height("S"));
        StdOut.println("height E -> " + bst.height("E"));
        StdOut.println("height A -> " + bst.height("A"));
        StdOut.println("height C -> " + bst.height("C"));
        StdOut.println("height R -> " + bst.height("R"));
        StdOut.println("height H -> " + bst.height("H"));
        StdOut.println("height M -> " + bst.height("M"));
        StdOut.println("height L -> " + bst.height("L"));
        StdOut.println("height P -> " + bst.height("P"));
        StdOut.println("height X -> " + bst.height("X"));

    }
}