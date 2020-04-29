package E_1_3_25;

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

    public String delete(int k) {
        Node current = this.first;
        while (k != 1) {
            current = current.next;
            k--;
        }
        Node prev = current;
        current = current.next;
        String item = current.item;
        prev.next = current.next;
        this.N--;
        return item;
    }

    public boolean contains(String key) {
        Node current = this.first;
        while (current != null) {
            if (current.item.equals(key)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean removeAfter(String key) {
        Node current = this.first;
        while (current != null && !current.item.equals(key)) {
            current = current.next;
        }
        if (current == null || current.next == null) {
            return false;
        }
        Node target = current.next;
        current.next = target.next;
        this.N--;
        return true;
    }

    public boolean insertAfter(String key, String val) {
        Node current = this.first;
        while (current != null && !current.item.equals(key)) {
            current = current.next;
        }
        if (current == null) {
            return false;
        }
        Node temp = new Node();
        temp.item = val;
        temp.next = current.next;
        current.next = temp;
        return true;
    }
}