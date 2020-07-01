package LLRedBlackBST;

import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        RedBlackBST<String, Integer> bst = new RedBlackBST<String, Integer>();

        String[] strArray = "A C E H L M P R S X".split(" ");
        for (int i = 0; i < strArray.length; i++) {
            bst.put(strArray[i], i);
        }

        for (int i = 0; i < strArray.length; i++) {
            StdOut.println("Min -> " + bst.min());
            StdOut.println("Deleting Min");
            bst.deleteMin();
        }
        StdOut.println("Min -> " + bst.min());

        for (int i = 0; i < strArray.length; i++) {
            bst.put(strArray[i], i);
        }

        for (int i = 0; i < strArray.length; i++) {
            StdOut.println("Max -> " + bst.max());
            StdOut.println("Deleting Max");
            bst.deleteMax();
        }
        StdOut.println("Max -> " + bst.max());

        for (int i = 0; i < strArray.length; i++) {
            bst.put(strArray[i], i);
        }

        String[] deleteStr = new String[] { "P", "X", "R", "C", "S", "H", "M", "E", "L", "A" };
        for (int i = 0; i < deleteStr.length; i++) {
            String str = deleteStr[i];
            bst.delete(str);
        }
    }
}