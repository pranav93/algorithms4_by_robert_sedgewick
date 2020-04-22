package ResizingArrayStack;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        ResizingArrayStack<String> rs = new ResizingArrayStack<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (item.equals("-")) {
                if (rs.isEmpty()) {
                    StdOut.printf("%s\n", "No more items in stack");
                    continue;
                }
                StdOut.printf("Popped item is %s\n", rs.pop());
            } else {
                rs.push(item);
            }
        }
        StdOut.printf("%d items are remaining on stack.\n", rs.size());

    }
}