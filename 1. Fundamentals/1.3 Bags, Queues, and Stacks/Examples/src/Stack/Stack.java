package Stack;

import edu.princeton.cs.algs4.StdOut;

public class Stack<Item> {
    private class Node {
        Item item;
        Node next;
    }

    private int N;
    private Node first;

    public void push(Item item) {
        Node temp = new Node();
        temp.item = item;
        temp.next = this.first;
        this.first = temp;
        this.N++;
    }

    public Item pop() {
        Node temp = this.first;
        this.first = this.first.next;
        this.N--;
        return temp.item;
    }

    public int size() {
        return this.N;
    }

    public boolean isEmpty() {
        return this.N == 0;
    }

    public void traverse() {
        StdOut.printf("HEAD ->\t");
        for (Node n = this.first; n != null; n = n.next) {
            StdOut.print("Node ( " + n.item + " ) ->\t");
        }
        StdOut.println("NULL");
    }
}