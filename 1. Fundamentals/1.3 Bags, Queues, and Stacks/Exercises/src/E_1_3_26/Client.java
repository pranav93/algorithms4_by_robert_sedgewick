package E_1_3_26;

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

        ll.listContent();
        StdOut.println("Enter the value of key for which nodes to be deleted");
        String k = StdIn.readString();
        ll.remove(k);
        StdOut.println("After removing the key, the contents of linked list are -> ");
        ll.listContent();
    }
}