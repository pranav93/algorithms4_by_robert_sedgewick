package E_1_3_30;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        Integer input = null;
        while (true) {
            input = StdIn.readInt();
            if (input == -1) {
                break;
            }
            ll.insertFirst(input);
        }

        ll.listContent();
        ll.reverseRec();
        StdOut.println("Reversed list is ->");
        ll.listContent();
    }
}