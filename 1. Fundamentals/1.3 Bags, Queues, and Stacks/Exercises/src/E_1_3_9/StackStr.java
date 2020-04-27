package E_1_3_9;

import edu.princeton.cs.algs4.StdOut;

public class StackStr {
    class Node {
        String item;
        Node next;
    }

    private Node first;
    private int N;

    public void push(String item) {
        Node temp = new Node();
        temp.item = item;
        temp.next = this.first;
        this.first = temp;
        this.N++;
    }

    public String pop() {
        Node temp = this.first;
        this.first = this.first.next;
        temp.next = null;
        this.N--;
        return temp.item;
    }

    public String top() {
        return this.first.item;
    }

    public boolean isEmpty() {
        return this.N == 0;
    }

    public void stackContents() {
        StdOut.printf("HEAD -> \t");
        for (Node current = this.first; current != null; current = current.next) {
            StdOut.printf("Node [ %s ] ->\t", current.item);
        }
        StdOut.printf("NULL\n");
    }
}