package BST;

import java.util.Arrays;

import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.Quick3string;
import edu.princeton.cs.algs4.Quick3way;
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
        StdOut.println("------------------------------");
        String[] strArr = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z".split(" ");
        Quick3way.sort(arr);
        StdOut.println(Arrays.toString(arr));
        for (int i = 0; i < strArr.length; i++) {
            StdOut.println("Floor of " + strArr[i] + " -> " + bst.floor(strArr[i]));
        }
    }

    private static void printAll(String[] arr, BST<String, Integer> bst) {
        for (int i = 0; i < arr.length; i++) {
            StdOut.println(arr[i] + " -> " + bst.get(arr[i]));
        }
    }
}