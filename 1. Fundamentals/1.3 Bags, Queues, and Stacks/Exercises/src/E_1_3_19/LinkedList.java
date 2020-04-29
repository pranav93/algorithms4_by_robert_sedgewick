package E_1_3_19;

import edu.princeton.cs.algs4.StdOut;

public class LinkedList {
    class Node {
        String item;
        Node next;
    }
    Node first;
    int N;

    public void insertFirst(String item) {
        Node temp = new Node();
        temp.item = item;
        temp.next = this.first;
        this.first = temp;
        this.N++;
    }

    public String removeLast() {
        Node current = this.first;
        while (current.next.next != null) {
            current = current.next;
        }
        Node prev = current;
        current = current.next;
        String item = current.item;
        prev.next = null;
        this.N--;
        return item;
    }

    public boolean isEmpty() {
        return this.N == 0;
    }

    public int size() {
        return this.N;
    }

    public void listContent() {
        Node current = this.first;
        StdOut.printf("First -> \t");
        while (current != null) {
            StdOut.printf("Node [ %s ] -> \t", current.item);
            current = current.next;
        }
        StdOut.printf("NULL\n");
    }
}