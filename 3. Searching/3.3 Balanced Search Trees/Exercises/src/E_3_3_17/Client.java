package E_3_3_17;

import E_3_3_17.BST.BST;
import E_3_3_17.LLRBT.LLRBT;
import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        BST<String, Integer> bst = new BST<String, Integer>();
        LLRBT<String, Integer> llrbt = new LLRBT<String, Integer>();
        String[] strArr = { "I", "K", "O", "G", "M", "J", "F", "P", "H", "C", "N", "E", "D", "L", "A", "B" };
        for (int i = 0; i < strArr.length; i++) {
            bst.put(strArr[i], i);
            llrbt.put(strArr[i], i);
        }
        bst.print();
        StdOut.println();
        llrbt.print();
        StdOut.println();

        bst = new BST<String, Integer>();
        llrbt = new LLRBT<String, Integer>();
        String[] strArr2 = { "P", "C", "D", "N", "M", "G", "J", "A", "E", "I", "B", "L", "K", "F", "O", "H" };
        for (int i = 0; i < strArr2.length; i++) {
            bst.put(strArr2[i], i);
            llrbt.put(strArr2[i], i);
        }
        bst.print();
        StdOut.println();
        llrbt.print();
        StdOut.println();

    }
}