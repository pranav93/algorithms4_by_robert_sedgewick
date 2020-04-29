package E_1_3_28;

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
        int max = ll.max();
        StdOut.println("Max value is -> " + max);
    }
}