package E_1_3_21;

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
        StdOut.println("Enter the value of key to search");
        String k = StdIn.readString();
        ll.listContent();
        StdOut.printf("Does list contain key %s -> %b\n", k, ll.contains(k));
    }
}