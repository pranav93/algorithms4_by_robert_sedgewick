package Stack;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        Stack<String> s = new Stack<String>();

        while (!StdIn.isEmpty()) {
            String inp = StdIn.readString();
            if (inp.equals("-")) {
                if (s.isEmpty()) {
                    StdOut.println("Stack is empty.");
                } else {
                    StdOut.printf("Removed item is -> %s\n", s.pop());
                }
            } else {
                s.push(inp);
            }
        }

        StdOut.println("Remaining items in stack are ->");
        s.traverse();
    }
}