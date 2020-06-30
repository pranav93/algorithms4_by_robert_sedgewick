package RedBlackBSTPrintable;

import PrintTree.TreePrinter;
import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        RedBlackBST<String, Integer> bst = new RedBlackBST<String, Integer>();

        String[] strArray = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z".split(" ");
        for (int i = 0; i < strArray.length; i++) {
            // StdOut.println("Inserting " + strArray[i]);
            bst.put(strArray[i], i, false);
            // TreePrinter.print(bst.root);
            // StdOut.println("====================================================================================================================");
        }
        StdOut.println("Insertion done");
        TreePrinter.print(bst.root);
        StdOut.println(
                "====================================================================================================================");
        StdOut.println("Deleting min");
        bst.deleteMin(false);
        TreePrinter.print(bst.root);
    }
}