package E_1_3_31;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        DoubleLinkedList ll = new DoubleLinkedList();
        String input = StdIn.readString();
        while (!input.equals("end")) {
            ll.insertBegin(input);
            input = StdIn.readString();
        }
        ll.content();

        StdOut.println("Provide the key after which you want to insert the value");
        String key = StdIn.readString();
        StdOut.println("Provide the value to be inserted");
        String item = StdIn.readString();
        ll.insertAfter(key, item);
        ll.content();

        StdOut.println("Provide the key before which you want to insert the value");
        key = StdIn.readString();
        StdOut.println("Provide the value to be inserted");
        item = StdIn.readString();
        ll.insertBefore(key, item);
        ll.content();

        StdOut.println("RemoveBegin");
        ll.removeBegin();
        ll.content();

        StdOut.println("RemoveEnd");
        ll.removeEnd();
        ll.content();

        StdOut.println("Provide the value to be deleted");
        item = StdIn.readString();
        ll.remove(item);
        ll.content();
    }
}