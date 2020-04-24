package LinkedList;

import edu.princeton.cs.algs4.StdOut;

public class LinkedList<Item> {
    class Node {
        Item item;
        Node next;
    }

    Node first;
    Node last;
    int N;

    public LinkedList() {
        this.first = null;
        this.last = null;
        this.N = 0;
    }

    public void addBegin(Item item) {
        Node temp = new Node();
        temp.item = item;
        temp.next = this.first;
        if (this.last == null) {
            this.last = temp;
        }
        this.first = temp;
        this.N++;
    }

    public void addEnd(Item item) {
        Node temp = new Node();
        temp.item = item;
        if (this.last == null) {
            this.first = temp;
            this.last = temp;
        } else {
            this.last.next = temp;
            this.last = this.last.next;
        }
        this.N++;
    }

    public Item removeBegin() {
        if (this.first == null) {
            throw new Error("List is empty.");
        }
        Node temp = this.first;
        this.first = this.first.next;
        if (this.first == null) {
            this.last = null;
        }
        this.N--;
        return temp.item;
    }

    public void traverse() {
        StdOut.printf("HEAD ->\t");
        for (Node node = this.first; node != null; node = node.next) {
            StdOut.printf("Node( " + node.item + " ) ->\t");
        }
        StdOut.println("NULL");
    }

    public int size() {
        return this.N;
    }

    public boolean isEmpty() {
        return this.N == 0;
    }
}