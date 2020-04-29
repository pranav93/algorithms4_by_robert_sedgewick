package E_1_3_19;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        while (!StdIn.isEmpty()) {
            String input = StdIn.readString();
            if (input.equals("-")) {
                break;
            } else {
                ll.insertFirst(input);
            }
        }
        ll.listContent();
        StdOut.println("Last element in linked list is -> " + ll.removeLast());
        ll.listContent();
    }
}