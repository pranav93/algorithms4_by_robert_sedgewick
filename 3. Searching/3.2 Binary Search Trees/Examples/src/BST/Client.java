package BST;

import java.util.Arrays;

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
        StdOut.println("------------------------------");
        Quick3way.sort(arr);
        StdOut.println(Arrays.toString(arr));
        printFloor(strArr, bst);
        StdOut.println("------------------------------");
        StdOut.println(Arrays.toString(arr));
        printCeiling(strArr, bst);
        StdOut.println("------------------------------");
        for (int i = 0; i < 10; i++) {
            StdOut.println("select(" + i + ") -> " + bst.select(i));
        }
        StdOut.println("------------------------------");
        String[] keyArr = "A C E H L M P R S X".split(" ");
        for (int i = 0; i < keyArr.length; i++) {
            StdOut.println("select(" + keyArr[i] + ") -> " + bst.rank(keyArr[i]));
        }
        StdOut.println("select(" + "Z" + ") -> " + bst.rank("Z"));
        StdOut.println("------------------------------");
        for (int i = 0; i < 10; i++) {
            StdOut.println("Smallest key is -> " + bst.min());
            bst.deleteMin();
            StdOut.println("ran deleteMin()");
        }
        arr = "S E A R C H E X A M P L E".split(" ");
        for (int i = 0; i < arr.length; i++) {
            bst.put(arr[i], i);
        }
        StdOut.println("------------------------------");
        for (int i = 0; i < 10; i++) {
            StdOut.println("Largest key is -> " + bst.max());
            bst.deleteMax();
            StdOut.println("ran deleteMax()");
        }
        for (int i = 0; i < arr.length; i++) {
            bst.put(arr[i], i);
        }
        StdOut.println("------------------------------");
        StdOut.println("size -> " + bst.size());
        for (int i = 0; i < 10; i++) {
            StdOut.println("get(" + keyArr[i] + ") -> " + bst.get(keyArr[i]));
            StdOut.println("Deleting \"" + keyArr[i] + "\"");
            bst.delete(keyArr[i]);
            StdOut.println("get(" + keyArr[i] + ") -> " + bst.get(keyArr[i]));
            StdOut.println("size -> " + bst.size());
            StdOut.println("************");
        }
        StdOut.println("------------------------------");
        for (int i = 0; i < arr.length; i++) {
            bst.put(arr[i], i);
        }
        for (String str : bst.keys()) {
            StdOut.print(str + " ");
        }
        StdOut.println();
        for (String str : bst.keys("E", "R")) {
            StdOut.print(str + " ");
        }
        StdOut.println();
    }

    private static void printAll(String[] arr, BST<String, Integer> bst) {
        for (int i = 0; i < arr.length; i++) {
            StdOut.println(arr[i] + " -> " + bst.get(arr[i]));
        }
    }

    private static void printFloor(String[] arr, BST<String, Integer> bst) {
        for (int i = 0; i < arr.length; i++) {
            StdOut.println("Floor of " + arr[i] + " -> " + bst.floor(arr[i]));
        }
    }

    private static void printCeiling(String[] arr, BST<String, Integer> bst) {
        for (int i = 0; i < arr.length; i++) {
            StdOut.println("Ceiling of " + arr[i] + " -> " + bst.ceiling(arr[i]));
        }
    }

}