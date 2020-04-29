package E_1_3_25;

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
        StdOut.println("Enter the value of key after which to remove the node");
        String k = StdIn.readString();
        StdOut.println("Enter the value to be inserted");
        String val = StdIn.readString();
        StdOut.printf("List item after key %s added -> %b\n", k, ll.insertAfter(k, val));
        ll.listContent();
    }
}