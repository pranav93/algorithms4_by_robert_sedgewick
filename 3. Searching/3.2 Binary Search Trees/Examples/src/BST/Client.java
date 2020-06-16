package BST;

import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        BST<String, Integer> bst = new BST<String, Integer>();
        String[] arr = "S E A R C H E X A M P L E".split(" ");

        for (int i = 0; i < arr.length; i++) {
            bst.put(arr[i], i);
        }
        printAll(arr, bst);
        StdOut.println("------------------------------");
        StdOut.println("Smallest key -> " + bst.min());
        StdOut.println("------------------------------");
        StdOut.println("Largest key -> " + bst.max());
    }

    private static void printAll(String[] arr, BST<String, Integer> bst) {
        for (int i = 0; i < arr.length; i++) {
            StdOut.println(arr[i] + " -> " + bst.get(arr[i]));
        }
    }
}