package E_1_3_14;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        ResizingArrayQueueOfStrings q = new ResizingArrayQueueOfStrings();

        while (!StdIn.isEmpty()) {
            String input = StdIn.readString();
            if (input.equals("-")) {
                String item = q.deque();
                StdOut.println("Dequed item is -> " + item);
            } else {
                q.enque(input);
            }
        }
    }
}