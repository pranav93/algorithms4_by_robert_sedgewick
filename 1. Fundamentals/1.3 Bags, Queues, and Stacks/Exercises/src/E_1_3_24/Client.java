package E_1_3_24;

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
        StdOut.println("Enter the value of key after which to remove the node");
        String k = StdIn.readString();
        ll.listContent();
        StdOut.printf("List item after key %s removed -> %b\n", k, ll.removeAfter(k));
        ll.listContent();
    }
}