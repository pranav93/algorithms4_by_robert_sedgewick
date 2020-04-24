package Bag;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        Bag<String> b = new Bag<String>();

        while (!StdIn.isEmpty()) {
            String inp = StdIn.readString();
            b.add(inp);
        }

        StdOut.println("The items in bag are -> ");
        for (String string : b) {
            StdOut.println(string);
        }
    }
}