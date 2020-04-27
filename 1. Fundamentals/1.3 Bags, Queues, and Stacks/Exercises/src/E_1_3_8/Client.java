package E_1_3_8;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        DoublingStackOfStrings s = new DoublingStackOfStrings();
        for (;!StdIn.isEmpty();) {
            String item = StdIn.readString();
            if (item.equals("-")) {
                if (s.isEmpty()) {
                    StdOut.println("Stack is empty.");
                } else {
                    StdOut.println("Popped item from stack is -> " + s.pop());
                }
            } else {
                s.push(item);
            }
        }

        StdOut.println("Size of the entire array is -> " + s.arrSize());
        StdOut.println("Content of the entire array is -> " + Arrays.toString(s.arrContent()));
    }
}