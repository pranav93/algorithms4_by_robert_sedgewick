package Queue;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        Queue<String> q = new Queue<String>();

        while (!StdIn.isEmpty()) {
            String inp = StdIn.readString();
            if (inp.equals("-")) {
                if (q.isEmpty()) {
                    StdOut.println("Queue has no items.");
                } else {
                    StdOut.printf("Dequed item is -> %s\n", q.deque());
                }
            } else {
                q.enqueue(inp);
            }
        }

        StdOut.println("Remaining items in queue are -> ");
        q.traverse();
    }
}