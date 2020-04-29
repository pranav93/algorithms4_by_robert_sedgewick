package E_1_3_15;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        QueueStr q = new QueueStr();

        String input = StdIn.readString();
        while (!input.equals("-")) {
            q.enque(input);
            input = StdIn.readString();
        }

        StdOut.println("Enter the index (index starts from 1) from last");
        int index = StdIn.readInt();
        String item = "";
        index = q.size() - index + 1;
        if (index < 0) {
            throw new IllegalArgumentException("Index is illegal");
        }
        while (index != 0) {
            item = q.deque();
            index--;
        }
        StdOut.printf("Item -> %s\n", item);
    }
}