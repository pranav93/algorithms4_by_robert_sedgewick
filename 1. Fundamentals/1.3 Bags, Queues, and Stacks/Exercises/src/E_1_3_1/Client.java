package E_1_3_1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        StdOut.printf("Enter the size of stack that you want -> \t");
        int cap = StdIn.readInt();
        StdOut.println();
        FixedCapacityStackOfStrings s = new FixedCapacityStackOfStrings(cap);

        while (!StdIn.isEmpty()) {
            String input = StdIn.readString();
            if (input.equals("-")) {
                if (s.isEmpty()) {
                    StdOut.println("Stack is empty");
                } else {
                    StdOut.printf("Popped item from stack is -> %s\n", s.pop());
                }
            } else {
                if (s.isFull()) {
                    StdOut.printf("Stack is full\n");
                } else {
                    s.push(input);
                }
            }
        }

        StdOut.println("Remaining stack is");
        for (String st : s) {
            StdOut.println(st);
        }
    }
}