package FixedCapacityStackOfStrings;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        FixedCapacityStackOfStrings fs = new FixedCapacityStackOfStrings(20);
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (item.equals("-")) {
                StdOut.printf("Popped item is %s\n", fs.pop());
            } else {
                fs.push(item);
            }
        }
        StdOut.printf("%d items are remaining on stack.\n", fs.size());
    }
}