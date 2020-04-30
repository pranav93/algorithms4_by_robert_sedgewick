package E_1_3_29;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        QueueCircStr q = new QueueCircStr();

        while (!StdIn.isEmpty()) {
            String input = StdIn.readString();
            if (input.equals("-")) {
                if (q.isEmpty()) {
                    StdOut.println("Queue is empty");
                } else {
                    StdOut.printf("Dequed item is -> %s\n", q.deque());
                }
            } else {
                q.enque(input);
            }
        }
    }
}