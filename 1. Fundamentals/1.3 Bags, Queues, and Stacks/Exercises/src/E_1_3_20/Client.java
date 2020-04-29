package E_1_3_20;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        String input = "";
        while (true) {
            input = StdIn.readString();
            if (input.equals("-")) {
                break;
            }
            ll.insertFirst(input);
        }
        StdOut.println("Enter the value of k (index starts from 1)");
        int k = StdIn.readInt();
        ll.listContent();
        StdOut.println("kth element in linked list is -> " + ll.delete(k - 1));
        ll.listContent();
    }
}