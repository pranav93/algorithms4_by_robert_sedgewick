package E_1_3_31;

import edu.princeton.cs.algs4.StdOut;

public class DoubleLinkedList {
    class Node {
        String item;
        Node prev;
        Node next;
    }

    Node first;
    Node last;
    int N;

    public boolean isEmpty() {
        return this.N == 0;
    }

    public int size() {
        return this.N;
    }

    public void insertBegin(String item) {
        Node temp = new Node();
        temp.item = item;
        if (this.isEmpty()) {
            this.first = temp;
            this.last = temp;
        } else {
            temp.next = this.first;
            this.first.prev = temp;
            this.first = temp;
        }
        this.N++;
    }

    public void insertEnd(String item) {
        Node temp = new Node();
        temp.item = item;
        if (this.isEmpty()) {
            this.first = temp;
            this.last = temp;
        } else {
            temp.prev = this.last;
            this.last.next = temp;
            this.last = temp;
        }
        this.N++;
    }

    public String removeBegin() {
        Node temp = this.first;
        this.first = this.first.next;
        this.first.prev = null;
        temp.next = null;
        this.N--;
        return temp.item;
    }

    public String removeEnd() {
        Node temp = this.last;
        this.last = this.last.prev;
        this.last.next = null;
        temp.prev = null;
        this.N--;
        return temp.item;
    }

    public boolean insertAfter(String key, String item) {
        Node current = this.first;
        while (current != null && !current.item.equals(key)) {
            current = current.next;
        }
        if (current == null) {
            return false;
        }

        Node temp = new Node();
        temp.item = item;

        if (current.next == null) {
            temp.prev = current;
            current.next = temp;
            this.last = temp;
        } else {
            temp.next = current.next;
            current.next.prev = temp;
            temp.prev = current;
            current.next = temp;
        }
        this.N++;
        return true;
    }

    public boolean insertBefore(String key, String item) {
        Node current = this.first;
        while (current != null && !current.item.equals(key)) {
            current = current.next;
        }
        if (current == null) {
            return false;
        }

        Node temp = new Node();
        temp.item = item;
        if (current.prev == null) {
            current.prev = temp;
            temp.next = current;
            this.first = temp;
        } else {
            temp.next = current;
            temp.prev = current.prev;
            current.prev.next = temp;
            current.prev = temp;
        }
        this.N++;
        return true;
    }

    public boolean remove(String key) {
        Node current = this.first;
        while (current != null && !current.item.equals(key)) {
            current = current.next;
        }
        if (current == null) {
            return false;
        }
        if (current.next == null && current.prev == null) {
            this.first = null;
            this.last = null;
            this.N--;
            return true;
        }
        if (current.next == null) {
            this.last = current.prev;
            this.last.next = null;
            current.prev = null;
            this.N--;
            return true;
        }
        if (current.prev == null) {
            this.first = current.next;
            this.first.prev = null;
            current.next = null;
            this.N--;
            return true;
        }
        current.prev.next = current.next;
        current.next.prev = current.prev;
        current.next = null;
        current.prev = null;
        this.N--;
        return true;
    }

    public void content() {
        StdOut.printf("First ->\t");
        Node current = this.first;
        while (current != null) {
            StdOut.printf("<- Node [ %s ] ->\t", current.item);
            current = current.next;
        }
        StdOut.printf("<- Last\n");
    }
}