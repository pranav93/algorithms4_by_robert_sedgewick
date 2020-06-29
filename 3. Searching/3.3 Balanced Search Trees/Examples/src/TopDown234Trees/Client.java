package TopDown234Trees;

import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        BST234<String, Integer> bst = new BST234<String, Integer>();

        String[] strArray = "A C E H L M P R S X".split(" ");
        for (int i = 0; i < strArray.length; i++) {
            bst.put(strArray[i], i);
            StdOut.println(strArray[i] + " inserted");
            StdOut.println("Debug here");
        }

        StdOut.println("Debug here");
    }
}