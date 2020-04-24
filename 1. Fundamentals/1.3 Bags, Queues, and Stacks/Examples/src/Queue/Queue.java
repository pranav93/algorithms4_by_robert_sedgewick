package Queue;

import edu.princeton.cs.algs4.StdOut;

public class Queue<Item> {
    class Node {
        Item item;
        Node next;
    }

    Node first;
    Node last;
    int N;

    public void enqueue(Item item) {
        Node temp = new Node();
        temp.item = item;
        if (this.N == 0) {
            this.first = temp;
            this.last = temp;
        } else {
            this.last.next = temp;
            this.last = this.last.next;
        }
        this.N++;
    }

    public Item deque() {
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
        StdOut.printf("First -> \t");
        for (Node n = this.first; n != null; n = n.next) {
            StdOut.printf("Node( " + n.item + " ) ->\t");
        }
        StdOut.println("<- last [Queue enqueues from here]");
    }
}