package LLRedBlackBSTPrintable;

import PrintTree.TreePrinter;
import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        RedBlackBST<String, Integer> bst = new RedBlackBST<String, Integer>();

        String[] strArray = "S E A R C H E X A M P L E".split(" ");
        for (int i = 0; i < strArray.length; i++) {
            bst.put(strArray[i], i, false);
        }
        StdOut.println("Insertion done");
        TreePrinter.print(bst.root);
        StdOut.println("*******************************************************************");
        // for (int i = 0; i < 14; i++) {
        // StdOut.println("Deleting min");
        // bst.deleteMin(false);
        // TreePrinter.print(bst.root);
        // StdOut.println("*******************************************************************");
        // }
        // for (int i = 0; i < 15; i++) {
        // StdOut.println("Deleting max");
        // bst.deleteMax(true);
        // TreePrinter.print(bst.root);
        // StdOut.println("*******************************************************************");
        // }
        String[] deleteStr = new String[] { "P", "X", "R", "C", "S", "H", "M", "E", "L", "A" };
        // String[] deleteStr = new String[] { "P", "X", "R" };
        for (int i = 0; i < deleteStr.length; i++) {
            String str = deleteStr[i];
            bst.delete(str);
            TreePrinter.print(bst.root);
            StdOut.println("Deleted -> " + str);
            StdOut.println("*******************************************************************");
        }

        // bst.delete("C");
        // TreePrinter.print(bst.root);
        // StdOut.println("*******************************************************************");
    }
}