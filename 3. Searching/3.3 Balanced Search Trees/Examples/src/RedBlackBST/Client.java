package RedBlackBST;

import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        RedBlackBST<String, Integer> bst = new RedBlackBST<String, Integer>();

        String[] strArray = "A C E H L M P R S X".split(" ");
        for (int i = 0; i < strArray.length; i++) {
            bst.put(strArray[i], i);
        }

        StdOut.println("Debug here");

        for (int i = 0; i < strArray.length; i++) {
            StdOut.println("Min -> " + bst.min());
            StdOut.println("Deleting Min");
            bst.deleteMin();
        }
        StdOut.println("Min -> " + bst.min());
    }
}