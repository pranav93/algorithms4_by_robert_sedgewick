package LinkedList;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<String>();

        while(!StdIn.isEmpty()) {
            String inp = StdIn.readString();
            if (inp.equals("-")) {
                if (ll.isEmpty()) {
                    StdOut.println("There are no items in linked list.");
                } else {
                    StdOut.printf("removed Item -> %s\n", ll.removeBegin());
                }
            } else {
                ll.addBegin(inp);
            }
        }

        ll.traverse();
    }
}